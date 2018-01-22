package pathTracer;

import java.util.ArrayList;

public class Sphere extends Shape {
	private float radius = 1.0f;
	private Vecter3 center = new Vecter3(0,0,0);
	
	public Sphere() {
		super();
	}

	public Sphere(Vecter3 c,float r,Material m) {
		radius = r;
		center = c;
		materials =  new ArrayList<Material>();
		materials.add(m);
	}
	public Sphere(Vecter3 c,double r, Material m) {
		this(c,(float)r,m);
	}
	
	public IntersectionPoint getIntersection(Ray ray) {
		Vecter3 d = ray.getDirection();
		Vecter3 s = ray.getOrigin().sub(center);
		float A = d.abs_square();
		float B = 2 * (s.dot(d));
		float C = s.abs_square() - radius * radius;
		float D = B * B - 4.0f * A * C;
		
		if(D < -Vecter3.EPS)
			return null;
		
		float sqrtD = (float)Math.sqrt(D);
		float t = (-B - sqrtD) * 0.5f / A;
		if(t < Vecter3.EPS) {
			t += sqrtD / A;
			if(t < Vecter3.EPS)
				return null;
		}
		
		return new IntersectionPoint(t,ray.getOrigin().add(d.mul(t)),s.add(d.mul(t)),materials.get(0));
	}
}
