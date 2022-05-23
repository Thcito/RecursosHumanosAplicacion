package recuersoshumanosapp;


import java.sql.SQLException;


import dao.TrabajadorDAO;

public class RecurosHumanosApp {

	public static void main(String[] args) {

		TrabajadorDAO tDAO = new TrabajadorDAO();
		/*
		 * Trabajador t1 = new Trabajador ("8888888-d", "prueba", "probando", 66,
		 * "asistente", false, true);
		 * 
		 * //Instancia de TrabajadorDAO TrabajadorDAO tDAO = new TrabajadorDAO(); try {
		 * if(tDAO.agregarTrabajador(t1)) {
		 * System.out.println("Nuevo trabajador agregado"); }else {
		 * System.out.println("Error al agregar un nuevo trabajador"); } } catch
		 * (SQLException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		

		/*try {
			ArrayList<Trabajador> trabajadores = tDAO.listaTrabajadores();
			for (Trabajador i : trabajadores) {
				System.out.println(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		try {
			if (tDAO.eliminarTrabajador("12345679")) {
				System.out.println("Eliminado");
			}else {
				System.out.println("Error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}