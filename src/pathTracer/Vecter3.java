package pathTracer;


public class Vecter3 {
	static final float EPS = 1e-1f;
	static final float INF = 1e12f;
	
	private float x;
	private float y;
	private float z;
	
	public Vecter3() {
		;
	}
	
	public Vecter3(float x,float y,float z) {
		this.x = x;this.y = y;this.z = z;
	}

	public Vecter3(double x,double y,double z) {
		this((float)x,(float)y,(float)z);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public Vecter3 add(Vecter3 obj) {
		return new Vecter3(this.x + obj.x,this.y + obj.y,this.z + obj.z);
	}
	
	public Vecter3 sub(Vecter3 obj) {
		return new Vecter3(this.x - obj.x,this.y - obj.y,this.z - obj.z);
	}

	public Vecter3 mul(Vecter3 obj) {
		return new Vecter3(this.x * obj.x,this.y * obj.y,this.z * obj.z);
	}

	public Vecter3 div(Vecter3 obj) {
		return new Vecter3(this.x / obj.x,this.y / obj.y,this.z / obj.z);
	}

	public Vecter3 mul(float r) {
		return new Vecter3(this.x * r,this.y * r,this.z * r);
	}

	public Vecter3 div(float r) {
		return new Vecter3(this.x / r,this.y / r,this.z / r);
	}
	
	public float dot(Vecter3 obj) {
		return this.x * obj.x + this.y * obj.y + this.z * obj.z;
	}

	public Vecter3 cross(Vecter3 obj) {
		return new Vecter3(
					this.y * obj.z - this.z * obj.y,
					this.z * obj.x - this.x * obj.z,
					this.x * obj.y - this.y * obj.x); 
	}
	
	static public Vecter3 add(Vecter3 a,Vecter3 b) {
		return new Vecter3(a.x + b.x , a.y + b.y , a.z + b.z);
	}

	static public Vecter3 sub(Vecter3 a,Vecter3 b) {
		return new Vecter3(a.x - b.x , a.y - b.y , a.z - b.z);
	}

	static public Vecter3 mul(Vecter3 a,Vecter3 b) {
		return new Vecter3(a.x * b.x , a.y * b.y , a.z * b.z);
	}

	static public Vecter3 div(Vecter3 a,Vecter3 b) {
		return new Vecter3(a.x / b.x , a.y / b.y , a.z / b.z);
	}
	
	static public float dot(Vecter3 a,Vecter3 b) {
		return a.x * b.x + a.y * b.y + a.z * b.z;
	}

	static public Vecter3 cross(Vecter3 a,Vecter3 b) {
		return new Vecter3(
					a.y * b.z - a.z * b.y,
					a.z * b.x - a.x * b.z,
					a.x * b.y - a.y * b.x); 
	}
	
	public float abs() {
		return (float)Math.sqrt(abs_square());
	}

	public float abs_square() {
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}
	
	public Vecter3 normalized() {
		return this.div(this.abs());
	}

	@Override
	public String toString() {
		return "Vecter3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
