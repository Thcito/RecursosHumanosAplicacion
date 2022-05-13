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
			
			//Aqui se prepara la sentencia SQL
			//PS es el objeto encargado de llevar la consulta hacia la base de datos utilizando la conexión.
			PreparedStatement stmnt =conn.prepareStatement(sql);
			
			stmnt.setString(1, trabajador.getDni());
			stmnt.setString(2, trabajador.getNombre());
			stmnt.setString(3, trabajador.getApellido());
			stmnt.setInt(4, trabajador.getEdad());
			stmnt.setString(5, trabajador.getCargo());
			//Al ser Boolean se utiliza in en lugar de get.
			stmnt.setBoolean(6, trabajador.isGenero());
			stmnt.setBoolean(7, trabajador.isExtranjero());
			
			//Aqui se ejecuta la sentancia SQL 
			int cantidad = stmnt.executeUpdate();
			
			fueAgregado = (cantidad > 0 );
			
			
		} catch (Exception e) {
			System.out.println("error al agregar trabajador" + e);
		} finally {
			conn.close();
		}

		return fueAgregado;

	}
}
