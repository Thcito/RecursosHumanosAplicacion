package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Conexion;
import entidades.Trabajador;

public class TrabajadorDAO {

	private Conexion conexion = new Conexion();

	// Metodo
	public boolean agregarTrabajador(Trabajador trabajador) throws SQLException {

		boolean fueAgregado = false;
		Connection conn = conexion.conectar();

		try {
			String sql = "INSERT INTO trabajador VALUES(?,?,?,?,?,?,?,?,?,?)";

			// Aqui se prepara la sentencia SQL
			// PreparedStatement es el objeto encargado de llevar la consulta hacia la base de datos
			// utilizando la conexión.
			PreparedStatement stmnt = conn.prepareStatement(sql);

			stmnt.setString(1, trabajador.getDni());
			stmnt.setString(2, trabajador.getNombre());
			stmnt.setString(3, trabajador.getApellido());
			stmnt.setString(4, trabajador.getDireccion());
			stmnt.setString(5, trabajador.getEmail());
			stmnt.setFloat(6, trabajador.getTelefono());
			stmnt.setInt(7, trabajador.getEdad());
			stmnt.setString(8, trabajador.getCargo());
			// Al ser Boolean se utiliza in en lugar de get.
			stmnt.setBoolean(9, trabajador.isSexo());
			stmnt.setBoolean(10, trabajador.isExtranjero());

			// Aqui se ejecuta la sentancia SQL
			int cantidad = stmnt.executeUpdate();

			fueAgregado = (cantidad > 0);

		} catch (Exception e) {
			System.out.println("error al agregar trabajador" + e);
		} finally {

			conn.close();

		}

		return fueAgregado;

	}

	public ArrayList<Trabajador> listaTrabajadores() throws SQLException {

		ArrayList<Trabajador> trabajadores = new ArrayList<>();

		Connection conn = conexion.conectar();

		try {
			String sql = "select * from trabajador";

			PreparedStatement stmt = conn.prepareStatement(sql);

			// ResultSet recorre la tabla que esta en memoria.
			ResultSet rs = stmt.executeQuery();

			// Cada fila leida por el while genera un objeto trabajador(con sus datos) que
			// se almacenara en el ArrayList
			while (rs.next()) {

				Trabajador t = new Trabajador();

				t.setDni(rs.getString("dni"));
				t.setNombre(rs.getString("nombre"));
				t.setApellido(rs.getString("apellido"));
				t.setDireccion(rs.getString("direccion"));
				t.setEmail(rs.getString("email"));
				t.setTelefono(rs.getFloat("telefono"));
				t.setEdad(rs.getInt("edad"));
				t.setCargo(rs.getString("cargo"));
				t.setSexo(rs.getBoolean("sexo"));
				t.setExtranjero(rs.getBoolean("esExtranjero"));

				trabajadores.add(t);

			}

		} catch (Exception e) {
			System.out.println("Error listado " + e.getMessage());
		} finally {

			conn.close();

		}
		return trabajadores;
		

	}
	
	public ArrayList<Trabajador> buscarPorDni(String dni) throws SQLException {

		ArrayList<Trabajador> trabajadores = new ArrayList<>();

		Connection conn = conexion.conectar();

		try {
			String sql = "select * from trabajador where dni = ?"; // No se pone el paramentro del where para evitar inyecciones SQL

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, dni); //Se pasa el DNI que viene por parametro de clase para lograr la busqueda

			// ResultSet recorre la tabla que esta en memoria.
			ResultSet rs = stmt.executeQuery();

			// Cada fila leida por el while genera un objeto trabajador(con sus datos) que
			// se almacenara en el ArrayList
			while (rs.next()) {

				Trabajador t = new Trabajador();

				t.setDni(rs.getString("dni"));
				t.setNombre(rs.getString("nombre"));
				t.setApellido(rs.getString("apellido"));
				t.setDireccion(rs.getString("direccion"));
				t.setEmail(rs.getString("email"));
				t.setTelefono(rs.getFloat("telefono"));
				t.setEdad(rs.getInt("edad"));
				t.setCargo(rs.getString("cargo"));
				t.setSexo(rs.getBoolean("sexo"));
				t.setExtranjero(rs.getBoolean("esExtranjero"));

				trabajadores.add(t);

			}

		} catch (Exception e) {
			System.out.println("Error listado " + e.getMessage());
		} finally {

			conn.close();

		}
		return trabajadores;

	}
	
	public boolean eliminarTrabajador(String dni) throws SQLException {
		
		boolean fueEliminado = false;
		
		Connection conn = conexion.conectar();
		
		try {
			
			String sql = "DELETE FROM trabajador WHERE dni = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, dni);
			
			fueEliminado = (stmt.executeUpdate() > 0);
					
					
		} catch (Exception e) {
			System.out.println("Error eliminando contacto" + e.getMessage());
		}finally {
			conn.close();
		}
		return fueEliminado;
	}
}
