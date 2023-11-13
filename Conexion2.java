import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton.setBounds(316, 201, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion cn = new Conexion();
				cn.obtenerConexion();
			}
		});
		btnConectar.setBounds(10, 37, 89, 23);
		frame.getContentPane().add(btnConectar);
		
		JButton btnConectareInsertarProfesor = new JButton("Conectare insertar Profesor");
		btnConectareInsertarProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion cn = new Conexion();
				cn.insertarProfesor("1", null, null);
				
			}
		});
		btnConectareInsertarProfesor.setBounds(10, 76, 167, 23);
		frame.getContentPane().add(btnConectareInsertarProfesor);
	}
}
