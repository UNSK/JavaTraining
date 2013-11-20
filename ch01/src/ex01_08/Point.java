package ex01_08;

public class Point {
	private double x_, y_;
	
	public void setPoint(Point p) {
		this.x_ = p.x_;
		this.y_ = p.y_;
	}

	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point();
		
		point1.x_ = 10.1;
		point1.y_ = 20.2;
		
		point2.x_ = 0.0;
		point2.y_ = 0.0;

		point2.setPoint(point1);
		System.out.println("x: " + point2.x_);
		System.out.println("y: " + point2.y_);
	}

}
