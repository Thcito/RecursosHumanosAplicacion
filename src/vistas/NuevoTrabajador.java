package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import para poder trabajar con las otras clases.
import entidades.Trabajador; //Para llamar al trabajador
import dao.TrabajadorDAO;
import javax.swing.SpinnerNumberModel; //Para llamar un DAO.

@SuppressWarnings("serial")
public class NuevoTrabajador extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoTrabajador frame = new NuevoTrabajador();
					// frame.setExtendedState(MAXIMIZED_BOTH);
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
	public NuevoTrabajador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 11, 60, 20);
		contentPane.add(lblDni);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 42, 60, 20);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 73, 60, 20);
		contentPane.add(lblApellido);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 190, 60, 20);
		contentPane.add(lblEdad);

		txtDni = new JTextField();
		txtDni.setBounds(92, 11, 100, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(92, 42, 100, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(92, 73, 100, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(92, 104, 100, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(92, 135, 100, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(92, 163, 100, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 110, 60, 20);
		contentPane.add(lblDireccion);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 138, 60, 20);
		contentPane.add(lblEmail);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 163, 60, 20);
		contentPane.add(lblTelefono);
		
		JSpinner spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 65, 1));
		spnEdad.setBounds(92, 190, 100, 20);
		contentPane.add(spnEdad);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 236, 60, 20);
		contentPane.add(lblCargo);

		JComboBox cboCargo = new JComboBox();
		cboCargo.setModel(new DefaultComboBoxModel(new String[] { "Gerente", "Asistente", "Vendedor" }));
		cboCargo.setBounds(92, 235, 100, 22);
		contentPane.add(cboCargo);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 283, 60, 20);
		contentPane.add(lblSexo);

		JRadioButton rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setSelected(true);
		rbtMasculino.setBounds(83, 282, 109, 23);
		contentPane.add(rbtMasculino);

		JRadioButton rbtFemenino = new JRadioButton("Femenino");
		rbtFemenino.setBounds(194, 282, 109, 23);
		contentPane.add(rbtFemenino);

		// Creación de BottonGroup para evitar seleccion multiple
		ButtonGroup group = new ButtonGroup();
		group.add(rbtMasculino);
		group.add(rbtFemenino);

		JCheckBox chkEsExtranjero = new JCheckBox("\u00BFEs extranjero?");
		chkEsExtranjero.setBounds(10, 331, 116, 23);
		contentPane.add(chkEsExtranjero);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			// Metodo que ejecutara el codigo una vez pulsemos el boton

			public void actionPerformed(ActionEvent e) {

				try {
					Trabajador t = new Trabajador();

					t.setDni(txtDni.getText());
					t.setNombre(txtNombre.getText());
					t.setApellido(txtApellido.getText());
					t.setDireccion(txtDireccion.getText());
					t.setEmail(txtEmail.getText());
					
					t.setTelefono(Float.parseFloat(txtTelefono.getText())); 
					
					t.setEdad(Integer.parseInt(spnEdad.getValue().toString()));
					t.setCargo(cboCargo.getSelectedItem().toString());
					// Si masculino esta seleccionado sera true, si no sera false y sera femenino.
					t.setSexo(rbtMasculino.isSelected());
					t.setExtranjero(chkEsExtranjero.isSelected());

					// Clase TrabajadorDAO agrega trabajador sacando los campos. Lo convierte en
					// sentencia
					// SQL y la ejecuta y nos dice si es correcta o no mediante la condicion de
					// filas afectadas.
					TrabajadorDAO tDAO = new TrabajadorDAO();

					if (tDAO.agregarTrabajador(t)) {
						JOptionPane.showMessageDialog(btnGuardar, "Guardado correctamente");
						limpiar();

					} else {

						JOptionPane.showMessageDialog(btnGuardar, "A ocurrido un error");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnGuardar, e1.getMessage());
				}
			}

			private void limpiar() {

				txtDni.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtDireccion.setText("");
				txtEmail.setText("");
				txtTelefono.setText("");
				spnEdad.setValue(0);
				cboCargo.setSelectedIndex(-1);
				rbtMasculino.setSelected(false);
				chkEsExtranjero.setSelected(false);

			}

		});
		btnGuardar.setBounds(337, 352, 89, 23);
		contentPane.add(btnGuardar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpiar();
			}

			private void limpiar() {

				txtDni.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtDireccion.setText("");
				txtEmail.setText("");
				txtTelefono.setText("");
				spnEdad.setValue(-1);
				cboCargo.setSelectedIndex(0);
				rbtMasculino.setSelected(false);
				chkEsExtranjero.setSelected(false);

			}

		});
		btnLimpiar.setBounds(238, 352, 89, 23);
		contentPane.add(btnLimpiar);

		
	}
}
