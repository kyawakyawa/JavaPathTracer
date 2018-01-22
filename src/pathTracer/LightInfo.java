package pathTracer;

public class LightInfo {
	private Vecter3 point;
	private Vecter3 normal;
	private float pdf;
	private FColor emission;
	
	@SuppressWarnings("unused")
	private LightInfo() {
		
	}

	public LightInfo(Vecter3 po,Vecter3 n,double p,FColor e) {
		point = po;normal = n;pdf = (float)p;emission = e;
	}

	public Vecter3 getPoint() {
		return point;
	}

	public Vecter3 getNormal() {
		return normal;
	}

	public float getPdf() {
		return pdf;
	}

	public FColor getEmission() {
		return emission;
	}
}
