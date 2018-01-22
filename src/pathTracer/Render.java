package pathTracer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Render {
	private ArrayList<Shape> shapes;
	private ArrayList<LightSource> lights;
	private Camera camera = new Camera();
	private Radiance radiance;
	private FColor img[];
	private String imgPath;

	@SuppressWarnings("unused")
	private Render() {
		
	}
	public Render(Camera camera,Radiance radiance,String ip) {
		this.camera = camera;
		if (radiance == null) {
			try {
				throw new Exception("インテグレーターを指定してください");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		shapes = new ArrayList<Shape>();
		lights = new ArrayList<LightSource>();
		this.radiance = radiance;
		imgPath = ip;
	}

	public void add(Shape shape) {
		shapes.add(shape);
	}
	
	public void addAsLight(Shape shape) {
		lights.add(new AreaLightSource(shape));
		shapes.add(shape);
	}
	
	public void initImg() {
		img = new FColor[camera.getPicW() * camera.getPicH()];
		for(int i = 0;i < img.length;i++) {
			img[i] = new FColor(0,0,0);
		}
	}
	
	public void draw(int sample,int supersamples) {
		radiance.set(shapes,lights);
		initImg();
		float r = 1.0f / (sample * supersamples * supersamples);
		
		for(int i = 0;i < camera.getPicH();i++) {
			System.out.println("y = " + i + " (" + (i / (double)camera.getPicH() * 100.0) + " % )");
			for(int j = 0;j < camera.getPicW();j++) {
				for(int sy = 0; sy < supersamples;sy++) {
					for(int sx = 0;sx < supersamples;sx++) {
						Ray ray = camera.getRay(sy, sx, supersamples, i, j);
						for(int k = 0;k < sample;k++) {
							img[i * camera.getPicW() + j] = img[i * camera.getPicW() + j].add(radiance.radiance(ray));
						}
					}
				}
				img[i * camera.getPicW() + j] = img[i * camera.getPicW() + j].mul(r);
			}
		}
		output();
	}
	
	private void output() {
		File file = new File(imgPath);
		try {
			FileWriter fw = new FileWriter( file );
			fw.write("P3\n" + camera.getPicW() + " " + camera.getPicH() + "\n255\n");
			for(int i = 0;i < img.length;i++) {
				fw.write(img[i].print255());
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("うまくファイルに書き込めなかったよ");
		}
		
	}
}
