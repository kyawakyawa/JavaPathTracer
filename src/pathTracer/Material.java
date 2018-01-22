package pathTracer;

enum MaterialType {
	MT_DEFAULT,//通常
    MT_PERFECT_REF,//完全鏡面反射
    MT_REFRACTION,//屈折
    MT_NORMALIZED_PHONG//正規化 Phong
}

public class Material {
	private FColor albedo = new FColor(0,0,0);
	private MaterialType type = MaterialType.MT_DEFAULT;
	private float scalar = 1.51f;
	private FColor Le = new FColor(0,0,0) ;
	
	public Material() {
		
	}
	
	public Material(FColor a,MaterialType t,float s,FColor L) {
		albedo = a;type = t;scalar = s;Le = L;
	}
	
	public Material(FColor a) {
		albedo = a;
	}

	public Material(MaterialType t) {
		albedo = new FColor(0.99f,0.99f,0.99f);
		type = t;
	}
	
	public Material(FColor a,MaterialType t) {
		albedo = a;type = t;
	}
	
	public Material(FColor a,float  s) {
		albedo = a;scalar = s;type = MaterialType.MT_REFRACTION;
	}
	
	public Material(FColor a,FColor e) {
		albedo = a;Le = e;
	}
	
	public Material(FColor a,float s,MaterialType t) {
		albedo = a;scalar = s;type = t;
	}

	public FColor getAlbedo() {
		return albedo;
	}

	public void setAlbedo(FColor albedo) {
		this.albedo = albedo;
	}

	public MaterialType getType() {
		return type;
	}

	public void setType(MaterialType type) {
		this.type = type;
	}

	public float getScalar() {
		return scalar;
	}

	public void setScalar(float scalar) {
		this.scalar = scalar;
	}

	public FColor getLe() {
		return Le;
	}

	public void setLe(FColor le) {
		Le = le;
	}
}
