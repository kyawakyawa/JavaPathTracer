package pathTracer;

import java.util.ArrayList;

public abstract class Radiance {
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	protected Radiance () {
	}
	
	public abstract FColor radiance(Ray ray) ;
	
	public void set(ArrayList<Shape> s,ArrayList<LightSource> l) {
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
	protected boolean isShadow(Ray ray,Vecter3 lightPoint) {
		float maxT = lightPoint.sub(ray.getOrigin()).abs() - Vecter3.EPS;
		for(Shape shape : shapes) {
			IntersectionPoint intersectionPoint = shape.getIntersection(ray);
			if(intersectionPoint != null && maxT > intersectionPoint.getDistance()) {
				return true;
			}
		}
		return false;
	}
}
