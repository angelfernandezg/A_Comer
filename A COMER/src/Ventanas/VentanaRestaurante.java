package Ventanas;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaRestaurante extends JFrame{

	protected JLabel lblnombre;
	protected JPanel pnlnombre;
	protected JLabel lbldireccion;
	protected JPanel pnldireccion;
	protected JLabel lblhorario;
	protected JPanel pnlhorario;
	protected JLabel lblcarta;
	protected JPanel pnlcarta;
	//la foto
	//las estrellas
	protected JButton vervalo;
	protected JButton escribirvalo;
	
	public VentanaRestaurante() {
		
		Container cp = this.getContentPane();
		
		lblnombre = new JLabel("Nombre:");
		pnlnombre = new JPanel();
		lbldireccion = new JLabel("Direccion:");
		pnldireccion = new JPanel();
		lblhorario = new JLabel("Horario:");
		pnlhorario = new JPanel();
		
		vervalo = new JButton();
		escribirvalo = new JButton();
		
	}
}
