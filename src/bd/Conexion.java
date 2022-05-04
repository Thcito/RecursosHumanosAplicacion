package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	// Instacia de clase Connection.
	private Connection conexion;

	// Variables para la gesti�n de la conexi�n.
	private String host = "localhost:3306";
	private String usuario = "root";
	private String bd = "recursos_humanos";
	private String contrase�a = "";

	private String url = "jdbc:mysql://" + host + "/" + bd;

	// Creacion de Metodo para abrir y cerrar conexi�n.
	public Connection conectar() {

		try {
			//Carga de libreria mysql-connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection(this.url, this.usuario, this.contrase�a);

		} catch (ClassNotFoundException e) {
			System.out.println("Error en la conexi�n " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Devolucion de conexion para su uso por otra clase.
		return this.conexion;

	}
}