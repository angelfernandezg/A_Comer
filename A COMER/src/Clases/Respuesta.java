package Clases;

public class Respuesta{

	public Restaurante Restaurante;
	public Comensal Comensal;
	public String fecha;
	public String respuesta;
	
	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Respuesta(Clases.Restaurante restaurante, Clases.Comensal comensal, String fecha, String respuesta) {
		super();
		Restaurante = restaurante;
		Comensal = comensal;
		this.fecha = fecha;
		this.respuesta = respuesta;
	}

	public Restaurante getRestaurante() {
		return Restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		Restaurante = restaurante;
	}

	public Comensal getComensal() {
		return Comensal;
	}

	public void setComensal(Comensal comensal) {
		Comensal = comensal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
