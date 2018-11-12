package game;

import engine.CoreEngine;

public class Main
{
	public static void main(String[] args)
	{
		CoreEngine engine = new CoreEngine(1000, 500, 60, new MainScene());
		engine.CreateWindow("Landon Dean -- Algebra 2 Engine");
		engine.Start();
	}
}
