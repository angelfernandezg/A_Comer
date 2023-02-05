package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;

public class VentanaBuscador2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private SpinnerNumberModel valoresSpinner;
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(40, 98, 135, 53);
		comboBox.addItem("MARISQUERIA");
		comboBox.addItem("MENU");
		comboBox.addItem("PIZZERIA");
		comboBox.addItem("CERVECERA");
		contentPane.add(comboBox);
		
		SpinnerNumberModel valoresSpinner = new SpinnerNumberModel(1, 1, 5, 1); //default, minimo, maximo, incremento
		JSpinner spinner = new JSpinner(valoresSpinner);
		spinner.setBounds(40, 237, 135, 53);
		contentPane.add(spinner);
		
		JList list = new JList();
		list.setBounds(234, 98, 502, 389);
		contentPane.add(list);
	}
}
