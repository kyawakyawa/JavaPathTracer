package pathTracer;

public class IntersectionPoint {
	private float distance;
	private Vecter3 position;
	private Vecter3 normal;
	private Material material;
	
	public IntersectionPoint () {
		;
	}
	
	public IntersectionPoint(float d,Vecter3 p,Vecter3 n,Material m) {
		distance = d;position = p;normal = n.normalized();material = m;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public Vecter3 getPosition() {
		return position;
	}

	public void setPosition(Vecter3 position) {
		this.position = position;
	}

	public Vecter3 getNormal() {
		return normal;
	}

	public void setNormal(Vecter3 normal) {
		this.normal = normal.normalized();
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
}
