package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	
	public Map<String, Comensal> cargarComensales() {
		
		Map<String, Comensal> mapaComensales = new HashMap<>();
		String sql1 = "Select * from Comensal;";
		try (Statement st = con.createStatement()) {
			ResultSet rs1 = st.executeQuery(sql1);
			while(rs1.next()) {
				mapaComensales.put(rs1.getString("Apodo"), new Comensal(rs1.getString("Correo"),
														rs1.getString("Contraseña"),
														rs1.getString("Apodo")));
			}
			logger.info("Se han cargado correctamente los Comensales de la BD");
		} catch (Exception e) {
			logger.warning(String.format("Error de BD al cargar los Comensales: %s", e.getMessage()));
		}
		return mapaComensales;
	}
	
	public Map<String, Restaurante> cargarRestaurantes() {
		Map<String, Restaurante> mapaRestaurantes = new HashMap<>();
		String sql2 = "Select * from Restaurante";
		try (Statement st = con.createStatement()) {
			ResultSet rs2 = st.executeQuery(sql2);
			while(rs2.next()) {
				mapaRestaurantes.put(rs2.getString("Nombre"), new Restaurante(rs2.getString("Correo"),
																			rs2.getString("Contraseña"),
																			rs2.getString("Nombre"),
																			rs2.getString("Localidad"),
																			rs2.getString("Direccion"),
																			TipoRestaurante.valueOf(rs2.getString("Tipo")),
																			rs2.getInt("Valoracion"),
																			rs2.getInt("Apertura"),
																			rs2.getInt("Cierre")));
			}
			logger.info("Se han cargado correctamente los Restaurantes de la BD");
		} catch (Exception e) {
			logger.warning(String.format("Error de BD al cargar los Restaurantes: %s", e.getMessage()));
		}
		return mapaRestaurantes;
	}
	
	public List<Valoracion> cargarValoraciones() {
		Map<String, Comensal> mapaComensales = cargarComensales();
		Map<String, Restaurante> mapaRestaurantes = cargarRestaurantes();
		List<Valoracion> listaValoraciones = new ArrayList<>();
		String sql3 = "Select * from Valoracion";
		try(Statement st = con.createStatement()) {
			ResultSet rs3 = st.executeQuery(sql3);
			while(rs3.next()) {
				listaValoraciones.add(new Valoracion(mapaComensales.get(rs3.getString("Comensal")),
						mapaRestaurantes.get(rs3.getString("Restaurante")),
						rs3.getString("Fecha"),
						rs3.getInt("Estrellas"),
						rs3.getString("Analisis")));
				//System.out.println(mapaComensales.get(rs3.getString("Comensal")).getApodo() + mapaRestaurantes.get(rs3.getString("Restaurante")).getNombre() + rs3.getString("Fecha") + rs3.getInt("Estrellas") + rs3.getString("Analisis"));
			}
			logger.info("Se han cargado correctamente las Valoraciones de la BD");
		} catch (Exception e) {
			logger.warning(String.format("Error de BD al cargar las Valoraciones: %s", e.getMessage()));
		}
		return listaValoraciones;
	}
	
//	public List<Valoracion> cargarValoraciones() {
//		Map<String, Comensal> mapaComensales = cargarComensales();
//		Map<String, Restaurante> mapaRestaurantes = cargarRestaurantes();
//		List<Valoracion> listaValoraciones = new ArrayList<>();
//		String sql3 = "Select * from Valoracion";
//		try(Statement st = con.createStatement()) {
//			ResultSet rs3 = st.executeQuery(sql3);
//			while(rs3.next()) {
//				listaValoraciones.add(new Valoracion(Comensal.valueOf(rs3.getString("Comensal")),
//						Restaurante.valueOf(rs3.getString("Restaurante")),
//						rs3.getString("Fecha"),
//						rs3.getInt("Estrellas"),
//						rs3.getString("Analisis")));
//				//System.out.println(mapaComensales.get(rs3.getString("Comensal")).getApodo() + mapaRestaurantes.get(rs3.getString("Restaurante")).getNombre() + rs3.getString("Fecha") + rs3.getInt("Estrellas") + rs3.getString("Analisis"));
//			}
//			logger.info("Se han cargado correctamente las Valoraciones de la BD");
//		} catch (Exception e) {
//			logger.warning(String.format("Error de BD al cargar las Valoraciones: %s", e.getMessage()));
//		}
//		return listaValoraciones;
//	}
	
	public List<Respuesta> cargarRespuestas() {
		Map<String, Comensal> mapaComensales = cargarComensales();
		Map<String, Restaurante> mapaRestaurantes = cargarRestaurantes();
		List<Respuesta> listaRespuestas = new ArrayList<>();
		String sql4 = "Select * from Respuesta";
		try (Statement st = con.createStatement()) {
			ResultSet rs4 = st.executeQuery(sql4);
			while(rs4.next()) {
				listaRespuestas.add(new Respuesta(mapaRestaurantes.get(rs4.getString("Restaurante")),
						mapaComensales.get(rs4.getString("Comensal")),
						rs4.getString("Fecha"),
						rs4.getString("Respuesta")));
			}
			logger.info("Se han cargado correctamente las Respuestas de la BD");
		} catch (Exception e) {
			logger.warning(String.format("Error de BD al cargar las Respuestas: %s", e.getMessage()));
		}
		return listaRespuestas;
	}
	
