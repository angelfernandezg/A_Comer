package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class BasedeDatos {

	private static Logger logger = Logger.getLogger("BasedeDatos");
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String CONNECTION_STRING = "jdbc:sqlite:resources/A_Comer.db";
	private static Connection con;
	
	public void connectBD() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_STRING); //preguntar 
			logger.info("Se ha conectado correctamente a la BD");
		} catch(Exception e) {
			logger.warning(String.format("Error al conectar con la BD: %s", e.getMessage()));
		}
	}
	
	public void disconnectBD() {
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
	public void pruebaFuncionaBD() {
		String sql = "Select * from Comensal;";
		try (Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			logger.info("Funciona");
		} catch (Exception e) {
			logger.warning(String.format("Error: %s", e.getMessage()));
		}
	}
	
	
	public void cargarBD() {
		String sql1 = "Select * from Comensal;";
		String sql2 = "Select * from Restaurante";
		String sql3 = "Select * from Valoracion";
		String sql4 = "Select * from Respuesta";
		try (Statement st = con.createStatement()) {
			ResultSet rs1 = st.executeQuery(sql1);
			ResultSet rs2 = st.executeQuery(sql2);
			ResultSet rs3 = st.executeQuery(sql3);
			ResultSet rs4 = st.executeQuery(sql4);
			
		while(rs1.next()) {
			Comensal comensal = new Comensal(rs1.getString("Correo"),
											rs1.getString("Contrasenya"),
											rs1.getString("Apodo"));
		}
		while(rs2.next()) {
			Restaurante restaurante = new Restaurante(rs2.getString("Correo"),
													rs2.getString("Contrasenya"),
													rs2.getString("Nombre"),
													rs2.getString("Localidad"),
													rs2.getString("Direccion"),
													TipoRestaurante.valueOf(rs2.getString("Tipo")),
													rs2.getInt("Valoracion"),
													rs2.getInt("Apertura"),
													rs2.getInt("Cierre"));
		}
		while(rs3.next()) {
			
		}
		while(rs4.next()) {
			
		}
		
		} catch (Exception e) {
			
		}
	}
}
