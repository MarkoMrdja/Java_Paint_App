package geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Donut extends Circle {
	private int innerR;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerR) {
		super(center, radius);
		this.innerR = innerR;
	}
	
	public Donut(Point center, int radius, int innerR, boolean selected) {
		this(center, radius, innerR);
		this.selected = selected;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius && center.distance(x, y) >= innerR;
	}
	
	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int halfRadius = (innerR + radius)/2;
		g2.setStroke(new BasicStroke(radius - innerR));
		g2.setColor(backColor);
		g.drawOval(center.getX() - halfRadius, center.getY() - halfRadius, 2*halfRadius, 2*halfRadius);
		g2.setStroke(new BasicStroke(1));
		g.setColor(bordColor);
		g.drawOval(center.getX() - radius, center.getY() - radius, 2*radius, 2*radius);
		g.drawOval(center.getX() - innerR, center.getY() - innerR, 2*innerR, 2*innerR);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getCenter().getX() - innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - innerR - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + innerR - 2, 4, 4);
		}
	}
	
	@Override
	public double area() {
		return super.area() - innerR * innerR * Math.PI;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius = " + innerR;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if (super.equals(new Circle(temp.center, temp.radius)) && innerR == temp.innerR) {
				return true;
			}
		}
		return false;
	}
	
	public int getInnerR() {
		return innerR;
	}
	
	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
}
