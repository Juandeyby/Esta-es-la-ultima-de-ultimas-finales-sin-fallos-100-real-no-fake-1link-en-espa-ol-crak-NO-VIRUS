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

public class GenerarCuenta {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarCuenta window = new GenerarCuenta();
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
	public GenerarCuenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 250);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Generar Cuenta");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Cuenta Jefe de Proceso", TitledBorder.LEFT, TitledBorder.TOP));
		panel.setBounds(12, 12, 456, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelFoto = new JLabel("New label");
		labelFoto.setBounds(26, 25, 91, 109);
		panel.add(labelFoto);
		
		ImageIcon fot = new ImageIcon("./Imagenes/administrador.png");
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
		labelFoto.setIcon(icono);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(129, 40, 167, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(129, 70, 167, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tiempo de Activación                                 Días");
		lblNewLabel_2.setBounds(129, 100, 327, 15);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(300, 30, 100, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 60, 100, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(77, 1, 33));
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("30");
		comboBox.addItem("60");
		comboBox.addItem("120");
		
		comboBox.setBounds(300, 100, 100, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Generar Cuenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					return;
				} else if (textField_1.getText().equals("")) {
					return;
				} else {
					int dias = Integer.parseInt(comboBox.getSelectedItem().toString());
					Date date = new Date();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					calendar.add(Calendar.DAY_OF_MONTH, dias);
					
					date = calendar.getTime();
					Usuario usuario = new Usuario(0, textField.getText(),
							textField_1.getText(), null, null,
							date.getYear(), date.getMonth(), date.getDate(), 2);
					Conexion conn = new Conexion();
					conn.insertarUsuario(usuario);
				}
				frame.dispose();
			}
		});
		btnNewButton.setBounds(165, 179, 150, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
