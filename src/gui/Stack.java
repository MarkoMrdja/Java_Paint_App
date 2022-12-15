package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mrdja Marko, MH66/2018");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Add/Remove Rectangle");
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{426, 0};
		gbl_panel_1.rowHeights = new int[]{199, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		final JList lstRectangle = new JList();
		scrollPane.setViewportView(lstRectangle);
		lstRectangle.setModel(dlm);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangle dlgRectangle = new DlgRectangle();
				dlgRectangle.setVisible(true);
				
				if(dlgRectangle.isOk) {
					Point upperLeft = new Point(Integer.parseInt(DlgRectangle.txtX.getText()),Integer.parseInt(DlgRectangle.txtY.getText()));
					dlm.add(0,new Rectangle(upperLeft,Integer.parseInt(DlgRectangle.txtWidth.getText()),Integer.parseInt(DlgRectangle.txtHeight.getText())));
				}			
			}
		});
		panel_2.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangle dlgRectangle = new DlgRectangle();
				
				Rectangle temp = new Rectangle();
				temp = dlm.getElementAt(lstRectangle.getSelectedIndex());
				
				DlgRectangle.txtX.setText(Integer.toString(temp.getUpperLeft().getX()));
				DlgRectangle.txtY.setText(Integer.toString(temp.getUpperLeft().getY()));
				DlgRectangle.txtHeight.setText(Integer.toString(temp.getHeight()));
				DlgRectangle.txtWidth.setText(Integer.toString(temp.getWidth()));
				dlgRectangle.setVisible(true);
				
				if(dlgRectangle.isOk) {
				    dlm.remove(lstRectangle.getSelectedIndex());
				}
			}
		});
		panel_2.add(btnRemove);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectangle temp;
				Rectangle [] ob = new Rectangle [dlm.getSize()];
			    for(int i = 0 ; i <dlm.getSize(); i++ )
			        ob[i] = dlm.getElementAt(i);
			    int n=ob.length;
			    for(int i=0;i<n;i++)
			        for(int j=0;j<n-i-1;j++)
			        {
			            if(ob[j].compareTo(ob[j+1])>0)
			            {
			             temp=ob[j];
			             ob[j]=ob[j+1];
			             ob[j+1]=temp;
			            }

			          }
			    dlm.removeAllElements();
			    for(int i=0;i<n;i++)
			      dlm.addElement((Rectangle) ob[i]);
				}
		});
		panel_2.add(btnSort);
	}

}
