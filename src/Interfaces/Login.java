package Interfaces;

import java.awt.Color;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Usuario;
import Controladores.Conexion;
import Controladores.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 

public class Login {

	public JFrame frmExaminV;

	public Login() {
		initialize();
	}

	private void initialize() {
		frmExaminV = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frmExaminV.setIconImage(img.getImage());
		frmExaminV.setTitle("Examin v2.0");
		frmExaminV.setSize(480, 320);
		frmExaminV.getContentPane().setBackground(new Color(77, 1, 33));
		frmExaminV.getContentPane().setLayout(null);
		frmExaminV.setResizable(false);
		
		JTextField UsuariotextField;
		UsuariotextField = new JTextField();
		UsuariotextField.setBounds(240, 158, 160, 23);
		frmExaminV.getContentPane().add(UsuariotextField);
		UsuariotextField.setColumns(10);
		
		JPasswordField UsuariopasswordField = new JPasswordField();
		UsuariopasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Conexion conn = new Conexion();
					Usuario usuario = conn.consulta(UsuariotextField.getText());
					if (usuario != null) {
						if (UsuariotextField.getText().equals("admin")) {
							if (usuario.getContrasenia_usuario().equals(UsuariopasswordField.getText())) {
								SesionAdministrador sesionadministrador = new SesionAdministrador();
								sesionadministrador.frame.setVisible(true);
								Main.centralizar(sesionadministrador.frame);
								frmExaminV.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
							}
						} else {
							if (usuario.getContrasenia_usuario().equals(UsuariopasswordField.getText())) {
								SesionJefeProceso sesionjefeproceso = new SesionJefeProceso();
								sesionjefeproceso.frame.setVisible(true);
								Main.centralizar(sesionjefeproceso.frame);
								frmExaminV.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "No Existe Usuario");
					}
				}
			}
		});
		UsuariopasswordField.setBounds(240, 193, 160, 23);
		frmExaminV.getContentPane().add(UsuariopasswordField);
		
		JButton Ingresar = new JButton("INGRESAR");
		Ingresar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Conexion conn = new Conexion();
				Usuario usuario = conn.consulta(UsuariotextField.getText());
				if (usuario != null) {
					if (UsuariotextField.getText().equals("admin")) {
						if (usuario.getContrasenia_usuario().equals(UsuariopasswordField.getText())) {
							SesionAdministrador sesionadministrador = new SesionAdministrador();
							sesionadministrador.frame.setVisible(true);
							Main.centralizar(sesionadministrador.frame);
							frmExaminV.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
						}
					} else {
						if (usuario.getContrasenia_usuario().equals(UsuariopasswordField.getText())) {
							SesionJefeProceso sesionjefeproceso = new SesionJefeProceso();
							sesionjefeproceso.frame.setVisible(true);
							Main.centralizar(sesionjefeproceso.frame);
							frmExaminV.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Existe Usuario");
				}
			}
		});
		Ingresar.setBorder(null);
		Ingresar.setForeground(Color.BLACK);
        Ingresar.setBackground(Color.WHITE);
		Ingresar.setBounds(168, 267, 136, 23);
		frmExaminV.getContentPane().add(Ingresar);
		
		JLabel lblInicieSesinPara = new JLabel("INICIAR SESIÓN PARA ACCEDER", SwingConstants.CENTER);
		lblInicieSesinPara.setForeground(Color.WHITE);
		lblInicieSesinPara.setBounds(12, 120, 456, 14);
		frmExaminV.getContentPane().add(lblInicieSesinPara);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(80, 160, 105, 19);
		frmExaminV.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña :");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(80, 198, 105, 19);
		frmExaminV.getContentPane().add(lblContrasea);
		
		JLabel lblNewLabel_esc = new JLabel("ESCUDO");
		lblNewLabel_esc.setBounds(90, 5, 300, 110);
		frmExaminV.getContentPane().add(lblNewLabel_esc);
		frmExaminV.setBounds(100, 100, 480, 320);
		frmExaminV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon escudo = new ImageIcon("./Imagenes/logo1.png");
        ImageIcon icono1 = new ImageIcon(escudo.getImage().getScaledInstance(lblNewLabel_esc.getWidth(), lblNewLabel_esc.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel_esc.setIcon(icono1);
        
        JButton btnolvidastesTuContrasea = new JButton("¿Olvidastes tu contraseña?");
        btnolvidastesTuContrasea.setFont(new Font("Dialog", Font.BOLD, 10));
        btnolvidastesTuContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recuperar recuperar = new Recuperar();
				Main.centralizar(recuperar.frame);
				recuperar.frame.setVisible(true);
			}
		});
        btnolvidastesTuContrasea.setBorder(null);
        btnolvidastesTuContrasea.setForeground(Color.ORANGE);
        btnolvidastesTuContrasea.setBackground(new Color(77, 1, 33));
        btnolvidastesTuContrasea.setBounds(240, 220, 160, 23);
        frmExaminV.getContentPane().add(btnolvidastesTuContrasea);
    }
}