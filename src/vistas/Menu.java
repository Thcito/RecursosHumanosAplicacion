package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTrabajador = new JMenu(Messages.getString("Menu.mnTrabajador.text")); //$NON-NLS-1$
		menuBar.add(mnTrabajador);

		JMenuItem mntmListar = new JMenuItem(Messages.getString("Menu.mntmListar.text")); //$NON-NLS-1$
		mntmListar.setText(Messages.getString("Menu.mntmListar.text")); //$NON-NLS-1$

		mntmListar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ListadoTrabajadores listar = new ListadoTrabajadores();
				listar.setVisible(true);

			}
		});
		mnTrabajador.add(mntmListar);

		JMenuItem mntmAgregar = new JMenuItem(Messages.getString("Menu.mntmAgregar.text")); //$NON-NLS-1$
		mntmAgregar.setText(Messages.getString("Menu.mntmAgregar.text")); //$NON-NLS-1$

		mntmAgregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				NuevoTrabajador agregar = new NuevoTrabajador();
				agregar.setVisible(true);
			}
		});

		mnTrabajador.add(mntmAgregar);

		JMenu mnIdiomas = new JMenu(Messages.getString("Menu.mnIdiomas.text")); //$NON-NLS-1$
		menuBar.add(mnIdiomas);

		JMenuItem mntmEspa�ol = new JMenuItem(Messages.getString("Menu.mntmEspa�ol.text")); //$NON-NLS-1$
		mntmEspa�ol.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ResourceBundle resource = ResourceBundle.getBundle("vistas/messages");
				mnTrabajador.setText(resource.getString("Menu.mnTrabajador.text"));
				mnIdiomas.setText(resource.getString("Menu.mnIdiomas.text"));
				//mntmIngles.setText(resource.getString("Menu.mntmIngles.text"));
				mntmEspa�ol.setText(resource.getString("Menu.mntmEspa�ol.text"));
				mntmListar.setText(resource.getString("Menu.mntmListar.text"));
				mntmAgregar.setText(resource.getString("Menu.mntmAgregar.text"));

			}
		});
		mntmEspa�ol.setText(Messages.getString("Menu.mntmEspa�ol.text")); //$NON-NLS-1$
		mnIdiomas.add(mntmEspa�ol);

		JMenuItem mntmIngles = new JMenuItem(Messages.getString("Menu.mntmIngles.text")); //$NON-NLS-1$
		mntmIngles.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ResourceBundle resource = ResourceBundle.getBundle("vistas/messages_en_Us");
				// Locale ingles = new Locale("en","EN");
				mnTrabajador.setText(resource.getString("Menu.mnTrabajador.text"));
				mnIdiomas.setText(resource.getString("Menu.mnIdiomas.text"));
				mntmIngles.setText(resource.getString("Menu.mntmIngles.text"));
				mntmEspa�ol.setText(resource.getString("Menu.mntmEspa�ol.text"));
				mntmListar.setText(resource.getString("Menu.mntmListar.text"));
				mntmAgregar.setText(resource.getString("Menu.mntmAgregar.text"));
				
				

			}
		});
		mntmIngles.setText(Messages.getString("Menu.mntmIngles.text")); //$NON-NLS-1$
		mnIdiomas.add(mntmIngles);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

}
