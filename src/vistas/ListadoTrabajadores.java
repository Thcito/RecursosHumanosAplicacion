package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.TrabajadorDAO;
import entidades.Trabajador;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListadoTrabajadores extends JFrame {

	// Colocamos el Arraylist a nivel de clase para tener acceso desde todos los
	// componentes de clase(eliminar)
	ArrayList<Trabajador> trabajadores = null;

	private JPanel contentPane;
	private JTable tblTrabajadores;
	private JTextField txtDni;
	private JButton btnBuscar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoTrabajadores frame = new ListadoTrabajadores();	
					//frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public ListadoTrabajadores() {
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		txtDni = new JTextField();
		txtDni.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				listar();
			}

			private void listar() {

				TrabajadorDAO tDAO = new TrabajadorDAO();

				try {

					if (txtDni.getText().isEmpty()) {

						trabajadores = tDAO.listaTrabajadores();
					} else {
						trabajadores = tDAO.buscarPorDni(txtDni.getText());

						if (trabajadores.size() == 0) {
							JOptionPane.showMessageDialog(btnBuscar, "Dni no válido");
						}
					}

					// MODELO DE TABLA PARA PASAR LOS TRABAJADORES A LA TABLA.

					// COLUMNAS QUE SE RELLENARAN AUTOMATICAMENTE
					DefaultTableModel modelo = new DefaultTableModel();
					modelo.addColumn("DNI");
					modelo.addColumn("NOMBRE");
					modelo.addColumn("APELLIDO");
					modelo.addColumn("EDAD");
					modelo.addColumn("CARGO");
					modelo.addColumn("SEXO");
					modelo.addColumn("¿ES EXTRANJERO?");

					// PARA LAS FILAS HAY QUE MONTAR UN ARRAY DE STRING(SON FINITOS(7))

					for (Trabajador i : trabajadores) {

						String[] fila = new String[7];

						fila[0] = i.getDni();
						fila[1] = i.getNombre();
						fila[2] = i.getApellido();
						// Para convertir al tipo valido (String) se usa el metodo ValueOf.
						fila[3] = String.valueOf(i.getEdad());
						fila[4] = i.getCargo();
						// Para poder mostrar opciones validas al usuario y no true o false, montamos
						// una condicion if.
						if (i.isSexo()) {
							fila[5] = "Masculino"; // Si es true
						} else {
							fila[6] = "Femenino"; // Si es false
						}

						if (i.isExtranjero()) {
							fila[6] = "Si";
						} else {
							fila[6] = "No";
						}
						// CUANDO SE GENERE GUARDAMOS ESTE STRING DENTRO DEL MODELO.
						modelo.addRow(fila);

					}
					// PASAMOS EL MODELO DE DATOS A LA TABLA.
					tblTrabajadores.setModel(modelo);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// OBTENEMOS DEL ARRAYLIST EL TRABAJADOR MEDIANTE SU INDICE

				int indice = tblTrabajadores.getSelectedRow();
				Trabajador trabajador = trabajadores.get(indice);

				TrabajadorDAO tDAO = new TrabajadorDAO();

				try {
					if (tDAO.eliminarTrabajador(trabajador.getDni())) {
						JOptionPane.showMessageDialog(btnEliminar, "Eliminado correctamente");
					} else {
						JOptionPane.showMessageDialog(btnEliminar, "No se ha podido eliminar");

					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				listar();
			}

			private void listar() {

				TrabajadorDAO tDAO = new TrabajadorDAO();

				try {

					if (txtDni.getText().isEmpty()) {

						trabajadores = tDAO.listaTrabajadores();
					} else {
						trabajadores = tDAO.buscarPorDni(txtDni.getText());

						if (trabajadores.size() == 0) {
							JOptionPane.showMessageDialog(btnBuscar, "Dni no válido");
						}
					}

					// MODELO DE TABLA PARA PASAR LOS TRABAJADORES A LA TABLA.

					// COLUMNAS QUE SE RELLENARAN AUTOMATICAMENTE
					DefaultTableModel modelo = new DefaultTableModel();
					modelo.addColumn("DNI");
					modelo.addColumn("NOMBRE");
					modelo.addColumn("APELLIDO");
					modelo.addColumn("EDAD");
					modelo.addColumn("CARGO");
					modelo.addColumn("SEXO");
					modelo.addColumn("¿ES EXTRANJERO?");

					// PARA LAS FILAS HAY QUE MONTAR UN ARRAY DE STRING(SON FINITOS(7))

					for (Trabajador i : trabajadores) {

						String[] fila = new String[7];

						fila[0] = i.getDni();
						fila[1] = i.getNombre();
						fila[2] = i.getApellido();
						// Para convertir al tipo valido (String) se usa el metodo ValueOf.
						fila[3] = String.valueOf(i.getEdad());
						fila[4] = i.getCargo();
						// Para poder mostrar opciones validas al usuario y no true o false, montamos
						// una condicion if.
						if (i.isSexo()) {
							fila[5] = "Masculino"; // Si es true
						} else {
							fila[6] = "Femenino"; // Si es false
						}

						if (i.isExtranjero()) {
							fila[6] = "Si";
						} else {
							fila[6] = "No";
						}
						// CUANDO SE GENERE GUARDAMOS ESTE STRING DENTRO DEL MODELO.
						modelo.addRow(fila);

					}
					// PASAMOS EL MODELO DE DATOS A LA TABLA.
					tblTrabajadores.setModel(modelo);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(522, Short.MAX_VALUE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnBuscar).addGap(33))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(btnEliminar)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(23, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(15)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGap(26).addComponent(btnEliminar).addContainerGap(44, Short.MAX_VALUE)));

		tblTrabajadores = new JTable();
		tblTrabajadores.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "DNI", "NOMBRE", "APELLIDO", "EDAD", "CARGO", "SEXO", "\u00BFES EXTRANJERO?" }));
		scrollPane.setViewportView(tblTrabajadores);
		contentPane.setLayout(gl_contentPane);
	}
	
}
