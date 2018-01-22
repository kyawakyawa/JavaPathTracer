package pathTracer;

public class AreaLightSource extends LightSource {
	private Shape object;
	private float S;
	
	@SuppressWarnings("unused")
	private AreaLightSource() {
		
	}
	
	public AreaLightSource(Shape obj) {
		object = obj;S = object.getS();
	}
	
	public LightInfo lightPoint() {
		return object.sampleOnePoint();
	}
	
	public float getWeight() {
		return S * object.getMaterials().get((int)(Math.random() * object.getMaterials().size())).getLe().abs();
	}
}
