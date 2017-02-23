import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
	
	private Set<Point2D> points;

	public PointSET() {
		points = new TreeSet<>();
	}

	public boolean isEmpty() {
		return points.isEmpty();
	}

	public int size() {
		return points.size();
	}

	public void insert(Point2D p) {
		points.add(p);
	}

	public boolean contains(Point2D p) {
		return points.contains(p);
	}

	public void draw() {
		for (Point2D p : points) {
			StdDraw.point(p.x(), p.y());
		}
	}

	public Iterable<Point2D> range(RectHV rect) {
		List<Point2D> result = new ArrayList<>();
		
		for (Point2D p : points) {
			if (rect.contains(p)) {
				result.add(p);
			}
		}
		
		return result;
	}

	public Point2D nearest(Point2D p) {
		Point2D nearest = null;
		double distanceToNearest = Double.POSITIVE_INFINITY;
		
		for (Point2D point : points) {
			double distance = point.distanceTo(p);
			if (Double.compare(distance, distanceToNearest) < 0) {
				distanceToNearest = distance;
				nearest = point;
			} 
		}
		
		return nearest;
	}

	public static void main(String[] args) {

	}
}
