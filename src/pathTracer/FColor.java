package pathTracer;

public class FColor {
	private float red;
	private float green;
	private float blue;
	
	public FColor() {
		
	}
	
	public FColor  (float r,float g,float b) {
		red = r;green = g;blue = b;
	}

	public FColor  (double r,double g,double b) {
		this((float)r,(float)g,(float)b);
	}

	public float getRed() {
		return red;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public float getGreen() {
		return green;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public float getBlue() {
		return blue;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}
	
	public FColor add(FColor obj) {
		return new FColor(this.red + obj.red,this.green + obj.green,this.blue + obj.blue);
	}
	
	public FColor sub(FColor obj) {
		return new FColor(this.red - obj.red,this.green - obj.green,this.blue - obj.blue);
	}

	public FColor mul(FColor obj) {
		return new FColor(this.red * obj.red,this.green * obj.green,this.blue * obj.blue);
	}

	public FColor div(FColor obj) {
		return new FColor(this.red / obj.red,this.green / obj.green,this.blue / obj.blue);
	}

	public FColor mul(float r) {
		return new FColor(this.red * r,this.green * r,this.blue * r);
	}

	public FColor div(float r) {
		return new FColor(this.red / r,this.green / r,this.blue / r);
	}

	static public FColor add(FColor a,FColor b) {
		return new FColor(a.red + b.red , a.green + b.green , a.blue + b.blue);
	}

	static public FColor sub(FColor a,FColor b) {
		return new FColor(a.red - b.red , a.green - b.green , a.blue - b.blue);
	}

	static public FColor mul(FColor a,FColor b) {
		return new FColor(a.red * b.red , a.green * b.green , a.blue * b.blue);
	}

	static public FColor div(FColor a,FColor b) {
		return new FColor(a.red / b.red , a.green / b.green , a.blue / b.blue);
	}
	
	public float abs() {
		return (float)Math.sqrt(abs_square());
	}

	public float abs_square() {
		return this.red * this.red + this.green * this.green + this.blue * this.blue;
	}
	
	public String print255() {
        float r = red;
        float g = green;
        float b = blue;
        r = Math.max(0.0f,r);r = Math.min(1.0f,r);
        g = Math.max(0.0f,g);g = Math.min(1.0f,g);
        b = Math.max(0.0f,b);b = Math.min(1.0f,b);
        int ir = (int)(Math.pow(r,1.0 / 2.2) * 255 + 0.5);
        int ig = (int)(Math.pow(g,1.0 / 2.2) * 255 + 0.5);
        int ib = (int)(Math.pow(b,1.0 / 2.2) * 255 + 0.5);
        
        return ir + " " + ig + " " + ib + "\n";
	}
	
}
