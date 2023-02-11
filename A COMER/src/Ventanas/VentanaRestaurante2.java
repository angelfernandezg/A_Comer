package Ventanas;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Comensal;
import Clases.Restaurante;
import Clases.TipoRestaurante;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRestaurante2 extends JFrame {

	private static Logger logger = Logger.getLogger("VentanaRestaurante2");
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRestaurante2 frame = new VentanaRestaurante2(new Restaurante("correoPrueba", "contraseñaPrueba", "nombrePreba", "albacete", "calle kalea", TipoRestaurante.pizzeria, 1, 12, 17), false, true);
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
	public VentanaRestaurante2(Restaurante restaurante, boolean puedeResponder, boolean puedeReservar) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(335, 470, 432, -438);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBounds(253, 294, 212, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valorar");
		btnNewButton_1.setBounds(25, 349, 218, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Responder");
		btnNewButton_2.setBounds(253, 349, 212, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver Valoraciones");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVerValoraciones frame = new VentanaVerValoraciones();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(25, 294, 218, 45);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a :" + restaurante.getNombre());
		lblNewLabel.setBounds(25, 30, 432, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Se encuentra en :" + restaurante.getDireccion() + "," + restaurante.getLocalidad());
		lblNewLabel_1.setBounds(25, 74, 432, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estanos abiertos desde las " + restaurante.getApertura() + ":00 hasta las " + restaurante.getCierre() + ":00");
		lblNewLabel_2.setBounds(25, 118, 432, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de Estrellas: " + restaurante.getValoracion());
		lblNewLabel_3.setBounds(25, 162, 432, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de Restaurnate: " + restaurante.getTipo().toString());
		lblNewLabel_4.setBounds(25, 206, 432, 34);
		contentPane.add(lblNewLabel_4);
	}
	
	public void Reservar() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources/Reservas.txt"))) {
			bw.write("Federico ha realizado una reserva para 4 personas a las 6:00");
			//bw.write(comensal.getApodo() + "ha realizado una reserva para " + "X" + "a las :" + "");
		} catch (Exception e) {
			logger.warning(String.format("Error al escribir en el fichero: %s", e.getMessage()));
		}
	}
}
