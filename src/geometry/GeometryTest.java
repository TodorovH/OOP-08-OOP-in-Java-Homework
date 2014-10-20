package geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;


public class GeometryTest {

	public static void main(String[] args) throws Exception {
		Vertex2D[] planeShapes = {
			new Vertex2D(3d, 3d),
			new Vertex2D(4d, 4d),
			new Vertex2D(10d, 2d)
		};
		
		Vertex3D[] spaceShapes = {
			new Vertex3D(15d, 20d, 10d),
			new Vertex3D(20d, 35d, 10d)
		};
		
		Shape triangle = new Triangle(planeShapes[0].x, planeShapes[0].y, planeShapes[1].x, planeShapes[1].y,
				planeShapes[2].x, planeShapes[2].y);
		Shape rectangle = new Rectangle(planeShapes[2].x, planeShapes[2].y, 5, 20);
		Shape circle = new Circle(planeShapes[0].x, planeShapes[0].y, 1);
		Shape pyramid = new SquarePyramid(spaceShapes[0].x, spaceShapes[0].y, spaceShapes[0].z, 25.8, 14.5);
		Shape cuboid = new Cuboid(spaceShapes[1].x, spaceShapes[1].y, spaceShapes[1].z, 30, 12, 25.5);
		Shape sphere = new Sphere(spaceShapes[0].x, spaceShapes[0].y, spaceShapes[0].z, 9.25);
		
		Shape[] shapes = { triangle, rectangle, circle, pyramid, cuboid, sphere };
		
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
		
		List<SpaceShape> shapeList = Arrays.asList(shapes).stream()
				.filter(s -> s instanceof SpaceShape).map(s -> (SpaceShape) s)
				.filter(v -> v.getVolume() > 40).collect(Collectors.toList());

		System.out.println();		
		for (Shape shape : shapeList) {
			System.out.println(shape);
		}
		
		Comparator<PerimeterMeasurable> comparatorByPerimeter = (PerimeterMeasurable s1, PerimeterMeasurable s2) -> {
			double diff = s1.getPerimeter() - s2.getPerimeter();
			if (diff < 0) {
				return -1;
			}

			if (diff > 0) {
				return 1;
			}

			return 0;
		};

		List<PerimeterMeasurable> SortedShapes = Arrays.asList(shapes).stream()
				.filter(s -> s instanceof PerimeterMeasurable)
				.map(s -> (PerimeterMeasurable) s)
				.sorted(comparatorByPerimeter)
				.collect(Collectors.toList());
		
		System.out.println();
		for (PerimeterMeasurable shape : SortedShapes) {
			System.out.println(shape);
		}
	}

}
