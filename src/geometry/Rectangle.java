package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	private Point upperLeft;
	private int height;
	private int width;
	protected Color backColor = Color.white, bordColor = Color.black;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int height, int width) {
		this.upperLeft = upperLeft;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeft, int height, int width, boolean selected) {
		this(upperLeft, height, width);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && upperLeft.getX() + width > x
				&& upperLeft.getY() < y && upperLeft.getY() + height > y);
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(backColor);
		g.fillRect(upperLeft.getX(), upperLeft.getY(), width, height);
		g.setColor(bordColor);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() + height - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width  - 2, upperLeft.getY() + height - 2, 4, 4);
		}
	}
	
	@Override
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if (upperLeft.equals(temp.upperLeft) && width == temp.width && height == temp.height) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int)(this.area() - ((Rectangle) o).area());
		}
		return 0;
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}
	
	public double area() {
		return width*height;
	}
	public double circumference() {
		return 2*width + 2*height;
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
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
