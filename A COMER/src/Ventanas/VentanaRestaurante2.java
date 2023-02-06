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

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;

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
					VentanaRestaurante2 frame = new VentanaRestaurante2();
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
	public VentanaRestaurante2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setBounds(25, 31, 279, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(25, 81, 279, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion");
		lblNewLabel_1.setBounds(25, 136, 279, 37);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(335, 470, 432, -438);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBounds(25, 294, 279, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valorar");
		btnNewButton_1.setBounds(25, 349, 120, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Responder");
		btnNewButton_2.setBounds(184, 349, 120, 45);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Horario");
		lblNewLabel_3.setBounds(25, 183, 279, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Valoracion");
		lblNewLabel_4.setBounds(25, 230, 279, 40);
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
