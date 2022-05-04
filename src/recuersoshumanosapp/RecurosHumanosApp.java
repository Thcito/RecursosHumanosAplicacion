package recuersoshumanosapp;
import entidades.Trabajador;
import java.sql.SQLException;
import dao.TrabajadorDAO;

public class RecurosHumanosApp {

	public static void main(String[] args) {
		
	Trabajador t1 = new Trabajador ("8888888-d", "prueba", "probando", 66, "asistente", false, true);
	
	TrabajadorDAO tDAO = new TrabajadorDAO();
	
	try {
		if(tDAO.agregarTrabajador(t1)) {
			System.out.println("Nuevo trabajador agregado");
		}else {
			System.out.println("Error al agregar un nuevo trabajador");
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	}

}