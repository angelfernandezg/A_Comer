package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class VentanaBuscador2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscador2 frame = new VentanaBuscador2();
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
	public VentanaBuscador2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(79, 10, 543, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(629, 10, 85, 59);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(40, 98, 135, 53);
		contentPane.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(40, 176, 135, 53);
		contentPane.add(spinner);
	}
}
