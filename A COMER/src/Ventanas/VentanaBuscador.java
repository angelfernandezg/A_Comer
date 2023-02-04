package Ventanas;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaBuscador extends JFrame{

	protected JTextField localidad;
	protected JComboBox tipo;
	protected JCheckBox estruno;
	protected JCheckBox estrdos;
	protected JCheckBox estrtres;
	protected JCheckBox estrcuatro;
	protected JCheckBox estrcinco;
	protected JButton buscar;
	protected JPanel resultados;
	
	public VentanaBuscador() {
		
		Container cp = this.getContentPane();
		
		JPanel izquierda = new JPanel();
		izquierda.setLayout(new BorderLayout());
		JPanel derecha = new JPanel();
		derecha.setLayout(new BorderLayout());
		JPanel numestrellas = new JPanel();
		
		localidad = new JTextField(20);
		
		tipo = new JComboBox();
		tipo.addItem("MARISQUERIA");
		tipo.addItem("MENU");
		tipo.addItem("PIZZERIA");
		tipo.addItem("CERVECERA");
		
		estruno = new JCheckBox();
		estrdos = new JCheckBox();
		estrtres = new JCheckBox();
		estrcuatro = new JCheckBox();
		estrcinco = new JCheckBox();
		
		buscar = new JButton("Buscar");
		
		buscar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		resultados = new JPanel();
		
		cp.setLayout(new BorderLayout());
		
		cp.add(localidad, BorderLayout.NORTH);
		cp.add(tipo, BorderLayout.WEST);
		numestrellas.add(estruno);
		numestrellas.add(estrdos);
		numestrellas.add(estrtres);
		numestrellas.add(estrcuatro);
		numestrellas.add(estrcinco);
		cp.add(numestrellas, BorderLayout.SOUTH);
		
		cp.add(buscar, BorderLayout.EAST);
		cp.add(resultados, BorderLayout.CENTER);
		
		this.setSize(800,400);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
