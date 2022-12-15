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

public class ModPoint extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	protected boolean isOk;
	protected JTextField txtX;
	protected JTextField txtY;
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
	public ModPoint() {
		setTitle("Modify Point");
		setModal(true);
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 60, 0, 0};
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
			JLabel lblColor = new JLabel("Point Color");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 0;
			gbc_lblColor.gridy = 2;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnColorB = new JButton("Current Color");
			btnColorB.setEnabled(false);
			GridBagConstraints gbc_btnColorB = new GridBagConstraints();
			gbc_btnColorB.anchor = GridBagConstraints.WEST;
			gbc_btnColorB.insets = new Insets(0, 0, 5, 5);
			gbc_btnColorB.gridx = 1;
			gbc_btnColorB.gridy = 2;
			contentPanel.add(btnColorB, gbc_btnColorB);
		}
		{
			btnSetColor = new JButton("Set Color");
			btnSetColor.addActionListener(this);
			GridBagConstraints gbc_btnSetColor = new GridBagConstraints();
			gbc_btnSetColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnSetColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnSetColor.gridx = 2;
			gbc_btnSetColor.gridy = 2;
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
						if(!Utilities.isNumeric(txtX.getText()) || !Utilities.isNumeric(txtY.getText())) {
							JOptionPane.showMessageDialog(null, "Letters and negative numbers are not allowed as a input!");
						}
						else if(Integer.parseInt(txtX.getText()) <= 0 || Integer.parseInt(txtY.getText()) <= 0) {
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
