package geometry;

import java.util.Arrays;

public class Triangle extends PlaneShape{
	public Triangle(double x, double y, double x2, double y2, double x3, double y3) {
		super(x, y);
		this.vertices[1] = new Vertex2D(x2, y2);
		this.vertices[2] = new Vertex2D(x3, y3);
		
		this.isValidTriangle();
	}

	private void isValidTriangle() {
		boolean isAPlusBBiggerThanC = (this.getSideA() + this.getSideB()) > this.getSideC();
		boolean isBPlusCBiggerThanA = (this.getSideB() + this.getSideC()) > this.getSideA();
		boolean isAPlusCBiggerThanB = (this.getSideA() + this.getSideC()) > this.getSideB();
		
		boolean isTriangle = isAPlusBBiggerThanC && isBPlusCBiggerThanA && isAPlusCBiggerThanB;
		
		if (!isTriangle) {
			throw new IllegalArgumentException("The sides cannot create a triangle.");
		}
	}
	
	public double getSideA() {
		double sideA = this.getDistanceBetweenTwoPoints(vertices[0], vertices[1]);
		return sideA;
	}
	
	public double getSideB() {
		double sideB = this.getDistanceBetweenTwoPoints(vertices[1], vertices[2]);
		return sideB;
	}
	
	public double getSideC() {
		double sideC = this.getDistanceBetweenTwoPoints(vertices[2], vertices[0]);
		return sideC;
	}
	
	public double getDistanceBetweenTwoPoints(Vertex vertex2DFirst, Vertex vertex2DSecond) {
		double deltaX = vertex2DFirst.x - vertex2DSecond.x;
		double deltaY = vertex2DFirst.y - vertex2DSecond.y;
		double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		return distance;
	}

	@Override
	public double getPerimeter() {
		return this.getSideA() + this.getSideB() + this.getSideC();
	}

	@Override
	public double getArea() {
		double p = this.getPerimeter() / 2;
		double a = this.getSideA();
		double b = this.getSideB();
		double c = this.getSideC();
		
		double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		
		return area;
	}
	
	@Override
	public String toString() {
		return "Triangle [x = " + this.vertices[0].x + ", y = " + this.vertices[0].y + 
				", x2 = " + this.vertices[1].x + ", y2 = " + this.vertices[1].y +
				", x3 = " + this.vertices[2].x + ", y3 = " + this.vertices[2].y +
				", Perimeter = " + this.getPerimeter() +
				", Area = " + this.getArea() + "]\n";
	}
}
