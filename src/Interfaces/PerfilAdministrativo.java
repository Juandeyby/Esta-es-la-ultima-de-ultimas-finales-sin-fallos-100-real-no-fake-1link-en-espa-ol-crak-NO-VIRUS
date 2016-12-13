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

import Clases.ParticipanteOut;
import Controladores.Actualizar;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.EventQueue;

public class PerfilAdministrativo {

	public JFrame frame;

	public void initialize(ParticipanteOut participante) {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 547);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 249, 173));
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Perfil Administrativo", TitledBorder.LEFT, TitledBorder.TOP));
		panel.setBounds(12, 12, 454, 297);
		frame.getContentPane().add(panel);
		frame.setTitle("Perfil Administrativo");
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("DNI");
		lblUsuario.setBounds(110, 34, 68, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Nombres");
		lblContrasea.setBounds(110, 62, 57, 14);
		panel.add(lblContrasea);
		
		JLabel lblPreguntaSecreta = new JLabel("Telefono");
		lblPreguntaSecreta.setBounds(110, 118, 68, 14);
		panel.add(lblPreguntaSecreta);
		
		JLabel lblNewLabel = new JLabel("Imagen Administrativo");
		lblNewLabel.setBounds(15, 40, 85, 111);
		panel.add(lblNewLabel);
				
		ImageIcon persona = new ImageIcon("./Imagenes/docente.png");
        ImageIcon icono1 = new ImageIcon(persona.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(icono1);
        
        JLabel lblConfirmarContrasea = new JLabel("Apellidos");
        lblConfirmarContrasea.setBounds(110, 90, 74, 14);
        panel.add(lblConfirmarContrasea);
        
        JLabel lblRespuesta = new JLabel("Telefono de Oficina");
        lblRespuesta.setBounds(110, 146, 128, 14);
        panel.add(lblRespuesta);
        
        JLabel lblCelular = new JLabel("Celular");
        lblCelular.setBounds(110, 171, 45, 14);
        panel.add(lblCelular);
        
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(110, 196, 45, 14);
        panel.add(lblCorreo);
        
        JLabel lblCorreoInstitucional = new JLabel("Correo Institucional");
        lblCorreoInstitucional.setBounds(110, 221, 128, 14);
        panel.add(lblCorreoInstitucional);
        
        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setBounds(110, 246, 57, 14);
        panel.add(lblDireccion);
        
        JLabel lblFacultad = new JLabel("Funci\u00F3n");
        lblFacultad.setBounds(110, 271, 57, 14);
        panel.add(lblFacultad);
        
        JLabel lblNewLabel_1 = new JLabel(participante.getDni_participante());
        lblNewLabel_1.setBounds(234, 34, 181, 14);
        panel.add(lblNewLabel_1);
        
        JLabel label_1 = new JLabel(participante.getNombre_participante());
        label_1.setBounds(234, 62, 181, 14);
        panel.add(label_1);
        
        JLabel label_2 = new JLabel(participante.getApellido_participante());
        label_2.setBounds(234, 88, 181, 14);
        panel.add(label_2);
        
        JLabel label_3 = new JLabel(participante.getTelefono_participante());
        label_3.setBounds(234, 118, 181, 14);
        panel.add(label_3);
        
        JLabel label_4 = new JLabel(participante.getTelefono_oficina_participante() + "");
        label_4.setBounds(234, 146, 181, 14);
        panel.add(label_4);
        
        JLabel label_5 = new JLabel(participante.getCelular_participante() + "");
        label_5.setBounds(234, 171, 181, 14);
        panel.add(label_5);
        
        JLabel label_6 = new JLabel(participante.getCorreo_participante());
        label_6.setBounds(234, 196, 181, 14);
        panel.add(label_6);
        
        JLabel label_7 = new JLabel(participante.getCorreo_institucional_participante());
        label_7.setBounds(234, 221, 181, 14);
        panel.add(label_7);
        
        JLabel label_8 = new JLabel(participante.getDireccion_participante());
        label_8.setBounds(234, 246, 181, 14);
        panel.add(label_8);
        
        JLabel label_9 = new JLabel(participante.getId_funcion());
        label_9.setBounds(234, 271, 181, 14);
        panel.add(label_9);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(BorderFactory.createTitledBorder(

        				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),

        				"Historial", TitledBorder.LEFT, TitledBorder.TOP));
        panel_1.setBackground(new Color(255, 249, 173));
        panel_1.setBounds(12, 320, 454, 193);
        frame.getContentPane().add(panel_1);
        
        JScrollPane scrollPane = new JScrollPane((Component) null);
        scrollPane.setBounds(10, 21, 245, 156);
        panel_1.add(scrollPane);
        
        JLabel label = new JLabel("Grafico");
        label.setBounds(301, 23, 100, 100);
        panel_1.add(label);
        
        ImageIcon grafico = new ImageIcon("./Imagenes/grafico.png");
        ImageIcon icono2 = new ImageIcon(grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono2);
        
        JButton button = new JButton("Ver Grafico");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.setBounds(286, 134, 135, 23);
        panel_1.add(button);
	}
}
