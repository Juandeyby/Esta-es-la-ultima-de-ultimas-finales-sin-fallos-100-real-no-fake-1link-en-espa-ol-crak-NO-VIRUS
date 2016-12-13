package Interfaces;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Clases.Usuario;
import Controladores.Conexion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Recuperar {
	
	JFrame frame;
	
	private JPanel panel;
	private JLabel lblpreg;
	private JTextField text_respuesta;
	private JButton btnRecuperar;
	private JLabel lblNewContraseña;
	private JLabel lblmns;
	private JTextField txtQwe;
	private JButton btnAceptar;
	private Conexion conn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recuperar frame = new Recuperar();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Recuperar() {
		initialize();
	}


	/**
	 * Create the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setSize(new Dimension(470, 344));
		frame.setBounds(new Rectangle(0, 0, 480, 320));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 480, 320));
		frame.getContentPane().setSize(new Dimension(480, 480));
		frame.setBounds(100, 100, 530, 320);
		frame.setTitle("Recuperar Contraseña");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(33, 23, 460, 153);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Recuperar Contraseña", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel);
		panel.setToolTipText("");
		panel.setLayout(null);
		
		conn = new Conexion();
		Usuario usuario = conn.consulta("admin");
		
		JLabel lblpregunta = new JLabel("Pregunta de seguridad :");
		lblpregunta.setBounds(36, 30, 184, 15);
		panel.add(lblpregunta);
		
		JLabel lblRespuestaSecreta = new JLabel("Respuesta secreta");
		lblRespuestaSecreta.setBounds(36, 88, 134, 15);
		panel.add(lblRespuestaSecreta);
		
		lblpreg = new JLabel(usuario.getPregunta_secreta_usuario());
		lblpreg.setBounds(36, 57, 237, 15);
		panel.add(lblpreg);
		
		text_respuesta = new JTextField();
		text_respuesta.setColumns(10);
		text_respuesta.setBounds(36, 115, 372, 19);
		text_respuesta.setEditable(true);
		text_respuesta.setEnabled(true);
		panel.add(text_respuesta);
		
		lblNewContraseña = new JLabel("Nueva Contraseña Generada");
		lblNewContraseña.setBounds(82, 227, 211, 15);
		lblNewContraseña.setVisible(false);
		frame.getContentPane().add(lblNewContraseña);
		
		btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_respuesta.getText().equals(usuario.getRespuesta_pregunta_secreta_usuario())) {
					text_respuesta.setEditable(false);
					text_respuesta.setEnabled(false);
					btnRecuperar.setVisible(false);
					lblNewContraseña.setVisible(true);
					lblmns.setVisible(true);
					txtQwe.setVisible(true);
					btnAceptar.setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
			}
		});
		btnRecuperar.setBounds(293, 188, 132, 25);
		frame.getContentPane().add(btnRecuperar);
		
		lblmns = new JLabel("( Recuerde modificar sus contraseña en su perfil )");
		lblmns.setBounds(66, 252, 359, 15);
		lblmns.setVisible(false);
		frame.getContentPane().add(lblmns);
		
		String cadena = getCadenaAlfanumAleatoria(8);
		txtQwe = new JTextField();
		txtQwe.setText(cadena);
		txtQwe.setBounds(319, 225, 71, 19);
		frame.getContentPane().add(txtQwe);
		txtQwe.setColumns(10);
		txtQwe.setEditable(false);
		txtQwe.setVisible(false);
		
		btnAceptar = new JButton("Guardar");
		btnAceptar.setVisible(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(conn.cambioContraseniaAdministrador(txtQwe.getText()));
				System.out.println(txtQwe.getText());
				JOptionPane.showMessageDialog(null, "Nueva Contraseña :" + txtQwe.getText());
				frame.dispose();
			}
		});
		btnAceptar.setBounds(113, 188, 117, 25);
		frame.getContentPane().add(btnAceptar);
					
	}
	
	public String getCadenaAlfanumAleatoria (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
			char c = (char)r.nextInt(255);
			if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
				cadenaAleatoria += c;
				i ++;
			}
		}
		return cadenaAleatoria;
	}
}