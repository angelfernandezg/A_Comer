package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public class BasedeDatos {

	private static Logger logger = Logger.getLogger("BasedeDatos");
	private static final String DRIVER = "org.sqlite.JDBC";
	private static Connection con;
	
	public static void connectBD() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection("jdbc:sqlite:"); //preguntar 
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
	
	public void crearTablasBD() {
		String sql1 = "CREATE TABLE Comensal IF DOESNT EXISTS (correo VARHCAR(20), contraseña VARCHAR(20), nombre VARCHAR(20), apellido VARCHAR(20))";
		String sql2 = "CREATE TABLE Restaurante IF DOESNT EXISTS (correo VARHCAR(20), contraseña VARCHAR(20), nombre VARCHAR(20), direccion VARCHAR(20), tipo VARCHAR(20), valoracion INT(1), apertura INT(2), cierre INT(2)"; //Como hago un float
		String sql3 = "CREATE TABLE Valoracion IF NOT EXISTS (codigo CHAR(4), usuario VARCHAR(20), restaurante VARCHAR(20), fecha DATE, estrellas INT(1), analisis VARCHAR(50))";
		String sql4 = "CREATE TABLE Respuesta IF NOT EXISTS (valoracion CHAR(4), fecha DATE, respuesta VARHCAR(50))";
		
		try (Statement st = con.createStatement()) {
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.executeUpdate(sql4);
			logger.info("Las tablas se han creado correctamente");
		} catch (Exception e ) {
			logger.warning(String.format("Error en la creacion de las tablas. %s", e.getMessage()));
		}
	}
	
	
}
