package Ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BasedeDatos;
import Clases.Restaurante;
import Clases.TipoRestaurante;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaRespuesta extends JFrame {

	private BasedeDatos bd = new BasedeDatos();
	private Calendar cal = Calendar.getInstance();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRespuesta frame = new VentanaRespuesta(new Restaurante("correoPrueba", "contraseñaPrueba", "nombrePreba", "albacete", "calle kalea", TipoRestaurante.pizzeria, 1, 12, 17));
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
	public VentanaRespuesta(Restaurante restaurante) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario dirigido");
		lblNewLabel.setBounds(27, 33, 85, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Respuesta");
		lblNewLabel_1.setBounds(27, 113, 85, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(131, 33, 96, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 113, 161, 96);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(27, 188, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guardarRespuesta(restaurante);
			}
		});
	}
	
	public void guardarRespuesta(Restaurante restaurante) {
		String comensal = textField.getText();
		String respuesta = textField_1.getText();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		if (month.length() == 1) {
			month = "0" + month;
		}
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String fecha = year + "-" + month + "-" + day;
		bd.connectBD();
		bd.guardarRespuestaBD(comensal, restaurante.getNombre(), fecha, respuesta);
		bd.disconnectBD();
	}
}
