package geometry;

import java.util.Arrays;

public class Rectangle extends PlaneShape{
	private double width;
	private double height;
	
	public Rectangle(double x, double y, double width, double height) throws Exception {
		super(x, y);
		this.setWidth(width);
		this.setHeight(height);
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) throws Exception {
		if (height <= 0) {
			throw new Exception("Height should be positive.");
		}
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) throws Exception {
		if (width <= 0) {
			throw new Exception("Width should be positive.");
		}
		this.width = width;
	}

	@Override
	public double getPerimeter() {
		return this.height * 2 + this.width * 2;
	}

	@Override
	public double getArea() {
		return this.height * this.width;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width +  
				", height=" + height + 
				", " + Arrays.toString(this.vertices) +
				", Perimeter = " + this.getPerimeter() +
				", Area = " + this.getArea() + "]\n";
	}
	
	
}
