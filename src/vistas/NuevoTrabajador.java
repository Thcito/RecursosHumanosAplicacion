package vistas;

import java.awt.BorderLayout;
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

public class NuevoTrabajador extends JFrame {

	private JPanel contentPane;
	private JTextField txtRut;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoTrabajador frame = new NuevoTrabajador();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		lblEdad.setBounds(10, 104, 60, 20);
		contentPane.add(lblEdad);
		
		txtRut = new JTextField();
		txtRut.setBounds(92, 11, 100, 20);
		contentPane.add(txtRut);
		txtRut.setColumns(10);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(92, 42, 100, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(92, 73, 100, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JSpinner spnEdad = new JSpinner();
		spnEdad.setBounds(92, 104, 100, 20);
		contentPane.add(spnEdad);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 135, 60, 20);
		contentPane.add(lblCargo);
		
		JComboBox cboCargo = new JComboBox();
		cboCargo.setModel(new DefaultComboBoxModel(new String[] {"Gerente", "Asistente", "Vendedor"}));
		cboCargo.setBounds(92, 135, 100, 22);
		contentPane.add(cboCargo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 166, 60, 20);
		contentPane.add(lblSexo);
		
		JRadioButton rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setSelected(true);
		rbtMasculino.setBounds(83, 165, 109, 23);
		contentPane.add(rbtMasculino);
		
		JRadioButton rbtFemenino = new JRadioButton("Femenino");
		rbtFemenino.setBounds(201, 165, 109, 23);
		contentPane.add(rbtFemenino);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtMasculino);
		group.add(rbtFemenino);
		
		JCheckBox chkEsExtranjero = new JCheckBox("\u00BFEs extranjero?");
		chkEsExtranjero.setBounds(6, 193, 116, 23);
		contentPane.add(chkEsExtranjero);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Los datos del formularios se guardaron correctamente");
			}
		});
		btnGuardar.setBounds(320, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(212, 227, 89, 23);
		contentPane.add(btnLimpiar);
	}
}