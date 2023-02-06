import Clases.BasedeDatos;
import Ventanas.VentanaRestaurante2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VentanaInicio v = new VentanaInicio();
		BasedeDatos bd = new BasedeDatos();
		bd.connectBD();
		bd.pruebaFuncionaBD();
		bd.disconnectBD();
		
		VentanaRestaurante2 vr2 = new VentanaRestaurante2();
		vr2.Reservar();
	}

}
