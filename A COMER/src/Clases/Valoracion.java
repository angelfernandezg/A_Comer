package Clases;
public class Valoracion {

	public String codigo;
	public Usuario usuario;
	public Restaurante restaurante;
	public int estrellas;
	public long fecha;
	public String analisis;

	
	
	public Valoracion() {
		super();
	}
	public Valoracion(String codigo, Usuario usuario, Restaurante restaurante, int estrellas, String analisis) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.estrellas = estrellas;
		this.analisis = analisis;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getAnalisis() {
		return analisis;
	}
	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}
	
}
