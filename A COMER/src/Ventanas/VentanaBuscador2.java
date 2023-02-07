package Ventanas;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.BasedeDatos;
import Clases.Restaurante;
import Clases.TipoRestaurante;

import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTable;

public class VentanaBuscador2 extends JFrame {

	private BasedeDatos bd = new BasedeDatos();
	private Map<String, Restaurante> mapaRestaurantes;
	private JPanel contentPane;
	private JTextField textField;
	private SpinnerNumberModel valoresSpinner;
	private JSpinner spinner;
	private JTable table;
	private JComboBox comboTipos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscador2 frame = new VentanaBuscador2();
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
	public VentanaBuscador2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(79, 10, 543, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(629, 10, 108, 59);
		contentPane.add(btnNewButton);
		
		comboTipos = new JComboBox();
		comboTipos.setBounds(40, 132, 135, 53);
		comboTipos.addItem("Cualquiera");
		comboTipos.addItem("marisqueria");
		comboTipos.addItem("menu");
		comboTipos.addItem("pizzeria");
		comboTipos.addItem("cervecera");
		contentPane.add(comboTipos);
		
		valoresSpinner = new SpinnerNumberModel(0, 0, 5, 1); //default, minimo, maximo, incremento
		spinner = new JSpinner(valoresSpinner);// 0 -> da igual
		spinner.setBounds(40, 209, 135, 53);
		contentPane.add(spinner);
		
		String[] columnas = {"Nombre", "Tipo", "Localidad", "Estrellas"};
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	
		table = new JTable(modelo);
		table.setBounds(232, 113, 504, 289);
		JScrollPane barra = new JScrollPane(table);
		barra.setBounds(232, 113, 504, 289);
		contentPane.add(barra);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buscador(modelo);
			}
		});
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JTable table = (JTable) e.getSource();
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				Restaurante seleccionado = null;
				if (e.getClickCount() == 2) {
					//Obtener el restaurante seleccionado
					String nombre = (String) table.getValueAt(row, 0);
					for (Restaurante restaurante : mapaRestaurantes.values()) {
						if (restaurante.getNombre().equals(nombre)) {
							seleccionado = restaurante;
						}
					}
					//Abrir una nueva ventana del restaurante
					VentanaRestaurante2 verRestaurante = new VentanaRestaurante2(seleccionado);
					verRestaurante.setVisible(true);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void buscador(DefaultTableModel modelo) {
		String localidad = textField.getText();
		String tipo = (String) comboTipos.getSelectedItem();
		Integer estrellas = (Integer) spinner.getValue();
		modelo.setRowCount(0); //borra las lineas que estaban en la tabla para sacar solo las nuevas
		bd.connectBD();
		mapaRestaurantes = bd.cargarRestaurantes();
		bd.disconnectBD();
		if (localidad.equals("") && tipo.equals("Cualquiera") && estrellas == 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
			}
		} else if (!localidad.equals("") && tipo.equals("Cualquiera") && estrellas == 0){
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getLocalidad().equals(localidad.toLowerCase())) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		} else if (localidad.equals("") && !tipo.equals("Cualquiera") && estrellas == 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getTipo().toString().equals(tipo)) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		} else if (!localidad.equals("") && !tipo.equals("Cualquiera") && estrellas == 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getLocalidad().equals(localidad.toLowerCase()) && restaurante.getTipo().toString().equals(tipo)) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		} else if (localidad.equals("") && tipo.equals("Cualquiera") && estrellas != 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getValoracion() == estrellas) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		} else if (!localidad.equals("") && tipo.equals("Cualquiera") && estrellas != 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getLocalidad().equals(localidad.toLowerCase()) && restaurante.getValoracion() == estrellas) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		} else if (localidad.equals("") && !tipo.equals("Cualquiera") && estrellas != 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getTipo().toString().equals(tipo) && restaurante.getValoracion() == estrellas) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		} else if (!localidad.equals("") && !tipo.equals("Cualquiera") && estrellas != 0) {
			for (Restaurante restaurante : mapaRestaurantes.values()) {
				if (restaurante.getLocalidad().equals(localidad.toLowerCase()) && restaurante.getTipo().toString().equals(tipo) && restaurante.getValoracion() == estrellas) {
					modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
				}
			}
		}
	}
	
//	public void buscador(DefaultTableModel modelo) {
//		modelo.setRowCount(0); //borra las lineas que estaban en la tabla para sacar solo las nuevas
//		bd.connectBD();
//		mapaRestaurantes = bd.cargarRestaurantes();
//		bd.disconnectBD();
//		for (Restaurante restaurante : mapaRestaurantes.values()) {
//			modelo.addRow(new Object[] { restaurante.getNombre(), restaurante.getTipo(), restaurante.getLocalidad(), restaurante.getValoracion()});
//		}
//	}
	
}
