package geometry;

import java.util.Arrays;

public class SquarePyramid extends SpaceShape {
	private double baseWidth;
	private double height;
	
	public SquarePyramid(double x, double y, double z, double baseWidth, double height) throws Exception {
		super(x, y, z);
		this.setBaseWidth(baseWidth);
		this.setHeight(height);
	}
	
	public double getBaseWidth() {
		return baseWidth;
	}
	
	public void setBaseWidth(double baseWidth) throws Exception {
		if (baseWidth <= 0) {
			throw new Exception("The base width should be positive.");
		}
		this.baseWidth = baseWidth;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) throws Exception {
		if (height <= 0) {
			throw new Exception("The height should be positive.");
		}
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = this.baseWidth * this.baseWidth + 2 * this.baseWidth * 
				Math.sqrt((this.baseWidth * this.baseWidth) / 4 + (this.height * this.height));
		return area;
	}

	@Override
	public double getVolume() {
		double volume = this.baseWidth * this.baseWidth * (this.height / 3);
		return volume;
	}
	
	@Override
	public String toString() {
		return "SquarePyramid [width = " + this.baseWidth + 
				", height = " + this.height + 
				", x = " + this.vertices[0].x + ", y = " + this.vertices[0].y +
				", Area = " + this.getArea() +
				", Volume = " + this.getVolume() + "]\n";
	}
}
