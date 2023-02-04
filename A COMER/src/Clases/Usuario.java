package Clases;
public class Usuario {

	public String correo;
	protected String contrasenya;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String correo, String contrasenya) {
		super();
		this.correo = correo;
		this.contrasenya = contrasenya;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
}
