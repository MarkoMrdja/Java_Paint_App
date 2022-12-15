package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	protected Color bcolor = Color.BLACK;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		return(startPoint.distance(x, y) + endPoint.distance(x, y) - lenght() <= 2);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(bcolor);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getStartPoint().getX() - 2, getStartPoint().getY() - 2, 4, 4);
			g.drawRect(getEndPoint().getX() - 2, getEndPoint().getY() - 2, 4, 4);
		}
	}
	
	
	@Override
	public String toString() {
		return startPoint + " --> " + endPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line temp = (Line) obj;
			if (startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint));
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int)(this.lenght() - ((Line) o).lenght());
		}
		return 0;
	}
	
	@Override
	public void moveTo(int x, int y) {
		
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	public double lenght() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Color getColor() {
		return bcolor;
	}
	
	public void setColor(Color bcolor) {
		 this.bcolor = bcolor;
	}
	
	
}


