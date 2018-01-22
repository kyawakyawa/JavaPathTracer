package pathTracer;

public class Main {

	public static void main(String[] args) {
		//Render render = new Render(new Camera(320,240,new Vecter3(50,52,220),new Vecter3(0,-0.04f,-1),new Vecter3(0,1,0),40.0f),new Pathtracing(5, 64),"image.ppm");//純粋パストレ
		Render render = new Render(new Camera(320,240,new Vecter3(50,52,220),new Vecter3(0,-0.04f,-1),new Vecter3(0,1,0),40.0f),new PathtracingDirect(5, 64),"image.ppm");//Next Event Estimation
		//Render render = new Render(new NormalRender(),"image.ppm");//法線レンダラ
		
		float a = 0.75f;
		float b = 0.25f;

		render.add(new Sphere(new Vecter3(1e5 + 1.0, 40.8, 81.6), 1e5, new Material(new FColor(a, b, b))));
		render.add(new Sphere(new Vecter3(-1e5 + 99, 40.8, 81.6), 1e5, new Material(new FColor(b, b, a))));
		render.add(new Sphere(new Vecter3(50, 40.8, 1e5), 1e5, new Material(new FColor(a, a, a))));
		render.add(new Sphere(new Vecter3(50, 40.8, -1e5 + 250), 1e5, new Material(new FColor(a, a, a))));
		render.add(new Sphere(new Vecter3(50, 1e5, 81.6),1e5, new Material(new FColor(a, a, a))));
		render.add(new Sphere(new Vecter3(50, -1e5 + 81.6, 81.6), 1e5, new Material(new FColor(a, a, a))));
		render.add(new Sphere(new Vecter3(65, 20, 20), 20, new Material(new FColor(b, a, b))));
		render.add(new Sphere(new Vecter3(27, 16.5, 47), 16.5, new Material(MaterialType.MT_PERFECT_REF)));
		render.add(new Sphere(new Vecter3(77, 16.5, 78), 16.5, new Material(MaterialType.MT_REFRACTION)));
		//render.addAsLight(new Sphere(new Vecter3(50.0, 90.0, 81.6), 15, new Material(new FColor(0.30, 0.30, 0.30), new FColor(36, 36, 36))));//純粋パストレ用の光源
		render.addAsLight(new Sphere(new Vecter3(50.0, 73.0, 81.6), 5, new Material(new FColor(0.30, 0.30, 0.30), new FColor(40, 30.901960, 22.431360))));//NEE用の光源

		render.draw(32,4);//32 * 4 * 4 サンプル
	}

}
