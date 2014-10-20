package geometry;

public abstract class Shape {
	
	protected Vertex[] vertices;
	
	public Shape() {
		this.vertices = new Vertex[3];
	}

	public Vertex[] getVertices() {
		return this.vertices;
	}	
}
