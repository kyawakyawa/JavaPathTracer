package pathTracer;

import java.util.ArrayList;

public abstract class Shape {

	protected ArrayList<Material> materials;
	
	protected Shape() {
		materials = new ArrayList<Material>();
	}
	
	protected Shape(ArrayList<Material> m) {
		materials = m;
	}

	public abstract IntersectionPoint getIntersection(Ray ray);
}
