package geometry;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {
	public PlaneShape(double x, double y) {
		this.vertices = new Vertex2D[3];
		this.vertices[0] = new Vertex2D(x, y);
	}
}
