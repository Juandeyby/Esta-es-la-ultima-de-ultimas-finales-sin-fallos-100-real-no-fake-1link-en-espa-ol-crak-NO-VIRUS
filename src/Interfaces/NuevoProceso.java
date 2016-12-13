package Interfaces;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Clases.Usuario;
import Controladores.Conexion;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NuevoProceso{

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoProceso window = new NuevoProceso();
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
	NuevoProceso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 441, 235);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Nuevo Proceso");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 401, 134);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelFoto = new JLabel("");
		labelFoto.setBounds(35, 22, 91, 86);
		panel.add(labelFoto);
		
				
		ImageIcon fot = new ImageIcon("./Imagenes/signo.png");
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
		labelFoto.setIcon(icono);
		
		JLabel lbldesaEmpezarNuevo = new JLabel("\u00BFDesea empezar nuevo proceso?");
		lbldesaEmpezarNuevo.setBounds(138, 62, 237, 15);
		panel.add(lbldesaEmpezarNuevo);
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(85, 158, 122, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion con=new Conexion();
			   boolean a=con.eliminar();
			   frame.dispose();
			}
		});
		
		
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnCancelar.setBounds(239, 158, 122, 30);
		frame.getContentPane().add(btnCancelar);
	}
}