package Interfaces;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Clases.ParticipanteBuscar;
import Clases.ParticipanteOut;
import Controladores.Conexion;
import Controladores.Main;

public class SesionJefeProceso {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textFieldTecnicos;
	private JTextField textField_6;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	public static void main(String[] args) {
		SesionJefeProceso sesionjefe = new SesionJefeProceso();
		sesionjefe.frame.setVisible(true);
	}

	public SesionJefeProceso() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frame.setIconImage(img.getImage());
		frame.setBounds(100, 100, 800, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Seccion Jefe De Proceso");
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Perfil");
		menuBar.add(mnNewMenu);
			
		JMenuItem mntmFinalizarProceso = new JMenuItem("Cerrar Sesión");
		mntmFinalizarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.frmExaminV.setVisible(true);
				Main.centralizar(login.frmExaminV);
			}
		});
		
		mnNewMenu.add(mntmFinalizarProceso);
		
		JMenu mnAyuda = new JMenu("Proceso");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerManual = new JMenuItem("Nuevo Proceso");
		mntmVerManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoProceso nuevo = new NuevoProceso();
				nuevo.frame.setVisible(true);
				Main.centralizar(nuevo.frame);
			}
		});
		mnAyuda.add(mntmVerManual);
		
		JMenu mnAcercaDe = new JMenu("Buscar");
		menuBar.add(mnAcercaDe);
		
		
		JMenuItem mntmInformacinDelSoftware = new JMenuItem("Buscar Participante");
		mntmInformacinDelSoftware.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acerca acerca = new Acerca();
				acerca.frame.setVisible(true);
				Main.centralizar(acerca.frame);
			}
		});
		mnAcercaDe.add(mntmInformacinDelSoftware);
		
		JMenu mnA = new JMenu("Ayuda");
		menuBar.add(mnA);
		
		JMenuItem mntmVerManual_1 = new JMenuItem("Ver manual");
		mntmVerManual_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Desktop desktop = Desktop.getDesktop();
					desktop.open(new java.io.File("prueba.pdf"));
				}catch(Exception io){
					JOptionPane.showMessageDialog(null, "Error");
				}				
			}
		});
		mnA.add(mntmVerManual_1);
		
		JMenu menu_1 = new JMenu("Acerca de");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("Informaci\u00F3n del software");
		menu_1.add(menuItem_1);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 249, 173));
		
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 12, 776, 48);
		panel_1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Seleccionar Proceso", TitledBorder.LEFT, TitledBorder.TOP));
		
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(36, 24, 70, 15);
		panel_1.add(lblTipo);
		
		JLabel lblFase = new JLabel("Fase");
		lblFase.setBounds(290, 24, 70, 15);
		panel_1.add(lblFase);
		
		JLabel lblAo = new JLabel("Año");
		lblAo.setBounds(549, 24, 70, 15);
		panel_1.add(lblAo);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(new Color(77, 1, 33));
		spinner.setBackground(Color.WHITE);
		spinner.setValue(2016);
		spinner.setBounds(615, 22, 69, 20);
		panel_1.add(spinner);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 249, 173));
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Docentes", TitledBorder.LEFT, TitledBorder.TOP));
		panel.setBounds(10, 60, 370, 382);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 249, 173));
		panel_3.setBounds(12, 20, 346, 109);
		panel_3.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Formuladores", TitledBorder.LEFT, TitledBorder.TOP));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_6 = new JLabel("Cantidad", SwingConstants.CENTER);
		label_6.setBounds(170, 12, 118, 27);
		panel_3.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 40, 118, 22);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(30, 12, 110, 87);
		ImageIcon fot6 = new ImageIcon("./Imagenes/docente_formuladores.png");
        ImageIcon icono6 = new ImageIcon(fot6.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel_1.setIcon(icono6);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 249, 173));
		panel_4.setBounds(12, 135, 346, 109);
		panel_4.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Técnicos", TitledBorder.LEFT, TitledBorder.TOP));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		textFieldTecnicos = new JTextField();
		textFieldTecnicos.setColumns(10);
		textFieldTecnicos.setBounds(170, 43, 124, 22);
		panel_4.add(textFieldTecnicos);
		
		JButton button = new JButton("Empezar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> capacidad = new ArrayList<Object>();
				capacidad.add(Integer.parseInt(textFieldTecnicos.getText()));
				capacidad.add(0);
				
				List<ParticipanteBuscar> participantesBuscar = new ArrayList<ParticipanteBuscar>();
				Conexion conn = new Conexion();
				ArrayList<ParticipanteOut> participantesTemp = conn.mostrar();
				for (int i = 0; i < participantesTemp.size(); i++) {
					participantesBuscar.add(new ParticipanteBuscar(participantesTemp.get(i), true));
				}
				 
				
				SeleccionTecnicos seleccionTecnicos = new SeleccionTecnicos(participantesBuscar, capacidad);
				seleccionTecnicos.frame.setVisible(true);
				Main.centralizar(seleccionTecnicos.frame);
			}
		});
		
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(77, 1, 33));
		button.setBounds(170, 77, 124, 22);
		panel_4.add(button);
		
		JLabel label_7 = new JLabel("Cantidad", SwingConstants.CENTER);
		label_7.setBounds(170, 12, 124, 27);
		panel_4.add(label_7);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(26, 15, 110, 87);
		ImageIcon fot7 = new ImageIcon("./Imagenes/docentes_tecnicos.png");
        ImageIcon icono7 = new ImageIcon(fot7.getImage().getScaledInstance(label_9.getWidth(), label_9.getHeight(), Image.SCALE_DEFAULT));
        label_9.setIcon(icono7);
		panel_4.add(label_9);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 249, 173));
		panel_7.setBounds(12, 250, 346, 109);
		panel_7.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Controladores", TitledBorder.LEFT, TitledBorder.TOP));
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JButton button_3 = new JButton("Empezar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Buscar buscar = new Buscar();
//				buscar.frame.setVisible(true);
//				Main.centralizar(buscar.frame);
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(77, 1, 33));
		button_3.setBounds(163, 75, 124, 22);
		panel_7.add(button_3);
		
		JLabel label_8 = new JLabel("Cantidad", SwingConstants.CENTER);
		label_8.setBounds(160, 15, 120, 25);
		panel_7.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(163, 41, 124, 22);
		panel_7.add(textField_6);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setBounds(26, 15, 110, 87);
		ImageIcon fot10 = new ImageIcon("./Imagenes/docentes_controladores.png");
        ImageIcon icono10 = new ImageIcon(fot10.getImage().getScaledInstance(label_10.getWidth(), label_10.getHeight(), Image.SCALE_DEFAULT));
        label_10.setIcon(icono10);
		panel_7.add(label_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 249, 173));
		panel_2.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
						"Personal Administrativa", TitledBorder.LEFT, TitledBorder.TOP));
		panel_2.setBounds(392, 60, 396, 382);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 249, 173));
		panel_6.setBounds(12, 110, 372, 84);
		panel_6.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Contadores", TitledBorder.LEFT, TitledBorder.TOP));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JButton button_2 = new JButton("Empezar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Buscar buscar = new Buscar();
