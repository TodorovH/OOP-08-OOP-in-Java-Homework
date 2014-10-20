package geometry;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {
	public SpaceShape(double x, double y, double z) {
		this.vertices = new Vertex3D[3];
		this.vertices[0] = new Vertex3D(x, y, z);
	}
}
