package Ventanas;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.BasedeDatos;
import Clases.Respuesta;
import Clases.Valoracion;

import javax.swing.JTable;

public class VentanaVerValoraciones extends JFrame {

	private BasedeDatos bd = new BasedeDatos();
	private List<Valoracion> listaValoraciones;
	private List<Respuesta> listaRespuestas;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerValoraciones frame = new VentanaVerValoraciones();
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
	public VentanaVerValoraciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		String[] columnas = {"De", "A", "Fecha", "Estrellas", "Analisis"};
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		
		table = new JTable(modelo);
		JScrollPane barra = new JScrollPane(table);
		barra.setBounds(232, 113, 400, 250);
		contentPane.add(barra);
		
		verValoracionesYRespuestas(modelo);
		this.setVisible(true);
	}
	
	public void verValoracionesYRespuestas(DefaultTableModel modelo) {
		bd.connectBD();
		listaValoraciones = bd.cargarValoraciones();
		listaRespuestas = bd.cargarRespuestas();
		bd.disconnectBD();
		modelo.setRowCount(0);
		for (Valoracion valoracion : listaValoraciones) {
			modelo.addRow(new Object[] { valoracion.getComensal(), valoracion.getRestaurante(), valoracion.getFecha(), String.valueOf(valoracion.getEstrellas()), valoracion.getAnalisis()});
		}
	}

}
