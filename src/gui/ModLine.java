package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.Utilities;

public class ModLine extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	protected boolean isOk;
	protected JTextField txtXstart;
	protected JTextField txtYstart;
	protected JTextField txtXend;
	protected JTextField txtYend;
	protected JButton btnColorB, btnSetColor;
	protected Color chosenColor;

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
	public ModLine() {
		setTitle("Modify Line");
		setModal(true);
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 60, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPoint = new JLabel("Start Point");
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 0;
			gbc_lblStartPoint.gridy = 0;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			JLabel lblX = new JLabel("X Position");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtXstart = new JTextField();
			GridBagConstraints gbc_txtXstart = new GridBagConstraints();
			gbc_txtXstart.anchor = GridBagConstraints.WEST;
			gbc_txtXstart.insets = new Insets(0, 0, 5, 5);
			gbc_txtXstart.gridx = 1;
			gbc_txtXstart.gridy = 1;
			contentPanel.add(txtXstart, gbc_txtXstart);
			txtXstart.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y Position");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtYstart = new JTextField();
			GridBagConstraints gbc_txtYstart = new GridBagConstraints();
			gbc_txtYstart.anchor = GridBagConstraints.WEST;
			gbc_txtYstart.insets = new Insets(0, 0, 5, 5);
			gbc_txtYstart.gridx = 1;
			gbc_txtYstart.gridy = 2;
			contentPanel.add(txtYstart, gbc_txtYstart);
			txtYstart.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("End Point");
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 0;
			gbc_lblEndPoint.gridy = 3;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			JLabel lblXend = new JLabel("X Position");
			GridBagConstraints gbc_lblXend = new GridBagConstraints();
			gbc_lblXend.anchor = GridBagConstraints.EAST;
			gbc_lblXend.insets = new Insets(0, 0, 5, 5);
			gbc_lblXend.gridx = 0;
			gbc_lblXend.gridy = 4;
			contentPanel.add(lblXend, gbc_lblXend);
		}
		{
			txtXend = new JTextField();
			GridBagConstraints gbc_txtXend = new GridBagConstraints();
			gbc_txtXend.anchor = GridBagConstraints.WEST;
			gbc_txtXend.insets = new Insets(0, 0, 5, 5);
			gbc_txtXend.gridx = 1;
			gbc_txtXend.gridy = 4;
			contentPanel.add(txtXend, gbc_txtXend);
			txtXend.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Y Position");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 5;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtYend = new JTextField();
			txtYend.setText("");
			GridBagConstraints gbc_txtYend = new GridBagConstraints();
			gbc_txtYend.anchor = GridBagConstraints.WEST;
			gbc_txtYend.insets = new Insets(0, 0, 5, 5);
			gbc_txtYend.gridx = 1;
			gbc_txtYend.gridy = 5;
			contentPanel.add(txtYend, gbc_txtYend);
			txtYend.setColumns(10);
		}
		{
			JLabel lblColorB = new JLabel("Line Color");
			GridBagConstraints gbc_lblColorB = new GridBagConstraints();
			gbc_lblColorB.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorB.gridx = 0;
			gbc_lblColorB.gridy = 6;
			contentPanel.add(lblColorB, gbc_lblColorB);
		}
		{
			btnColorB = new JButton("Current Color");
			btnColorB.setEnabled(false);
			GridBagConstraints gbc_btnColorB = new GridBagConstraints();
			gbc_btnColorB.anchor = GridBagConstraints.WEST;
			gbc_btnColorB.insets = new Insets(0, 0, 5, 5);
			gbc_btnColorB.gridx = 1;
			gbc_btnColorB.gridy = 6;
			contentPanel.add(btnColorB, gbc_btnColorB);
		}
		{
			btnSetColor = new JButton("Set Color");
			btnSetColor.addActionListener(this);
			GridBagConstraints gbc_btnSetColor = new GridBagConstraints();
			gbc_btnSetColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnSetColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnSetColor.gridx = 2;
			gbc_btnSetColor.gridy = 6;
			contentPanel.add(btnSetColor, gbc_btnSetColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Utilities.isNumeric(txtXstart.getText()) || !Utilities.isNumeric(txtYstart.getText()) || !Utilities.isNumeric(txtXend.getText()) || !Utilities.isNumeric(txtYend.getText())) {
							JOptionPane.showMessageDialog(null, "Letters and negative number are not allowed as a input!");
						}
						else if(Integer.parseInt(txtXstart.getText()) <= 0 || Integer.parseInt(txtYstart.getText()) <= 0 || Integer.parseInt(txtXend.getText()) <= 0 || Integer.parseInt(txtYend.getText()) <= 0) {
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
		chosenColor = JColorChooser.showDialog(this, "Set New Color", btnColorB.getBackground());
		btnColorB.setBackground(chosenColor);
	}

}
