package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaValoracion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaValoracion frame = new VentanaValoracion();
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
	public VentanaValoracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SpinnerNumberModel valoresSpinner = new SpinnerNumberModel(1, 1, 5, 1);
		JSpinner spinner = new JSpinner(valoresSpinner);
		spinner.setBounds(201, 26, 130, 57);
		contentPane.add(spinner);
		
		textField = new JTextField();
		textField.setBounds(201, 143, 363, 154);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Puntuacion:");
		lblNewLabel.setBounds(31, 26, 130, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Analisis:");
		lblNewLabel_1.setBounds(31, 143, 130, 57);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(449, 26, 115, 57);
		contentPane.add(btnNewButton);
	}
}
