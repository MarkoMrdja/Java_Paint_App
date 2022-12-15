package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Utilities;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class ModCircle extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	protected boolean isOk;
	protected JTextField txtX;
	protected JTextField txtY;
	protected JTextField txtRadius;
	protected JButton btnColorB, btnBackColor, btnSetBorder, btnSetBack;
	protected Color chosenColor1, chosenColor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModCircle dialog = new ModCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModCircle() {
		setTitle("Modify Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 100, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X Position");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.anchor = GridBagConstraints.WEST;
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.gridx = 1;
			gbc_txtX.gridy = 0;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y Position");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.anchor = GridBagConstraints.WEST;
			gbc_txtY.insets = new Insets(0, 0, 5, 5);
			gbc_txtY.gridx = 1;
			gbc_txtY.gridy = 1;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.anchor = GridBagConstraints.WEST;
			gbc_txtRadius.insets = new Insets(0, 0, 5, 5);
			gbc_txtRadius.gridx = 1;
			gbc_txtRadius.gridy = 2;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JLabel lblColorB = new JLabel("Border Color");
			GridBagConstraints gbc_lblColorB = new GridBagConstraints();
			gbc_lblColorB.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorB.gridx = 0;
			gbc_lblColorB.gridy = 3;
			contentPanel.add(lblColorB, gbc_lblColorB);
		}
		{
			btnColorB = new JButton("Current Color");
			btnColorB.setEnabled(false);
			GridBagConstraints gbc_btnColorB = new GridBagConstraints();
			gbc_btnColorB.anchor = GridBagConstraints.WEST;
			gbc_btnColorB.insets = new Insets(0, 0, 5, 5);
			gbc_btnColorB.gridx = 1;
			gbc_btnColorB.gridy = 3;
			contentPanel.add(btnColorB, gbc_btnColorB);
		}
		{
			btnSetBorder = new JButton("Set Border Color");
			btnSetBorder.addActionListener(this);
			GridBagConstraints gbc_btnSetBorder = new GridBagConstraints();
			gbc_btnSetBorder.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnSetBorder.insets = new Insets(0, 0, 5, 0);
			gbc_btnSetBorder.gridx = 2;
			gbc_btnSetBorder.gridy = 3;
			contentPanel.add(btnSetBorder, gbc_btnSetBorder);
		}
		{
			JLabel lblBackColor = new JLabel("Background color");
			GridBagConstraints gbc_lblBackColor = new GridBagConstraints();
			gbc_lblBackColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblBackColor.gridx = 0;
			gbc_lblBackColor.gridy = 4;
			contentPanel.add(lblBackColor, gbc_lblBackColor);
		}
		{
			btnBackColor = new JButton("Current Color");
			btnBackColor.setEnabled(false);
			GridBagConstraints gbc_btnBackColor = new GridBagConstraints();
			gbc_btnBackColor.anchor = GridBagConstraints.WEST;
			gbc_btnBackColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnBackColor.gridx = 1;
			gbc_btnBackColor.gridy = 4;
			contentPanel.add(btnBackColor, gbc_btnBackColor);
		}
		{
			btnSetBack = new JButton("Set Background Color");
			btnSetBack.addActionListener(this);
			GridBagConstraints gbc_btnSetBack = new GridBagConstraints();
			gbc_btnSetBack.insets = new Insets(0, 0, 5, 0);
			gbc_btnSetBack.gridx = 2;
			gbc_btnSetBack.gridy = 4;
			contentPanel.add(btnSetBack, gbc_btnSetBack);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Utilities.isNumeric(txtX.getText()) || !Utilities.isNumeric(txtY.getText()) || !Utilities.isNumeric(txtRadius.getText())) {
							JOptionPane.showMessageDialog(null, "Letters and negative number are not allowed as a input!");
						}
						else if(Integer.parseInt(txtX.getText()) <= 0 || Integer.parseInt(txtY.getText()) <= 0 || Integer.parseInt(txtRadius.getText()) <= 0) {
							JOptionPane.showMessageDialog(null, "Letters and negative number are not allowed as a input!");
						}
						else {
							isOk = true;
							setVisible(false);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSetBorder) {
			chosenColor1 = JColorChooser.showDialog(this, "Set New Color", btnColorB.getBackground());
			btnColorB.setBackground(chosenColor1);
		}
		if(e.getSource() == btnSetBack) {
			chosenColor2 = JColorChooser.showDialog(this, "Set New Color", btnBackColor.getBackground());
			btnBackColor.setBackground(chosenColor2);
		}
		
	}

}
