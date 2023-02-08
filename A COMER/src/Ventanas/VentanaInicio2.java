package Ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BasedeDatos;
import Clases.Comensal;
import Clases.Restaurante;
import Clases.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaInicio2 extends JFrame {

	private BasedeDatos bd = new BasedeDatos();
	private Map<String, Restaurante> mapaRestaurantes;
	private Map<String, Comensal> mapaComensales;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio2 frame = new VentanaInicio2();
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
	public VentanaInicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo:");
		lblNewLabel.setBounds(73, 106, 115, 50);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField("");
		textField.setBounds(232, 107, 179, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(73, 166, 115, 50);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 167, 179, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(184, 25, 131, 50);
		comboBox.addItem("Comensal");
		comboBox.addItem("Restaurante");
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(280, 257, 131, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(73, 257, 131, 50);
		contentPane.add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (comboBox.getSelectedItem().equals("Comensal")) {
					bd.connectBD();
					Comensal usuario = bd.iniciarSesionComensal(textField.getText(), textField_1.getText()); //al final que me devuelva el usuario no me sirve para nada, pensaba que lo iba a nevesitar pero no
					bd.disconnectBD();
					VentanaBuscador2 buscador = new VentanaBuscador2();
					buscador.setVisible(true);
				} else {
					bd.connectBD();
					Restaurante usuario = bd.iniciarSesionRestaurante(textField.getText(), textField_1.getText());
					bd.disconnectBD();
					VentanaRestaurante2 verRestaurante = new VentanaRestaurante2(usuario, true);
					verRestaurante.setVisible(true);
				}
			}
		});
	}
	

//		if (comboBox.getSelectedItem().equals("Comensal")) {
//			Comensal resultado = bd.iniciarSesionComensal(textField.getText(), textField_1.getText());
//		} else {
//			Restaurante resultado = bd.iniciarSesionRestaurante(textField.getText(), textField_1.getText());
//		}
}
