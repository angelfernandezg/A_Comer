package Ventanas;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.BasedeDatos;
import Clases.Comensal;
import Clases.Respuesta;
import Clases.Restaurante;
import Clases.TipoRestaurante;
import Clases.Valoracion;

import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnas = {"De", "A", "Fecha", "Estrellas", "Analisis"};
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		
		table = new JTable(modelo);
		table.setBounds(89, 10, 452, 426);
		JScrollPane barra = new JScrollPane(table);
		barra.setBounds(89, 10, 452, 426);
		contentPane.add(barra);
		
		verValoracionesYRespuestas(modelo);
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
