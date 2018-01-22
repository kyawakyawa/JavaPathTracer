package pathTracer;

public abstract class LightSource {
	public abstract LightInfo lightPoint();
	public abstract float getWeight();
}
