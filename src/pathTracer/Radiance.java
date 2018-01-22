package pathTracer;

import java.util.ArrayList;

public abstract class Radiance {
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	protected Radiance () {
	}
	
	public abstract FColor radiance(Ray ray) ;
	
	public void setShapes(ArrayList<Shape> s) {
		shapes = s;
	}
	
	protected IntersectionPoint getIntersectionNearest(Ray ray) {
		float min_t = Vecter3.INF;
		
		IntersectionPoint ret = null;
		
		for(Shape shape : shapes) {
			IntersectionPoint intersectionPoint = shape.getIntersection(ray);
			
			if(intersectionPoint != null && intersectionPoint.getDistance() < min_t) {
				ret = intersectionPoint;
				min_t = ret.getDistance();
			}
		}
		
		return ret;
	}
}
