package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	protected Point center;
	protected int radius;
	protected Color backColor = Color.white, bordColor = Color.black;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(backColor);
		g.fillOval(center.getX() - radius, center.getY() - radius, radius + radius, radius + radius);
		g.setColor(bordColor);
		g.drawOval(center.getX() - radius, center.getY() - radius, radius + radius, radius + radius);
		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
		}
	}
	
	@Override
	public String toString() {
		return "Center: " + center + ", radius: " + radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if (center.equals(temp.center) && radius == temp.radius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int)(this.area() - ((Circle) o).area());
		}
		return 0;
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
	}
	
	public double area() {
		return Math.PI*radius*radius;
	}
	public double circumference() {
		return 2*Math.PI*radius;
	}
	
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Color getBackgroundColor() {
		return backColor;
	}
	
	public void setBackgroundColor(Color backColor) {
		 this.backColor = backColor;
	}
	public Color getBorderColor() {
		return bordColor;
	}
	
	public void setBorderColor(Color bordColor) {
		 this.bordColor = bordColor;
	}

	
}
