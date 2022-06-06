package bd;

import java.sql.*;

public class Conexion {

	// Instacia de clase Connection.
	private Connection conexion;

	// Variables para la gestión de la conexión.
	private String host = "localhost:3306";
	private String bd = "recursoshumanosapp";
	
	private String usuario = "root";
	private String contraseña = "";

	private String url = "jdbc:mysql://" + host + "/" + bd;

	// Creacion de Metodo para abrir y cerrar conexión.
	
	public Connection conectar() {

		try {
			//Carga de libreria mysql-connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, contraseña);
			
			Statement stmt = conexion.createStatement();
			
			String sqlBd = "CREATE DATABASE IF NOT EXISTS recursoshumanosapp";
			stmt.execute(sqlBd);
			
			String sqlTabla = "CREATE TABLE IF NOT EXISTS trabajador (dni VARCHAR(15) NOT NULL, "
		    		+ "nombre VARCHAR(50) NOT NULL,"
		    		+ " apellido VARCHAR(50) NOT NULL, "
		    		+ "direccion VARCHAR(100) NOT NULL, "
		    		+ "email VARCHAR(50) NOT NULL, "
		    		+ "telefono FLOAT(50) NOT NULL, "
		    		+ "edad INT(11) NOT NULL, "
		    		+ "cargo VARCHAR(50) NOT NULL, "
		    		+ "sexo BIT(1) NOT NULL, "
		    		+ "esExtranjero BIT(1)NOT NULL, "
		    		+ "PRIMARY KEY (dni))"
		    		+ "ENGINE=InnoDB DEFAULT  CHARSET=latin1";
			
			stmt.execute(sqlTabla);
								
		} catch (ClassNotFoundException e) {
			System.out.println("Error en la conexión " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Devolucion de conexion para su uso por otra clase.
		return this.conexion;

	}
	
	
		
}