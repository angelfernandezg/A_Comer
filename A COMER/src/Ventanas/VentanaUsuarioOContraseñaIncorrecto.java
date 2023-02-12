package Ventanas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VentanaUsuarioOContraseñaIncorrecto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuarioOContraseñaIncorrecto frame = new VentanaUsuarioOContraseñaIncorrecto();
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
	public VentanaUsuarioOContraseñaIncorrecto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 479, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon icon = new ImageIcon("resources/Error2.jpg");
		lblNewLabel.setBounds(45, 42, 113, 117);
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Error: Correo o contraseña incorrecto");
		lblNewLabel_1.setBounds(186, 66, 228, 62);
		contentPane.add(lblNewLabel_1);
	}
}
