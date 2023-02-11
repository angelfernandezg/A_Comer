package Ventanas;

import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BasedeDatos;
import Clases.Comensal;
import Clases.Restaurante;
import Clases.TipoRestaurante;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaValoracion extends JFrame {

	private Calendar cal = Calendar.getInstance();
	private BasedeDatos bd = new BasedeDatos();
	private JPanel contentPane;
	private JTextField textField;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaValoracion frame = new VentanaValoracion(new Restaurante("correoPrueba", "contraseñaPrueba", "nombrePreba", "albacete", "calle kalea", TipoRestaurante.pizzeria, 1, 12, 17));
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
	public VentanaValoracion(Restaurante restaurante) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SpinnerNumberModel valoresSpinner = new SpinnerNumberModel(1, 1, 5, 1);
		spinner = new JSpinner(valoresSpinner);
		spinner.setBounds(221, 26, 130, 57);
		contentPane.add(spinner);
		
		textField = new JTextField();
		textField.setBounds(200, 123, 363, 154);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Estrellas:");
		lblNewLabel.setBounds(31, 26, 130, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reseña:");
		lblNewLabel_1.setBounds(31, 143, 130, 57);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(413, 26, 151, 57);
		contentPane.add(btnNewButton);
	}
	
	public void guardarValoracion(Comensal comensal, Restaurante restaurante) {
		String reseña = textField.getText();
		Integer estrellas = (Integer) spinner.getValue();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		if (month.length() == 1) {
			month = "0" + month;
		}
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String fecha = year + "-" + month + "-" + day;
		bd.guardarValoracionBD(comensal.getApodo(), restaurante.getNombre(), fecha, estrellas, reseña);
	}
}
