package pathTracer;

public class Ray {
	private Vecter3 origin;
	private Vecter3 direction;
	
	public Ray() {
		;
	}
	
	public Ray(Vecter3 o,Vecter3 d) {
		origin = o;direction = d.normalized();
	}

	public Vecter3 getOrigin() {
		return origin;
	}

	public void setOrigin(Vecter3 origin) {
		this.origin = origin;
	}

	public Vecter3 getDirection() {
		return direction;
	}

	public void setDirection(Vecter3 direction) {
		this.direction = direction.normalized();
	}
	
	
}
