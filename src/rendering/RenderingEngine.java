package rendering;

import components.BaseLight;
import components.Camera;
import engine.GameObject;
import engine.Transform;
import engine.Vector3f;
import resource.MappedValues;

import java.util.ArrayList;
import java.util.HashMap;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_VERSION;

public class RenderingEngine extends MappedValues
{
	private HashMap<String, Integer> m_samplerMap;
	private ArrayList<BaseLight> m_lights;
	private BaseLight m_activeLight;

	private Shader m_forwardAmbient;
	private Camera m_mainCamera;

	public RenderingEngine()
	{
		super();
		m_lights = new ArrayList<BaseLight>();
		m_samplerMap = new HashMap<String, Integer>();
		m_samplerMap.put("diffuse", 0);
		m_samplerMap.put("normalMap", 1);
		m_samplerMap.put("dispMap", 2);

		AddVector3f("ambient", new Vector3f(0.5f, 0.5f, 0.5f));

		m_forwardAmbient = new Shader("forward-ambient");

		glClearColor(0.4f, 0.4f, 1f, 0f);

		glFrontFace(GL_CW);
		glCullFace(GL_BACK);
		//glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);

		//
		// glEnable(GL_DEPTH_CLAMP);

		glEnable(GL_TEXTURE_2D);
	}

	public void UpdateUniformStruct(Transform transform, Material material, Shader shader, String uniformName, String uniformType)
	{
		throw new IllegalArgumentException(uniformType + " is not a supported type in RenderingEngine");
	}

	public void Render(GameObject object)
	{
		if (GetMainCamera() == null) System.err.println("Error! Main camera not found. This is very very big bug, and game will crash.");
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		object.RenderAll(m_forwardAmbient, this);

		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ONE);
		glDepthMask(false);
		glDepthFunc(GL_EQUAL);

		for(BaseLight light : m_lights)
		{
			m_activeLight = light;
			object.RenderAll(light.GetShader(), this);
		}

		glDepthFunc(GL_LESS);
		glDepthMask(true);
		glDisable(GL_BLEND);
	}

	public static String GetOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}

	public void AddLight(BaseLight light)
	{
		m_lights.add(light);
	}

	public void AddCamera(Camera camera)
	{
		m_mainCamera = camera;
	}

	public int GetSamplerSlot(String samplerName)
	{
		return m_samplerMap.get(samplerName);
	}

	public BaseLight GetActiveLight()
	{
		return m_activeLight;
	}

	public Camera GetMainCamera()
	{
		return m_mainCamera;
	}

	public void SetMainCamera(Camera mainCamera)
	{
		this.m_mainCamera = mainCamera;
	}
}