//				buscar.frame.setVisible(true);
//				Main.centralizar(buscar.frame);
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(77, 1, 33));
		button_2.setBounds(175, 50, 95, 22);
		panel_6.add(button_2);
		
		JLabel label = new JLabel("Cantidad");
		label.setBounds(140, 15, 120, 25);
		panel_6.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(229, 18, 118, 22);
		panel_6.add(textField_1);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(20, 15, 95, 60);
		ImageIcon fot2 = new ImageIcon("./Imagenes/administradores_contadores.png");
        ImageIcon icono2 = new ImageIcon(fot2.getImage().getScaledInstance(label_3 .getWidth(), label_3 .getHeight(), Image.SCALE_DEFAULT));
        label_3 .setIcon(icono2);
		panel_6.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 249, 173));
		panel_5.setBounds(12, 20, 372, 84);
		panel_5.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Conserjes", TitledBorder.LEFT, TitledBorder.TOP));
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JButton button_1 = new JButton("Empezar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Buscar buscar = new Buscar();
//				buscar.frame.setVisible(true);
//				Main.centralizar(buscar.frame);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(77, 1, 33));
		button_1.setBounds(175, 50, 95, 22);
		panel_5.add(button_1);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(140, 15, 120, 25);
		panel_5.add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(229, 18, 118, 22);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(20, 15, 95, 60);
		ImageIcon fot = new ImageIcon("./Imagenes/administradores_conserjes.png");
        ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(icono);
		panel_5.add(lblNewLabel);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 249, 173));
		panel_8.setBounds(12, 200, 372, 84);
		panel_8.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Porteros", TitledBorder.LEFT, TitledBorder.TOP));
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JButton button_4 = new JButton("Empezar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Buscar buscar = new Buscar();
//				buscar.frame.setVisible(true);
//				Main.centralizar(buscar.frame);
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(77, 1, 33));
		button_4.setBounds(175, 50, 95, 22);
		panel_8.add(button_4);
		
		JLabel label_1 = new JLabel("Cantidad");
		label_1.setBounds(140, 15, 120, 25);
		panel_8.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(229, 18, 118, 22);
		panel_8.add(textField_2);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(20, 15, 95, 60);
		ImageIcon fot4 = new ImageIcon("./Imagenes/administradores_porteros.png");
        ImageIcon icono4 = new ImageIcon(fot4.getImage().getScaledInstance(label_4.getWidth(), label_4.getHeight(), Image.SCALE_DEFAULT));
        label_4.setIcon(icono4);
		
		panel_8.add(label_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 249, 173));
		panel_9.setBounds(12, 290, 372, 84);
		panel_9.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Revisadores", TitledBorder.LEFT, TitledBorder.TOP));
		panel_2.add(panel_9);
		panel_9.setLayout(null);
		
		JButton button_5 = new JButton("Empezar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Buscar buscar = new Buscar();
//				buscar.frame.setVisible(true);
//				Main.centralizar(buscar.frame);
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(77, 1, 33));
		button_5.setBounds(175, 50, 95, 22);
		panel_9.add(button_5);
		
		JLabel label_2 = new JLabel("Cantidad");
		label_2.setBounds(140, 15, 120, 25);
		panel_9.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(229, 18, 118, 22);
		panel_9.add(textField_3);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(20, 15, 95, 60);
		ImageIcon fot5 = new ImageIcon("./Imagenes/administradores_revisadores.png");
        ImageIcon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_DEFAULT));
        label_5.setIcon(icono5);
		
		panel_9.add(label_5);

		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(77, 1, 33));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(360, 19, 79, 20);
		panel_1.add(comboBox_1);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(77, 1, 33));
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("");
		comboBox.addItem("ORDINARIO");
		comboBox.addItem("CEPREUNSA");
		comboBox.addItem("EXTRAORDINARIO");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("EXTRAORDINARIO")) {
					comboBox_1.setEnabled(true);
					comboBox_1.removeAllItems();
					comboBox_1.addItem("1");
					textField_4.setText("50");
					textFieldTecnicos.setText("25");
					textField_6.setText("50");
					textField.setText("15");
					textField_1.setText("10");
					textField_2.setText("8");
					textField_3.setText("8");
				} else if (comboBox.getSelectedItem().equals("CEPREUNSA")) {
					comboBox_1.setEnabled(true);
					comboBox_1.removeAllItems();
					comboBox_1.addItem("1");
					comboBox_1.addItem("2");
					comboBox_1.addItem("3");
					textField_4.setText("50");
					textFieldTecnicos.setText("50");
					textField_6.setText("75");
					textField.setText("20");
					textField_1.setText("10");
					textField_2.setText("12");
					textField_3.setText("8");
				} else if (comboBox.getSelectedItem().equals("ORDINARIO")) {
					comboBox_1.setEnabled(true);
					comboBox_1.removeAllItems();
					comboBox_1.addItem("1");
					comboBox_1.addItem("2");
					comboBox_1.addItem("3");
					textField_4.setText("50");
					textFieldTecnicos.setText("100");
					textField_6.setText("150");
					textField.setText("40");
					textField_1.setText("10");
					textField_2.setText("20");
					textField_3.setText("16");
				} else {
					comboBox_1.removeAllItems();
					comboBox_1.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(112, 19, 112, 20);
		panel_1.add(comboBox);
		
		JButton btnExportar = new JButton("Exportar Listas");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exportar exportar = new Exportar();
				Main.centralizar(exportar.frame);
				exportar.frame.setVisible(true);
			}
		});
		btnExportar.setForeground(Color.WHITE);
		btnExportar.setBackground(new Color(77, 1, 33));
		btnExportar.setBounds(250, 466, 150, 25);
		frame.getContentPane().add(btnExportar);
		
		JButton btnDdd = new JButton("Enviar Mensaje");
		btnDdd.setForeground(Color.WHITE);
		btnDdd.setBackground(new Color(77, 1, 33));
		btnDdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDdd.setBounds(410, 466, 150, 25);
		frame.getContentPane().add(btnDdd);
		
		JButton btnNewButton = new JButton("Empezar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conn = new Conexion();
				conn.crearCabezera(
						Integer.parseInt(comboBox_1.getSelectedItem().toString()),
						comboBox.getSelectedItem().toString(),
						Integer.parseInt(spinner.getValue().toString())
						);
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(false);
				spinner.setEnabled(false);
				DefinirAreas definirAreas = new DefinirAreas(Integer.parseInt(textField_4.getText()));
				definirAreas.frame.setVisible(true);
				Main.centralizar(definirAreas.frame);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(77, 1, 33));
		btnNewButton.setBounds(170, 77, 118, 22);
		panel_3.add(btnNewButton);
	}
}