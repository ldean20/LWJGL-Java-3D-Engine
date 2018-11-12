package game;

import components.*;
import engine.*;
import rendering.*;

public class MainScene extends Game
{
	public void Init()
	{
		/*
		* CAMERA ---
		*/
				
		AddObject(
				//AddObject(
				new GameObject().AddComponent(new FreeLook(0.5f)).AddComponent(new FreeMove(10.0f))
						.AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(70.0f),
								(float) Window.GetWidth() / (float) Window.GetHeight(), 0.01f, 1000.0f))));
				
		/*
		* CAMERA ---
		*/
			
		
		/*
		 * SCENE ---
		 */
		
		//Bricks -- 
		
		Mesh BrickMesh = new Mesh("Floor/Bricks.obj");

		Material BrickMaterial = new Material(new Texture("Bricks/Bricks.jpg"), 1, 8,
				new Texture("Bricks/Bricks_Normal.png"), new Texture("Bricks/Disp.jpg"), 0.033f, -0.75f);

		MeshRenderer BrickRender_0 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_0 = new GameObject();
		Bricks_0.AddComponent(BrickRender_0);
		Bricks_0.GetTransform().GetPos().Set(0f, -5f, 0f);
		
		AddObject(Bricks_0);
		
		MeshRenderer BrickRender_1 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_1 = new GameObject();
		Bricks_1.AddComponent(BrickRender_1);
		Bricks_1.GetTransform().GetPos().Set(0f, -5f, 16.09f);
		
		AddObject(Bricks_1);
		
		MeshRenderer BrickRender_2 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_2 = new GameObject();
		Bricks_2.AddComponent(BrickRender_2);
		Bricks_2.GetTransform().GetPos().Set(16.09f, -5f, 16.09f);
		
		AddObject(Bricks_2);
		
		MeshRenderer BrickRender_3 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_3 = new GameObject();
		Bricks_3.AddComponent(BrickRender_3);
		Bricks_3.GetTransform().GetPos().Set(16.09f, -5f, 0f);
		
		AddObject(Bricks_3);
		
		MeshRenderer BrickRender_4 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_4 = new GameObject();
		Bricks_4.AddComponent(BrickRender_4);
		Bricks_4.GetTransform().GetPos().Set(16.09f, -5f, -16.09f);
		
		AddObject(Bricks_4);
		
		MeshRenderer BrickRender_5 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_5 = new GameObject();
		Bricks_5.AddComponent(BrickRender_5);
		Bricks_5.GetTransform().GetPos().Set(0f, -5f, -16.09f);
		
		AddObject(Bricks_5);
		
		MeshRenderer BrickRender_6 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_6 = new GameObject();
		Bricks_6.AddComponent(BrickRender_6);
		Bricks_6.GetTransform().GetPos().Set(-16.09f, -5f, -16.09f);
		
		AddObject(Bricks_6);
		
		MeshRenderer BrickRender_7 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_7 = new GameObject();
		Bricks_7.AddComponent(BrickRender_7);
		Bricks_7.GetTransform().GetPos().Set(-16.09f, -5f, 0f);
		
		AddObject(Bricks_7);
		
		MeshRenderer BrickRender_8 = new MeshRenderer(BrickMesh, BrickMaterial);

		GameObject Bricks_8 = new GameObject();
		Bricks_8.AddComponent(BrickRender_8);
		Bricks_8.GetTransform().GetPos().Set(-16.09f, -5f, 16.09f);
		
		AddObject(Bricks_8);
		
		//Bricks -- 
		
		//Knight --
		
		Mesh HeartMesh = new Mesh("Obj/Heart.obj");

		Material HeartMaterial = new Material(new Texture("Bricks/Bricks.jpg"), 1, 8,
				new Texture("Bricks/Bricks_Normal.png"), new Texture("Bricks/Disp.jpg"), 0.033f, -0.75f);

		MeshRenderer HeartRender_0 = new MeshRenderer(HeartMesh, HeartMaterial);

		GameObject Heart_0 = new GameObject();
		Heart_0.AddComponent(HeartRender_0);
		Heart_0.GetTransform().GetPos().Set(0f, -4f, 0f);
		
		AddObject(Heart_0);
		
		//Knight -- 
		
		//Lighting -- 
		
		GameObject Sun = new GameObject();
		
		DirectionalLight Sun_c = new DirectionalLight(new Vector3f(0.5f,0.75f,0.5f), 10f);

		Sun.AddComponent(Sun_c);
		
		AddObject(Sun);
		
		//Lighting -- 
		
		
		
		/*
		 * SCENE ---
		 */
		
	}
}
