package Ventanas;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaInicio extends JFrame{

	protected JTextField tnombre;
	protected JTextField tcontrasenya;
	protected JButton login;
	protected JButton singup;
	protected JLabel lnombre;
	protected JLabel lcontrasenya;
	
	public VentanaInicio() {
		Container cp = this.getContentPane();
		
		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		JPanel abajo = new JPanel();
		
		tnombre = new JTextField(20);
		//tnombre.setBounds(, , , );;
		tcontrasenya = new JTextField(20);
		login = new JButton("Log In");
		singup = new JButton("Sing up");
		lnombre = new JLabel("Nombre:");
		lcontrasenya = new JLabel("Contraseña:");
		
		arriba.add(lnombre);
		centro.add(lcontrasenya);
		arriba.add(tnombre);
		centro.add(tcontrasenya);
		abajo.add(login);
		abajo.add(singup);
		
		cp.setLayout( new BorderLayout());
		cp.add(arriba, BorderLayout.NORTH);
		cp.add(centro, BorderLayout.CENTER);
		cp.add(abajo, BorderLayout.SOUTH);
		
		this.setTitle("Inicio");
		this.setSize(800,400);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
