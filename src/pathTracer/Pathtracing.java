package pathTracer;

public class Pathtracing extends Radiance {
	private int minDepth = 4;
	private int maxDepth = 64;
	public Pathtracing () {
		super();
	}

	public Pathtracing(int md,int Md) {
		super();
		minDepth = md;
		maxDepth = Md;
	}
	
	public FColor radiance(Ray ray) {
		return radiance(ray,0);
	}
	
	public FColor radiance(Ray ray,int depth) {
		final IntersectionPoint intersectionPoint = getIntersectionNearest(ray);
		
		if(intersectionPoint == null) {
			return new FColor(0,0,0);
		}
		
		final Material material = intersectionPoint.getMaterial();
		
		final Vecter3 normal = intersectionPoint.getNormal().mul(
				(ray.getDirection().dot(intersectionPoint.getNormal()) < 0.0f) ? 1.0f : -1.0f
				);
		
		FColor L = (ray.getDirection().dot(intersectionPoint.getNormal()) < 0.0) ? material.getLe() : new FColor(0.0f,0.0f,0.0f);
		
		float P = Math.min(1.0f,Math.max(material.getAlbedo().getRed(), Math.max(material.getAlbedo().getGreen(),material.getAlbedo().getBlue())) );
		
		if(depth < minDepth)
			P = 1.0f;

		if(depth >= maxDepth)
			P *= Math.pow(0.5, depth - maxDepth);
		
		if(P < Math.random()) {
			return L;
		}
		
		switch (material.getType()) {

		case MT_DEFAULT : {
			Vecter3 u;
			if(Math.abs(normal.getX()) > Vecter3.EPS) {
				u = (new Vecter3(0,1,0)).cross(normal).normalized();
			}else
				u = (new Vecter3(1,0,0)).cross(normal).normalized();
			Vecter3 v = Vecter3.cross(normal , u);
			
			float u1 = (float)(Math.random() * 2.0 * Math.PI);
			float u2 = (float)Math.random();
			float u3 = (float)Math.sqrt(u2);
			
			Vecter3 omega = 
					u.mul((float)Math.cos(u1) * u3).add(
					v.mul((float)Math.sin(u1) * u3) ).add(
					normal.mul((float)Math.sqrt(1.0 - u2)) );
			
			L = L.add(material.getAlbedo().mul(radiance(new Ray(intersectionPoint.getPosition(),omega),depth + 1)).div(P));
			break;
		}
		case MT_PERFECT_REF : {
			Vecter3 r = normal.mul(normal.dot(ray.getDirection()) * (-2.0f)).add(ray.getDirection());
			Vecter3 p = intersectionPoint.getPosition();
			L = L.add(material.getAlbedo().mul(radiance(new Ray(p,r),depth + 1)).div(P));
			break;
		}
		case MT_REFRACTION : {
			float n = ((ray.getDirection().dot(intersectionPoint.getNormal()) < 0.0) ? 1.0f / material.getScalar() : material.getScalar());
			float dn = ray.getDirection().dot(normal);
			float cos2t = 1.0f - n * n * (1.0f - dn * dn);
			
			Vecter3 p = intersectionPoint.getPosition();
			Vecter3 r = normal.mul(normal.dot(ray.getDirection()) * (-2.0f)).add(ray.getDirection());
			
			if(cos2t < 0.0) {
				L = L.add(material.getAlbedo().mul(radiance(new Ray(p,r),depth + 1)).div(P));
				break;
			}
			
			Vecter3 T = 
				(ray.getDirection().mul(n).sub(normal.mul(n * dn + (float)Math.sqrt(cos2t)))).normalized();
			float a = 1.0f - material.getScalar(),b = 1.0f + material.getScalar();
			float F0 = (a * a) / (b * b);
			
			float Fr = F0 + (1.0f - F0) * (float)Math.pow(1.0 + ((ray.getDirection().dot(intersectionPoint.getNormal()) < 0.0) ? dn : normal.dot(T)), 5);
			float Tr = (1.0f - Fr)  * n * n;
			
			float probability = 0.25f * 0.5f * Fr;
			if(depth > 2) {
				if(Math.random() < probability) {
					L = 
					L.add(material.getAlbedo().mul(radiance(new Ray(p,r),depth + 1)).mul(Fr / P / probability));
				}else {
					L = 
					L.add(material.getAlbedo().mul(radiance(new Ray(p,T),depth + 1)).mul(Tr / P / (1.0f - probability)));
				}
			}else {
				L = 
				L.add(material.getAlbedo().mul(radiance(new Ray(p,r),depth + 1).mul(Fr).add(radiance(new Ray(p,T),depth + 1).mul(Tr))).div(P));
			}
			break;
		}
		default:
			break;
		}
		return L;
	}
}
