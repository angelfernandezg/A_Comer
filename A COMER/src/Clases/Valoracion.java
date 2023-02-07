package Clases;
public class Valoracion {

	public Comensal comensal;
	public Restaurante restaurante;
	public String fecha;
	public int estrellas;
	public String analisis;

	
	
	public Valoracion() {
		super();
	}
	public Valoracion(Comensal comesal, Restaurante restaurante, String fecha, int estrellas, String analisis) {
		super();
		this.comensal = comensal;
		this.restaurante = restaurante;
		this.fecha = fecha;
		this.estrellas = estrellas;
		this.analisis = analisis;
	}
	
	public Comensal getComensal() {
		return comensal;
	}
	public void setComensal(Comensal comensal) {
		this.comensal = comensal;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
