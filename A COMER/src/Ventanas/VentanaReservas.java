package Ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Comensal;
import Clases.Restaurante;
import Clases.TipoRestaurante;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class VentanaReservas extends JFrame {

	private JPanel contentPane;
	private Comensal comensal;
	private Restaurante restaurante;
	private SpinnerNumberModel personas;
	private SpinnerNumberModel horas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservas frame = new VentanaReservas(new Comensal("correoPurebaComensal", "contraseñaPruebaComensal", "apodoPrueba"),new Restaurante("correoPrueba", "contraseñaPrueba", "nombrePreba", "albacete", "calle kalea", TipoRestaurante.pizzeria, 1, 12, 17));
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
	public VentanaReservas(Comensal comensal, Restaurante restaurante) {
		this.comensal = comensal;
		this.restaurante = restaurante;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personas");
		lblNewLabel.setBounds(47, 39, 97, 56);
		contentPane.add(lblNewLabel);
		
		personas = new SpinnerNumberModel(1, 1, 12, 1);
		JSpinner spinner = new JSpinner(personas);
		spinner.setBounds(165, 40, 97, 56);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Hora");
		lblNewLabel_1.setBounds(47, 116, 97, 56);
		contentPane.add(lblNewLabel_1);
		
		horas = new SpinnerNumberModel(restaurante.getApertura(), restaurante.getApertura(), restaurante.getCierre(), 1);
		JSpinner spinner_1 = new JSpinner(horas);
		spinner_1.setBounds(165, 117, 97, 56);
		contentPane.add(spinner_1);
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBounds(293, 74, 120, 56);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Reservar();
				VentanaReservaCorrecta vrc = new VentanaReservaCorrecta();
				vrc.setVisible(true);
			}
		});
	}
	
	public void Reservar() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources/Reservas.txt", true))) {
			bw.newLine();
			bw.write(comensal.getApodo() + " ha realizado una reserva para " + personas.getValue().toString() + " personas a las " + horas.getValue().toString() + ":00 en " + restaurante.getNombre());
			//bw.write(comensal.getApodo() + "ha realizado una reserva para " + "X" + "a las :" + "");
			bw.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
