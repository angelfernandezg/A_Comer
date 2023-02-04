package Clases;
import java.util.List;
import java.util.Map;

public class Restaurante extends Usuario{

	public String nombre;
	public String direccion;
	//public Map<String, List<String>> carta;
	public TipoRestaurante tipo;
	public int valoracion;
	
	
	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurante(String correo, String contrasenya, String nombre, String direccion, TipoRestaurante tipo, int valoracion) {
		super(correo, contrasenya);
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.valoracion = valoracion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
