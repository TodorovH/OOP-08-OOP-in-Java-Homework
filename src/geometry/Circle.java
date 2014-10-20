package geometry;

import java.util.Arrays;

public class Circle extends PlaneShape{
	
	private double radius;

	public Circle(double x, double y, double radius) throws Exception {
		super(x, y);
		this.setRadius(radius);
	}

	public void setRadius(double radius) throws Exception {
		if (radius <= 0) {
			throw new Exception("Radius should be positive.");
		}
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + this.radius + 
				", " + Arrays.toString(this.vertices) +
				", Perimeter = " + this.getPerimeter() +
				", Area = " + this.getArea() + "]\n";
	}
	
}
