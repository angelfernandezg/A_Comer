import java.util.List;
import java.util.Map;

import Clases.BasedeDatos;
import Clases.Comensal;
import Clases.Respuesta;
import Clases.Restaurante;
import Clases.Valoracion;
import Ventanas.VentanaRestaurante2;
import Ventanas.VentanaVerValoraciones;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VentanaInicio v = new VentanaInicio();
		BasedeDatos bd = new BasedeDatos();
		bd.connectBD();
		Map<String, Comensal> comprobarComensales = bd.cargarComensales();
		Map<String, Restaurante> comprobarRestaurantes = bd.cargarRestaurantes();
		List<Valoracion> comprobarValoraciones = bd.cargarValoraciones();
		List<Respuesta> comprobarRespuestas = bd.cargarRespuestas();
		bd.disconnectBD();
		
		System.out.println(comprobarComensales.size());
		for (Comensal comensal : comprobarComensales.values()) {
			System.out.println(comensal.getApodo());
		}
		System.out.println(comprobarRestaurantes);
		System.out.println(comprobarValoraciones);
		System.out.println(comprobarRespuestas);
		VentanaVerValoraciones frame = new VentanaVerValoraciones();
		frame.setVisible(true);
	}

}
