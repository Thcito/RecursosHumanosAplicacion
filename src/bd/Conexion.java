package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	// Instacia de clase Connection.
	private Connection conexion;

	// Variables para la gestión de la conexión.
	private String host = "localhost:3306";
	private String usuario = "root";
	private String bd = "recursos_humanos";
	private String contraseña = "";

	private String url = "jdbc:mysql://" + host + "/" + bd;

	// Creacion de Metodo para abrir y cerrar conexión.
	public Connection conectar() {

		try {
			//Carga de libreria mysql-connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection(this.url, this.usuario, this.contraseña);

		} catch (ClassNotFoundException e) {
			System.out.println("Error en la conexión " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Devolucion de conexion para su uso por otra clase.
		return this.conexion;

	}
}