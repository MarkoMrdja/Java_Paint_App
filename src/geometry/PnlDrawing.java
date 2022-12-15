package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class PnlDrawing extends JPanel {
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PnlDrawing() {
		setSize(800,600);
		setBackground(Color.white);
		
	}
		
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < shapes.size(); i++)
		{
			shapes.get(i).draw(g);
		}
	}
}
