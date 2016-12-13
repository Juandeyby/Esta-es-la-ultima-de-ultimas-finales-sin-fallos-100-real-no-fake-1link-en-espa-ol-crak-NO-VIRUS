package Interfaces;

import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import java.awt.Color;

public class JefeProceso {

	public JFrame frame;
	private JTextField textField;
	private JTextField txtContraseaGeneradaAutomaticamente;
	
	public JefeProceso() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(470, 344));
		frame.setBounds(new Rectangle(0, 0, 480, 320));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 480, 320));
		frame.getContentPane().setSize(new Dimension(480, 480));
		frame.setBounds(100, 100, 530, 320);
		frame.setTitle("Crear Cuenta - Jefe Proceso");
		frame.setResizable(false);
	
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon fot = new ImageIcon("./Imagenes/administrador.png");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Seleccionar Proceso", TitledBorder.LEFT, TitledBorder.TOP));
		panel.setBounds(12, 12, 504, 192);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setBounds(25, 33, 100, 120);
		panel.add(lblNewLabel2);
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel2.getWidth(), lblNewLabel2.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel2.setIcon(icono);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(142, 33, 70, 15);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(142, 83, 109, 15);
		panel.add(lblContrasea);
		
		JLabel lblTiempoDeActivacion = new JLabel("Tiempo de activacion");
		lblTiempoDeActivacion.setBounds(143, 123, 156, 37);
		panel.add(lblTiempoDeActivacion);
		
		textField = new JTextField();
		textField.setBounds(325, 31, 156, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		txtContraseaGeneradaAutomaticamente = new JTextField();
		txtContraseaGeneradaAutomaticamente.setText("(contraseña generada)");
		txtContraseaGeneradaAutomaticamente.setColumns(10);
		txtContraseaGeneradaAutomaticamente.setEditable(false);
		txtContraseaGeneradaAutomaticamente.setBounds(325, 81, 156, 19);
		panel.add(txtContraseaGeneradaAutomaticamente);
		
		String[] intervalo={"10 días","20 días","30 días"};
		JComboBox comboBox = new JComboBox(intervalo);
		comboBox.setBounds(325, 129, 156, 24);
		panel.add(comboBox);
		
		JButton btnGenerarCuenta = new JButton("Generar Cuenta");
		btnGenerarCuenta.setBounds(195, 227, 161, 25);
		frame.getContentPane().add(btnGenerarCuenta);
	}
}
