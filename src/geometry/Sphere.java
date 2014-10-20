package geometry;

public class Sphere extends SpaceShape {
	private double radius;

	public Sphere(double x, double y, double z, double radius) throws Exception {
		super(x, y, z);
		this.setRadius(radius);
	}
	
	public void setRadius(double radius) throws Exception{
		if (radius <= 0){
			throw new Exception("The radius should be positive.");
		}
		this.radius = radius;
	}

	@Override
	public double getArea() {
		double area = 4 * Math.PI * this.radius * this.radius;
		return area;
	}

	@Override
	public double getVolume() {
		double volume = (4 / 3) * Math.PI * Math.pow(this.radius, 3);
		return volume;
	}
	
	@Override
	public String toString() {
		return "Sphera [radius = " + this.radius +
				", x = " + this.vertices[0].x + ", y = " + this.vertices[0].y + 
				", Area = " + this.getArea() +
				", Volume =" + this.getVolume() + "]\n";
	}
}
