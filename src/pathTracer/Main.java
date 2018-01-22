package pathTracer;

public class Main {

	public static void main(String[] args) {
		Render render = new Render(new Pathtracing(5, 64),"image.ppm");
		//Render render = new Render(new NormalRender(),"image.ppm");
		
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
		render.add(new Sphere(new Vecter3(50.0, 90.0, 81.6), 15, new Material(new FColor(0.30, 0.30, 0.30), new FColor(36, 36, 36))));

		render.draw(4,4);
	}

}
