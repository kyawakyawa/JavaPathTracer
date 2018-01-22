package pathTracer;

public class NormalRender extends Radiance{
	public FColor radiance(Ray ray) {
		IntersectionPoint intersectionPoint = getIntersectionNearest(ray);
		if(intersectionPoint == null) {
			return new FColor(0,0,0);
		}
		return new FColor(intersectionPoint.getNormal().getX() * 0.5 + 0.5,
				intersectionPoint.getNormal().getY() * 0.5 + 0.5,
				intersectionPoint.getNormal().getZ() * 0.5 + 0.5);
	}
}
