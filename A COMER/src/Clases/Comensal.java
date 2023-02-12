package Clases;

import java.util.List;

public class Comensal extends Usuario{

	public String apodo;
	//public List<String> reservas;
	
	public Comensal(String correo, String contrasenya, String apodo) {
		super(correo, contrasenya);
		this.apodo = apodo;
	}

	public Comensal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public static Comensal valueOf(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
