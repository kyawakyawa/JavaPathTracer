package pathTracer;

public class Camera {
	private Vecter3 position = new Vecter3(50,52,220);
	private Vecter3 dir= new Vecter3(0,-0.04f,-1).normalized();
	private Vecter3 up = new Vecter3(0,1,0); 
	
	private int picW = 320;
	private int picH = 240;
	
	private float width;
	private float height;
	
	private float dist = 40.0f;
	
	private Vecter3 x;
	private Vecter3 y;
	private Vecter3 center;
	
	public Camera() {
		setCamera();
	}
	public Camera(int w,int h,Vecter3 p,Vecter3 d,Vecter3 u,float ds) {
		picW = w;picH = h;
		position = p;
		dir = d.normalized();
		up = u;
		ds = dist;
		setCamera();
	}
	
	void setCamera() {
		width = 30.0f * picW / picH;height = 30.0f;
		x = dir.cross(up).normalized().mul(width);
		y = dir.cross(x).normalized().mul(height);
		center = dir.mul(dist);
	}

	public int getPicW() {
		return picW;
	}

	public void setPicW(int picW) {
		this.picW = picW;
	}

	public int getPicH() {
		return picH;
	}

	public void setPicH(int picH) {
		this.picH = picH;
	}
	
	Ray getRay(int sy,int sx,int supersamples,int i ,int j) {
		float d = 1.0f / supersamples;
		float dx = sx * d + d * 0.5f;
		float dy = sy * d + d * 0.5f;
		
		return new Ray(position,center.add(x.mul((j + dx) / picW - 0.5f)).add(y.mul((i + dy) / picH - 0.5f)));
	}
}
