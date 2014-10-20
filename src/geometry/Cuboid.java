package geometry;

public class Cuboid extends SpaceShape {
	private double width;
	private double height;
	private double depth;
	
	public Cuboid(double x, double y, double z, double width, double height, double depth) throws Exception {
		super(x, y, z);
		this.setWidth(width);
		this.setHeight(height);
		this.setDepth(depth);
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public void setWidth(double width) throws Exception{
		if (width <= 0){
			throw new Exception("The width should be positive.");
		}
		this.width = width;
	}
	
	public void setHeight(double height) throws Exception{
		if (height <= 0){
			throw new Exception("The height should be positive.");
		}
		this.height = height;
	}
	
	public void setDepth(double depth) throws Exception{
		if (depth <= 0){
			throw new Exception("The depth should be positive.");
		}
		this.depth = depth;
	}

	@Override
	public double getArea() {
		double area = 2 * (
				this.width * this.depth +
				this.width * this.height +
				this.depth * this.height);
		return area;
	}

	@Override
	public double getVolume() {
		double volume = this.width * this.height * this.depth;
		return volume;
	}
	
	@Override
	public String toString() {
		return "Cuboid [width = " + this.width +
				", height = " + this.height +
				", depth = " 	+ this.depth +
				", x = " + this.vertices[0].x + ", y = " + this.vertices[0].y +
				", Area = " + this.getArea() +
				", Volume = " + this.getVolume() + "]\n";
	}
}
