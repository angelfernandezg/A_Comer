package Clases;
import java.util.List;
import java.util.Map;

public class Restaurante extends Usuario{

	public String nombre;
	public String localidad;
	public String direccion;
	//public Map<String, List<String>> carta;
	public TipoRestaurante tipo;
	public int valoracion;
	public int apertura;
	public int cierre;
	
	
	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurante(String correo, String contrasenya, String nombre, String localidad, String direccion, TipoRestaurante tipo, int valoracion, int apertura, int cierre) {
		super(correo, contrasenya);
		this.nombre = nombre;
		this.localidad = localidad;
		this.direccion = direccion;
		this.tipo = tipo;
		this.valoracion = valoracion;
		this.apertura = apertura;
		this.cierre = cierre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public TipoRestaurante getTipo() {
		return tipo;
	}
	public void setTipo(TipoRestaurante tipo) {
		this.tipo = tipo;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public int getApertura() {
		return apertura;
	}
	public void setApertura(int apertura) {
		this.apertura = apertura;
	}
	public int getCierre() {
		return cierre;
	}
	public void setCierre(int cierre) {
		this.cierre = cierre;
	}
	
}
