package Interfaces;

import java.awt.Image;

import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Controladores.Actualizar;

import java.awt.Color;
import javax.swing.JPasswordField;

public class PerfilAdministradorGeneral {

	public JFrame frame;
	private TextField passwordField_2;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private TextField  passwordField_4;

	public PerfilAdministradorGeneral() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 250);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 249, 173));
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Perfil Administrador General", TitledBorder.LEFT, TitledBorder.TOP));
		panel.setBounds(12, 12, 454, 179);
		frame.getContentPane().add(panel);
		frame.setTitle("Perfil Administrador General");
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Contraseña Actual");
		lblUsuario.setBounds(110, 34, 139, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña Nueva");
		lblContrasea.setBounds(110, 62, 131, 14);
		panel.add(lblContrasea);
		
		JLabel lblPreguntaSecreta = new JLabel("Pregunta Secreta");
		lblPreguntaSecreta.setBounds(110, 118, 149, 14);
		panel.add(lblPreguntaSecreta);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(15, 40, 85, 111);
		panel.add(lblNewLabel);
		
		
		ImageIcon fot = new ImageIcon("./Imagenes/mira.png");
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(429, 35, 20, 17);
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(icono);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(429, 87, 20, 17);
		ImageIcon icono2 = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_2.setIcon(icono2);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Actualizar ac=new Actualizar( passwordField_3.getText(),passwordField.getText(),passwordField_1.getText(),passwordField_2.getText(),passwordField_4.getText());
					if(ac.estado==-2){
						lblNewLabel_1.setVisible(true);
						lblNewLabel_2.setVisible(false);
						JOptionPane.showMessageDialog(null, "contraseña actual mal escrita");
					}
					else{
						if(ac.estado==1){
							JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
							frame.setVisible(false);
						}
						else{
							if(passwordField_4.getText().equals("") || passwordField_2.getText().equals("") || ac.estado==5){
								lblNewLabel_1.setVisible(false);
								lblNewLabel_2.setVisible(false);
								JOptionPane.showMessageDialog(null, "Llene todos los campos");}
							else{
								lblNewLabel_2.setVisible(true);
								lblNewLabel_1.setVisible(false);
								JOptionPane.showMessageDialog(null, "Contraseñas no coinsiden");

							}
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(77, 1, 33));
		btnNewButton.setBounds(250, 205, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		ImageIcon persona = new ImageIcon("./Imagenes/docente.png");
        ImageIcon icono1 = new ImageIcon(persona.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(icono1);
        
        JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
        lblConfirmarContrasea.setBounds(110, 90, 168, 14);
        panel.add(lblConfirmarContrasea);
        
        passwordField_2 = new TextField();
        passwordField_2.setBounds(279, 116, 149, 20);
        panel.add(passwordField_2);
        
        JLabel lblRespuesta = new JLabel("Respuesta");
        lblRespuesta.setBounds(110, 146, 149, 14);
        panel.add(lblRespuesta);
        
        passwordField_3 = new JPasswordField();
        passwordField_3.setBounds(279, 34, 149, 19);
        panel.add(passwordField_3);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(279, 60, 149, 19);
        panel.add(passwordField);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(279, 89, 149, 19);
        panel.add(passwordField_1);
        
        passwordField_4 = new TextField();
        passwordField_4.setBounds(279, 145, 149, 20);
        panel.add(passwordField_4);
        
        JButton btnCambiarPreguntaSecreta = new JButton("Cancelar");
        btnCambiarPreguntaSecreta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        btnCambiarPreguntaSecreta.setForeground(Color.WHITE);
        btnCambiarPreguntaSecreta.setBackground(new Color(77, 1, 33));
        btnCambiarPreguntaSecreta.setBounds(130, 205, 100, 25);
        frame.getContentPane().add(btnCambiarPreguntaSecreta);
	}
}
