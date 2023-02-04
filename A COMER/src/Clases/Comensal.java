package Clases;

import java.util.List;

public class Comensal extends Usuario{

	public String nombre;
	public String apellido;
	//public List<String> reservas;
	
	public Comensal(String correo, String contrasenya, String nombre, String apellido) {
		super(correo, contrasenya);
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Comensal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
