package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bd.Conexion;
import entidades.Trabajador;

public class TrabajadorDAO {

	private Conexion conexion = new Conexion();
	
	//Metodo 
	public boolean agregarTrabajador(Trabajador trabajador) throws SQLException {

		boolean fueAgregado = false;
		Connection conn = conexion.conectar();

		try {
			String sql = "INSERT INTO trabajador VALUES(?,?,?,?,?,?,?)";
			
			//PS es el objeto encargado de llevar la consulta hacia la base de datos utilizando la conexión.
			PreparedStatement stmt =conn.prepareStatement(sql);
			
			stmt.setString(1, trabajador.getDni());
			stmt.setString(2, trabajador.getNombre());
			stmt.setString(3, trabajador.getApellido());
			stmt.setInt(4, trabajador.getEdad());
			stmt.setString(5, trabajador.getCargo());
			stmt.setBoolean(6, trabajador.isGenero());
			stmt.setBoolean(7, trabajador.isExtranjero());
			
			//Se ejecuta la sentancia SQL 
			int cantidad = stmt.executeUpdate();
			
			fueAgregado = (cantidad > 0 );
			
			
		} catch (Exception e) {
			System.out.println("error al agregar trabajador" + e);
		} finally {
			conn.close();
		}

		return fueAgregado;

	}
}