//	public List<Respuesta> cargarRespuestas() {
//		Map<String, Comensal> mapaComensales = cargarComensales();
//		Map<String, Restaurante> mapaRestaurantes = cargarRestaurantes();
//		List<Respuesta> listaRespuestas = new ArrayList<>();
//		String sql4 = "Select * from Respuesta";
//		try (Statement st = con.createStatement()) {
//			ResultSet rs4 = st.executeQuery(sql4);
//			while(rs4.next()) {
//				listaRespuestas.add(new Respuesta(Restaurante.valueOf(rs4.getString("Restaurante")),
//						Comensal.valueOf(rs4.getString("Comensal")),
//						rs4.getString("Fecha"),
//						rs4.getString("Respuesta")));
//			}
//			logger.info("Se han cargado correctamente las Respuestas de la BD");
//		} catch (Exception e) {
//			logger.warning(String.format("Error de BD al cargar las Respuestas: %s", e.getMessage()));
//		}
//		return listaRespuestas;
//	}
	
	public Comensal iniciarSesionComensal(String correo, String contrasenya) {
		Comensal resultado = new Comensal();
		try (Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery("Select * from Comensal where Correo = '" + correo + "' and Contraseña = '" + contrasenya + "';");
			resultado = new Comensal(rs.getString("Correo"),
											rs.getString("Contraseña"),
											rs.getString("Apodo"));
			logger.info("iniciarSesionComensal se ha ejercutado correctamente");
		} catch (Exception e) {
			logger.warning(String.format("Error al iniciarSesionComensal: %s", e.getMessage()));
		}
		return resultado;
	}
	
	public Restaurante iniciarSesionRestaurante(String correo, String contrasenya) {
		Restaurante resultado = new Restaurante();
		try (Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery("Select * from Restaurante where Correo = '" + correo + "' and Contraseña = '" + contrasenya + "';");
			resultado = new Restaurante(rs.getString("Correo"),
													rs.getString("Contraseña"),
													rs.getString("Nombre"),
													rs.getString("Localidad"),
													rs.getString("Direccion"),
													TipoRestaurante.valueOf(rs.getString("Tipo")),
													rs.getInt("Valoracion"),
													rs.getInt("Apertura"),
													rs.getInt("Cierre"));
			logger.info("iniciarSesionRestaurante se ha ejercutado correctamente");
		} catch (Exception e) {
			logger.warning(String.format("Error al iniciarSesionRestaurante: %s", e.getMessage()));
		}
		
		return resultado;
	}
	
	public void guardarValoracionBD(String comensal, String restaurante, String fecha, int estrellas, String reseña) {
		String sql = "Insert into Valoracion values ('%s', '%s', '%s', '%d', '%s')";
		try (Statement st = con.createStatement()) {
			st.executeUpdate(String.format(sql, comensal, restaurante, fecha, estrellas, reseña));
			logger.info("Se ha añadido correctamente a la tabla Valoracion de la BD");
			
		} catch (Exception e) {
			logger.warning(String.format("Error de BD al añadir a la tabla Valoracion: %s", e.getMessage()));
		}
	}
	public void guardarRespuestaBD(String restaurante, String comensal, String fecha, String reseña) {
		String sql = "Insert into Respuesta values('%s', '%s', '%s', '%s')";
		try (Statement st = con.createStatement()) {
			st.executeUpdate(String.format(sql, restaurante, comensal, fecha, reseña));
			logger.info("Se ha añadido correctamente a la tabla Respuesta de la BD");
		} catch (Exception e) {
			logger.warning(String.format("Error de BD al añadir a la tabla Respuesta", e.getMessage()));
		}
	}
}
