package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.PnlDrawing;
import geometry.Point;
import geometry.Rectangle;
import geometry.Utilities;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class Draw extends JFrame implements ActionListener  {

	private JPanel contentPane;
	private Point startPoint = null, endPoint = null;
	private JToggleButton tglbtnPoint, tglbtnLine, tglbtnCircle, tglbtnDonut, tglbtnRectangle, tglbtnSelect, tglbtnModify, tglbtnRemove;
	private PnlDrawing pnldrawing;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Draw frame = new Draw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Draw() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mrdja Marko, MH66/2018");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnldrawing = new PnlDrawing();
		contentPane.add(pnldrawing, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		tglbtnSelect = new JToggleButton("Select");
		panel.add(tglbtnSelect);
		tglbtnSelect.addActionListener(this);
		
		tglbtnModify = new JToggleButton("Modify");
		panel.add(tglbtnModify);
		tglbtnModify.addActionListener(this);
		
		tglbtnRemove = new JToggleButton("Remove");
		panel.add(tglbtnRemove);
		tglbtnRemove.addActionListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		tglbtnPoint = new JToggleButton("New Point");
		panel_1.add(tglbtnPoint);
		tglbtnPoint.addActionListener(this);
		
		tglbtnLine = new JToggleButton("New Line");
		panel_1.add(tglbtnLine);
		tglbtnLine.addActionListener(this);
		
		tglbtnCircle = new JToggleButton("Add Circle");
		panel_1.add(tglbtnCircle);
		tglbtnCircle.addActionListener(this);
		
		tglbtnDonut = new JToggleButton("Add Donut");
		panel_1.add(tglbtnDonut);
		tglbtnDonut.addActionListener(this);
		

		tglbtnRectangle = new JToggleButton("Add Rectangle");
		panel_1.add(tglbtnRectangle);
		tglbtnRectangle.addActionListener(this);
		
		pnldrawing.addMouseListener(new MouseAdapter() {
            
		@Override
	    public void mousePressed(MouseEvent e) {
			
			if(tglbtnPoint.isSelected()) {
	              pnldrawing.shapes.add(new Point(e.getX(), e.getY()));
	              pnldrawing.repaint();
	              tglbtnPoint.setSelected(false);
	         }
			
	        if(tglbtnLine.isSelected()) {
	              if (startPoint == null)
	                 {
	                    startPoint = new Point(e.getX(),e.getY());
	                        
	                 } 
	              else if(endPoint == null)
	                 {
	                    endPoint = new Point(e.getX(),e.getY());    
	                 }
	              if (startPoint != null && endPoint != null) 
	                 {
	                    Line line = new Line(startPoint,endPoint);
	                    pnldrawing.shapes.add(line);
	                    pnldrawing.repaint();
	                    startPoint = null;
	                    endPoint = null;
	                 }
	         }
	        
	        if(tglbtnCircle.isSelected()) {
	               DlgCircle drawCircle = new DlgCircle();
	               drawCircle.setVisible(true);
	               Point center = new Point(e.getX(),e.getY());
	               if (drawCircle.isOk)
	                  {
	                     pnldrawing.shapes.add(new Circle(center,Integer.parseInt(drawCircle.txtCircle.getText())));
	                     pnldrawing.repaint();
	                  }
	         }
	        
	         if(tglbtnDonut.isSelected()) {
	                DlgDonut drawDonut = new DlgDonut();
	                drawDonut.setVisible(true);
	                Point center = new Point(e.getX(),e.getY());
	                if (drawDonut.isOk)
	                {
	                      pnldrawing.shapes.add(new Donut(center,Integer.parseInt(drawDonut.txtRadius.getText()),Integer.parseInt(drawDonut.txtInner.getText())));
	                      pnldrawing.repaint();
	 
	                }
	          }
	         
	         if(tglbtnRectangle.isSelected()) {
	        	    DlgRectangleSec drawRect = new DlgRectangleSec();
	                drawRect.setVisible(true);
	                Point upperLeft = new Point(e.getX(),e.getY());
	                if(drawRect.isOk) 
	                {
	                      pnldrawing.shapes.add(new Rectangle(upperLeft,Integer.parseInt(drawRect.txtHeight.getText()),Integer.parseInt(drawRect.txtWidth.getText())));
	                      pnldrawing.repaint();
	                }
	                
	         }
	         
	         if(tglbtnSelect.isSelected()) {
	        	 boolean found = false;
	        	 for(int i = pnldrawing.shapes.size() - 1; i >= 0; i--) {
	        		 if(pnldrawing.shapes.get(i).contains(e.getX(), e.getY()) && !found) {
	        			 pnldrawing.shapes.get(i).setSelected(true);
	        			 pnldrawing.repaint();
	        			 found = true;
	        		 } 
	        		 else {
	        			 pnldrawing.shapes.get(i).setSelected(false);
	        			 pnldrawing.repaint();
	        		 }
	        	 }
	        	 
	         }
	      }
	    });
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() != tglbtnPoint) {
			tglbtnPoint.setSelected(false);
		}
		
		if(e.getSource() != tglbtnLine) {
			tglbtnLine.setSelected(false);
		}
		
		if(e.getSource() != tglbtnCircle) {
			tglbtnCircle.setSelected(false);
		}
		
		if(e.getSource() != tglbtnDonut) {
			tglbtnDonut.setSelected(false);
		}
		
		if(e.getSource() != tglbtnRectangle) {
			tglbtnRectangle.setSelected(false);
		}
		
		if(e.getSource() != tglbtnSelect) {
			tglbtnSelect.setSelected(false);
		}
		
		if(e.getSource() == tglbtnRemove) {
			for(int i = 0; i < pnldrawing.shapes.size(); i++) {
				if(pnldrawing.shapes.get(i).isSelected()) {
					int input = JOptionPane.showConfirmDialog(null, "Do you want to remove this shape?", "Remove", JOptionPane.YES_NO_OPTION);
					if(input == 0) {
						pnldrawing.shapes.remove(i);
						pnldrawing.repaint();
					}
				}
			}
			tglbtnRemove.setSelected(false);
		}
		
		if(e.getSource() == tglbtnModify) {
			for(int i = 0; i < pnldrawing.shapes.size(); i++) {
				if(pnldrawing.shapes.get(i).isSelected()) {
					if(pnldrawing.shapes.get(i) instanceof Point) {
						ModPoint modPoint = new ModPoint();
						modPoint.txtX.setText(Integer.toString(((Point)pnldrawing.shapes.get(i)).getX()));
						modPoint.txtY.setText(Integer.toString(((Point)pnldrawing.shapes.get(i)).getY()));
						modPoint.btnColorB.setBackground(((Point) (pnldrawing.shapes.get(i))).getColor());
						modPoint.setVisible(true);
						if (modPoint.isOk)
		                  {
			            	((Point)pnldrawing.shapes.get(i)).setX(Integer.parseInt(modPoint.txtX.getText()));
			            	((Point)pnldrawing.shapes.get(i)).setY(Integer.parseInt(modPoint.txtY.getText()));
			            	((Point)pnldrawing.shapes.get(i)).setColor(modPoint.chosenColor);
		                     pnldrawing.repaint();
		                  }
					}
					if(pnldrawing.shapes.get(i) instanceof Line) {
						ModLine modLine = new ModLine();
						
						Point startP = new Point();
						Point endP = new Point();
						startP = ((Line)pnldrawing.shapes.get(i)).getStartPoint();
						endP = ((Line)pnldrawing.shapes.get(i)).getEndPoint();
						
						modLine.txtXstart.setText(Integer.toString(startP.getX()));
						modLine.txtYstart.setText(Integer.toString(startP.getY()));
						modLine.txtXend.setText(Integer.toString(endP.getX()));
						modLine.txtYend.setText(Integer.toString(endP.getY()));
						modLine.btnColorB.setBackground(((Line) (pnldrawing.shapes.get(i))).getColor());
						modLine.setVisible(true);
						if (modLine.isOk)
		                  {
							Point newStartP = new Point();
							Point newEndP = new Point();
							newStartP.setX(Integer.parseInt(modLine.txtXstart.getText()));
							newStartP.setY(Integer.parseInt(modLine.txtYstart.getText()));
							newEndP.setX(Integer.parseInt(modLine.txtXend.getText()));
							newEndP.setY(Integer.parseInt(modLine.txtYend.getText()));
			            	((Line)pnldrawing.shapes.get(i)).setStartPoint(newStartP);
							((Line)pnldrawing.shapes.get(i)).setEndPoint(newEndP);
							((Line)pnldrawing.shapes.get(i)).setColor(modLine.chosenColor);
		                     pnldrawing.repaint();
		                  }
					}
					if(pnldrawing.shapes.get(i) instanceof Donut) {
						ModDonut modDonut = new ModDonut();
						Point p1 = new Point();
						p1 = ((Donut)pnldrawing.shapes.get(i)).getCenter();
						modDonut.txtX.setText(Integer.toString(p1.getX()));
						modDonut.txtY.setText(Integer.toString(p1.getY()));
						modDonut.txtInner.setText(Integer.toString(((Donut)pnldrawing.shapes.get(i)).getInnerR()));
						modDonut.txtRadius.setText(Integer.toString(((Donut)pnldrawing.shapes.get(i)).getRadius()));
						modDonut.btnBackColor.setBackground(((Donut) (pnldrawing.shapes.get(i))).getBackgroundColor());
						modDonut.btnColorB.setBackground(((Donut) (pnldrawing.shapes.get(i))).getBorderColor());
			            modDonut.setVisible(true);
			            if (modDonut.isOk)
		                  {
			            	Point p2 = new Point();
			            	p2.setX(Integer.parseInt(modDonut.txtX.getText()));
			            	p2.setY(Integer.parseInt(modDonut.txtY.getText()));
			            	((Donut)pnldrawing.shapes.get(i)).setCenter(p2);
			            	((Donut)pnldrawing.shapes.get(i)).setRadius(Integer.parseInt(modDonut.txtRadius.getText()));
			            	((Donut)pnldrawing.shapes.get(i)).setInnerR(Integer.parseInt(modDonut.txtInner.getText()));
			            	((Donut)pnldrawing.shapes.get(i)).setBorderColor(modDonut.chosenColor1);
		                    ((Donut)pnldrawing.shapes.get(i)).setBackgroundColor(modDonut.chosenColor2);
		                     pnldrawing.repaint();
		                  }
					}
					else if(pnldrawing.shapes.get(i) instanceof Circle) {
						ModCircle modCircle = new ModCircle();
						Point p1 = new Point();
						p1 = ((Circle)pnldrawing.shapes.get(i)).getCenter();
						modCircle.txtX.setText(Integer.toString(p1.getX()));
						modCircle.txtY.setText(Integer.toString(p1.getY()));
						modCircle.txtRadius.setText(Integer.toString(((Circle)pnldrawing.shapes.get(i)).getRadius()));
						modCircle.btnBackColor.setBackground(((Circle) (pnldrawing.shapes.get(i))).getBackgroundColor());
						modCircle.btnColorB.setBackground(((Circle) (pnldrawing.shapes.get(i))).getBorderColor());
						modCircle.btnBackColor.setBackground(((Circle) (pnldrawing.shapes.get(i))).getBackgroundColor());
			            modCircle.setVisible(true);
			            if (modCircle.isOk)
		                  {
			            	 Point p2 = new Point();
			            	 p2.setX(Integer.parseInt(modCircle.txtX.getText()));
			            	 p2.setY(Integer.parseInt(modCircle.txtY.getText()));
			            	 ((Circle)pnldrawing.shapes.get(i)).setCenter(p2);
		                     ((Circle)pnldrawing.shapes.get(i)).setRadius(Integer.parseInt(modCircle.txtRadius.getText()));
		                     ((Circle)pnldrawing.shapes.get(i)).setBorderColor(modCircle.chosenColor1);
		                     ((Circle)pnldrawing.shapes.get(i)).setBackgroundColor(modCircle.chosenColor2);
		                     pnldrawing.repaint();
		                  }
					}
					else if(pnldrawing.shapes.get(i) instanceof Rectangle) {
						ModRectangle modRect = new ModRectangle();
						Point p1 = new Point();
						p1 = ((Rectangle)pnldrawing.shapes.get(i)).getUpperLeft();
						modRect.txtX.setText(Integer.toString(p1.getX()));
						modRect.txtY.setText(Integer.toString(p1.getY()));
		                modRect.txtHeight.setText(Integer.toString(((Rectangle)pnldrawing.shapes.get(i)).getHeight()));
		                modRect.txtWidth.setText(Integer.toString(((Rectangle)pnldrawing.shapes.get(i)).getWidth()));
		                modRect.btnBackColor.setBackground(((Rectangle) (pnldrawing.shapes.get(i))).getBackgroundColor());
						modRect.btnColorB.setBackground(((Rectangle) (pnldrawing.shapes.get(i))).getBorderColor());
						modRect.setVisible(true);
						if (modRect.isOk)
		                  {
							 Point p2 = new Point();
			            	 p2.setX(Integer.parseInt(modRect.txtX.getText()));
			            	 p2.setY(Integer.parseInt(modRect.txtY.getText()));
			            	 ((Rectangle)pnldrawing.shapes.get(i)).setUpperLeft(p2);
		                     ((Rectangle)pnldrawing.shapes.get(i)).setHeight(Integer.parseInt(modRect.txtHeight.getText()));
		                     ((Rectangle)pnldrawing.shapes.get(i)).setWidth(Integer.parseInt(modRect.txtWidth.getText()));
		                     ((Rectangle)pnldrawing.shapes.get(i)).setBorderColor(modRect.chosenColor1);
		                     ((Rectangle)pnldrawing.shapes.get(i)).setBackgroundColor(modRect.chosenColor2);
		                     pnldrawing.repaint();
		                  }
					}
				}
			}
			tglbtnModify.setSelected(false);
		}
	}

}
