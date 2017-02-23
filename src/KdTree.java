import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
	
	private class Node {
		
		private Point2D point;
		
		private boolean even;
		
		private Node left;
		
		private Node right;
		
		private int size;
		
		private Node(Point2D point, boolean even) {
			this.point = point;
			this.even = even;
			this.size = 1;
		}
	}
	
	private Node root;

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return root != null ? root.size : 0;
	}

	public void insert(Point2D p) {
		root = insert(root, p, root != null);
	}

	public boolean contains(Point2D p) {
		return get(root, p, root != null) != null;
	}

	public void draw() {
		// TODO
	}

	public Iterable<Point2D> range(RectHV rect) {
		return null;
	}

	public Point2D nearest(Point2D p) {
		return getNearest(root, p, Double.POSITIVE_INFINITY);
	}
	
	private Point2D getNearest(Node node, Point2D p, double minDistance) {
		return null;
	}

	private Node insert(Node parent, Point2D value, boolean parentLevelIsEven) {
		if (parent == null) {
			return new Node(value, !parentLevelIsEven);
		}
		
		int compare = parentLevelIsEven ? 
				Double.compare(value.x(), parent.point.x()) : 
				Double.compare(value.y(), parent.point.y());  
		
		if (compare < 0) {
			parent.left = insert(parent.left, value, !parentLevelIsEven); 
		} else if (compare > 0) {
			parent.right = insert(parent.right, value, !parentLevelIsEven);
		} else {
			parent.point = value;
		}
		
		parent.size = getNodeSize(parent.left) + getNodeSize(parent.right) + 1;
		
		return parent;
	}
	
	private Node get(Node node, Point2D p, boolean levelIsEven) {
		
		if (node == null) {
			return null;
		}
		
		int compare = levelIsEven ? 
				Double.compare(p.x(), node.point.x()) : 
				Double.compare(p.y(), node.point.y());  
		
		if (compare < 0) {
			node = get(node.left, p, !levelIsEven);
		} else if (compare > 0) {
			node = get(node.right, p, !levelIsEven);
		}
				
		return node;
	}
	
	private int getNodeSize(Node node) {
		return node != null ? node.size : 0;
	}
	
	public static void main(String[] args) {
		Point2D p1 = new Point2D(0.5, 0.5);
		Point2D p2 = new Point2D(0.3, 0.3);
		Point2D p3 = new Point2D(0.2, 0.2);
		Point2D p4 = new Point2D(0.1, 0.1);
		Point2D p5 = new Point2D(0.0, 0.0);
		
		KdTree tree = new KdTree();
		tree.insert(p1);
		tree.insert(p2);
		tree.insert(p3);
		tree.insert(p4);
		tree.insert(p5);
		
		assert(tree.contains(p1));
		assert(tree.contains(p2));
		assert(tree.contains(p3));
		assert(tree.contains(p4));
		assert(tree.contains(p5));
		
		assert(tree.size() == 5);
		
		System.out.println("Test passed!");
	}
}
