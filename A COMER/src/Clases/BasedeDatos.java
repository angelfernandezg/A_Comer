package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public class BasedeDatos {

	private static Logger logger = Logger.getLogger("BasedeDatos");
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String CONNECTION_STRING = "jdbc:sqlite:resources/A_Comer.db";
	private static Connection con;
	
	public static void connectBD() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_STRING); //preguntar 
			logger.info("Se ha conectado correctamente a la BD");
		} catch(Exception e) {
			logger.warning(String.format("Error al conectar con la BD: %s", e.getMessage()));
		}
	}
	
	public static void disconnectBD() {
		try {
			con.close();
			logger.info("Se ha cerrado la conexion");
		} catch(Exception e) {
			logger.warning(String.format("Error al cerrar la conexion %s", e.getMessage()));
		}
	}
	
//	public void crearTablasBD() {
//		String sql1 = "CREATE TABLE Comensal IF DOESNT EXISTS (correo TEXT, contraseña TEXT, apodo TEXT)";
//		String sql2 = "CREATE TABLE Restaurante IF DOESNT EXISTS (correo TEXT, contraseña TEXT, nombre TEXT, direccion TEXT, tipo TEXT, valoracion INT(1), apertura INT(2), cierre INT(2)"; //Como hago un float
//		String sql3 = "CREATE TABLE Valoracion IF NOT EXISTS (comensal TEXT, restaurante TEXT, fecha DATE, valoracion INT(1), analisis TEXT)";
//		String sql4 = "CREATE TABLE Respuesta IF NOT EXISTS (restaurante TEXT, comensal TEXT, fecha DATE, respuesta TEXT)";
//		
//		try (Statement st = con.createStatement()) {
//			st.executeUpdate(sql1);
//			st.executeUpdate(sql2);
//			st.executeUpdate(sql3);
//			st.executeUpdate(sql4);
//			logger.info("Las tablas se han creado correctamente");
//		} catch (Exception e ) {
//			logger.warning(String.format("Error en la creacion de las tablas. %s", e.getMessage()));
//		}
//	}
//	
//	
	
	
}
