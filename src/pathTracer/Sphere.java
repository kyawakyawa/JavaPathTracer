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
	public float getS() {
		return 4.0f * (float)Math.PI * radius * radius;
	}

	public LightInfo sampleOnePoint() {
		float z = (float)(Math.random() * 2.0 - 1.0);
		float phi = (float) (Math.random() * 2.0 * Math.PI);
		
		float w = (float)Math.sqrt(1.0 - z * z);
		Vecter3 dir = new Vecter3(w * Math.cos(phi),w * Math.sin(phi),z);
		Vecter3 point = center.add(dir.mul(radius));
		Vecter3 normal = dir;
		FColor emission = materials.get(0).getLe();
		float pdf = 1.0f / getS();
		return new LightInfo(point,normal,pdf,emission);
	}
}
