package Interfaces;
import javax.swing.*;



import javax.swing.border.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Clases.Participante;
import Clases.ParticipanteBuscar;
import Clases.ParticipanteOut;
import Clases.Seleccionado;
import Controladores.ButtonColumn;
import Controladores.Conexion;
import Controladores.Main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class SeleccionEspecificaFormuladores {

	public JFrame frame;
	private ArrayList<Seleccionado> seleccionados;
	DefaultTableModel model;
	JTable table11;
	DefaultTableModel modelAreas;
	
	public static void main(String[] args) {
		String [][] areas = {
				{"QUIMICA", 5 + ""},
				{"BIOLOGIA",  5 + ""},
				{"FISICA",  5 + ""},
				{"LENGUAJE",  5 + ""},
				{"LITERATURA",  0 + ""},
				{"HISTORIA",  0 + ""},
				{"GEOGRAFIA",  0 + ""},
				{"FILOSOFIA",  0 + ""},
				{"PSICOLOGIA", 0 + ""},
				{"MATEMATICA", 0 + ""},
				{"RAZVERBAL", 0 + ""},
				{"RAZMATEMATICO", 0 + ""},
				};
		SeleccionEspecificaFormuladores seleccionEspecifica = new SeleccionEspecificaFormuladores();
		seleccionEspecifica.principal(areas);
		seleccionEspecifica.frame.setVisible(true);
	}
	
	public void principal (String [][] areas) {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("Selección Especifica");
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JTable table11;

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Ayuda");
		menuBar.add(mnNewMenu);

		JMenuItem mntmVerManual = new JMenuItem("Ver Manual");
		mnNewMenu.add(mntmVerManual);
		frame.getContentPane().setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 330, 390);
		panel1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Lista Seleccionada", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		table11 = new JTable(new DefaultTableModel(new Object[]{"DNI", "Nombre", "Apellido", "Eliminar"}, 0));
		
		table11.getColumnModel().getColumn(0).setMinWidth(25);
		table11.getColumnModel().getColumn(1).setMinWidth(100);
		table11.getColumnModel().getColumn(2).setMinWidth(100);
		table11.getColumnModel().getColumn(3).setMinWidth(50);
		table11.setPreferredScrollableViewportSize(table11.getPreferredSize());
		table11.setBounds(5, 17, 320, 417);
		table11.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table11.getColumnModel().getColumn(0).setPreferredWidth(250);
		table11.getColumnModel().getColumn(1).setPreferredWidth(70);
		JScrollPane scrollPane1 = new JScrollPane(table11);
		panel1.add(scrollPane1, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setBounds(346, 10, 188, 390);
		panel2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Cantidad de Área", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		String[] column2 = { "Área", "Cantidad" };
		Object[][] data2 = areas;
		JTable table22 = new JTable(data2, column2);
		table22.setBounds(5, 17, 240, 417);
		table22.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table22.getColumnModel().getColumn(0).setPreferredWidth(150);
		table22.getColumnModel().getColumn(1).setPreferredWidth(90);
		JScrollPane scrollPane2 = new JScrollPane(table22);
		panel2.add(scrollPane2, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setBounds(540, 10, 250, 390);
		panel3.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Seleccionar", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);

		JPanel panel31 = new JPanel();
		panel31.setBounds(12, 12, 226, 77);
		panel31.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Directamente", TitledBorder.RIGHT, TitledBorder.TOP));
		panel3.add(panel31);
		panel31.setLayout(null);

		
		JButton Button31 = new JButton("Buscar");
		Button31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarFormuladores buscar = new BuscarFormuladores();
				buscar.buscar(areas);
				buscar.frame.setVisible(true);
				Main.centralizar(buscar.frame);
				frame.dispose();
			}
		});
		Button31.setBounds(55, 25, 120, 25);
		panel31.add(Button31);

		JPanel panel32 = new JPanel();
		panel32.setBounds(12, 101, 226, 187);
		panel32.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Experiencia", TitledBorder.RIGHT, TitledBorder.TOP));
		panel3.add(panel32);
		panel32.setLayout(null);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setEnabled(false);
		lblCantidad.setBounds(40, 60, 70, 15);
		panel32.add(lblCantidad);

		JTextField textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(120, 55, 70, 25);
		panel32.add(textField);
		textField.setColumns(10);
		
		JButton Button32 = new JButton("Seleccionar");
		Button32.setEnabled(false);
		Button32.setBounds(55, 100, 120, 25);
		panel32.add(Button32);

		JPanel panel33 = new JPanel();
		panel33.setBounds(12, 300, 226, 78);
		panel33.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Aleatoria", TitledBorder.RIGHT, TitledBorder.TOP));
		panel3.add(panel33);
		panel33.setLayout(null);
	
		JButton Button33 = new JButton("Completar");
		Button33.setEnabled(false);
		Button33.setBounds(57, 30, 120, 25);
		panel33.add(Button33);
		
		JButton btnRegresar = new JButton("Guardar");
		btnRegresar.setBounds(325, 410, 150, 25);
		frame.getContentPane().add(btnRegresar);
	}

	public void secundario (List<ParticipanteBuscar> participantesBuscar, String [][] areas) {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("Selección Especifica");
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Ayuda");
		menuBar.add(mnNewMenu);

		JMenuItem mntmVerManual = new JMenuItem("Ver Manual");
		mnNewMenu.add(mntmVerManual);
		frame.getContentPane().setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(424, 10, 188, 390);
		panel2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Cantidad de Área", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		JTable table22 = new JTable(new DefaultTableModel(new Object[]{"Área", "Cantidad"}, 0));
		
		table22.setBounds(5, 17, 240, 417);
		table22.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table22.getColumnModel().getColumn(0).setPreferredWidth(150);
		table22.getColumnModel().getColumn(1).setPreferredWidth(90);
		JScrollPane scrollPane2 = new JScrollPane(table22);
		panel2.add(scrollPane2, BorderLayout.CENTER);

		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 402, 390);
		panel1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Lista Seleccionada", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		table11 = new JTable(new DefaultTableModel(new Object[]{"DNI", "Nombre", "Apellido", "Eliminar"}, 0));
		
		table11.getColumnModel().getColumn(0).setMinWidth(70);
		table11.getColumnModel().getColumn(1).setMinWidth(110);
		table11.getColumnModel().getColumn(2).setMinWidth(110);
		table11.getColumnModel().getColumn(3).setMinWidth(100);
		
		DefaultTableModel model = (DefaultTableModel) table11.getModel();
		DefaultTableModel modelAreas = (DefaultTableModel) table22.getModel();
		
		for (int i = 0; i < participantesBuscar.size(); i++) {
			if (!participantesBuscar.get(i).isBuscar()) {
				model.addRow(new Object[]{
						participantesBuscar.get(i).getDni_participante(),
						participantesBuscar.get(i).getNombre_participante(),
						participantesBuscar.get(i).getApellido_participante(),
						"Eliminar"
						});
				
				for (int j = 0; j < areas.length; j++) {
					if (participantesBuscar.get(i).getId_especialidad().equals(areas[j][0]))
						areas[j][1] = (Integer.parseInt(areas[j][1]) - 1) + "";
				}
				
				while (modelAreas.getRowCount() > 0)
					modelAreas.removeRow(0);
				
				for (int j = 0; j < areas.length; j++) {
					modelAreas.addRow(new Object[]{areas[j][0], areas[j][1]});
				}
			}
		}
		
		Action eliminar = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	int modelRow = Integer.valueOf(e.getActionCommand());
		        
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).getDni_participante().equals(model.getValueAt(modelRow, 0))) {
						participantesBuscar.get(i).setBuscar(true);
						
						for (int j = 0; j < areas.length; j++) {
							System.out.println(areas[j][0]);
							if (participantesBuscar.get(i).getId_especialidad().equals(areas[j][0]))
								areas[j][1] = (Integer.parseInt(areas[j][1]) + 1) + "";
						}
						
						while (modelAreas.getRowCount() > 0)
							modelAreas.removeRow(0);
						
						for (int j = 0; j < areas.length; j++) {
							modelAreas.addRow(new Object[]{areas[j][0], areas[j][1]});
						}
					}
				}
		    	
		    	while (model.getRowCount() > 0)
		    		model.removeRow(0);
		    	
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar()) {
						model.addRow(new Object[]{
								participantesBuscar.get(i).getDni_participante(),
								participantesBuscar.get(i).getNombre_participante(),
								participantesBuscar.get(i).getApellido_participante(),
								"Eliminar"
								});
					}
				}
		    }
		};
		
		ButtonColumn buttonColumn2 = new ButtonColumn(table11, eliminar, 3);
		buttonColumn2.setMnemonic(KeyEvent.VK_D);
		
		table11.setPreferredScrollableViewportSize(table11.getPreferredSize());
		table11.setBounds(5, 17, 320, 417);
		table11.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table11.getColumnModel().getColumn(0).setPreferredWidth(250);
		table11.getColumnModel().getColumn(1).setPreferredWidth(70);
		
		JScrollPane scrollPane1 = new JScrollPane(table11);
		panel1.add(scrollPane1, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setBounds(624, 10, 164, 390);
		panel3.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Seleccionar", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);

		JPanel panel31 = new JPanel();
		panel31.setBounds(12, 12, 143, 77);
		panel31.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Directamente", TitledBorder.RIGHT, TitledBorder.TOP));
		panel3.add(panel31);
		panel31.setLayout(null);

		
		JButton Button31 = new JButton("Buscar");
		Button31.setEnabled(false);
		Button31.setBounds(12, 40, 119, 25);
		panel31.add(Button31);

		JPanel panel32 = new JPanel();
		panel32.setBounds(12, 101, 143, 166);
		panel32.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Experiencia", TitledBorder.RIGHT, TitledBorder.TOP));
		panel3.add(panel32);
		panel32.setLayout(null);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(38, 30, 70, 15);
		panel32.add(lblCantidad);

		JTextField textField = new JTextField();
		textField.setBounds(25, 57, 94, 25);
		panel32.add(textField);
		textField.setColumns(10);
		
		JButton Button32 = new JButton("Seleccionar");
		Button32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.getText();
			}
		});
		Button32.setBounds(12, 99, 120, 25);
		panel32.add(Button32);

		JPanel panel33 = new JPanel();
		panel33.setBounds(12, 279, 143, 99);
		panel33.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Aleatoria", TitledBorder.RIGHT, TitledBorder.TOP));
		panel3.add(panel33);
		panel33.setLayout(null);
		
		JButton Button33 = new JButton("Completar");
		Button33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				List<ParticipanteBuscar> participantesBuscarTemp = new ArrayList<ParticipanteBuscar>();
//				for (int i = 0; i < participantesBuscar.size(); i++) {
//					participantesBuscarTemp.add(participantesBuscar.get(i));
//				}
//				
//				if (participantesBuscarTemp.size() > 0) {
//					Collections.sort(participantesBuscarTemp, new Comparator<ParticipanteBuscar>() {
//						public int compare(final ParticipanteBuscar object1, final ParticipanteBuscar object2) {
//							return object1.getApellido_participante().compareTo(object2);
//						}
//					});
//				}
				
				for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar()) {
						model.addRow(new Object[]{
								participantesBuscar.get(i).getDni_participante(),
								participantesBuscar.get(i).getNombre_participante(),
								participantesBuscar.get(i).getApellido_participante(),
								"Eliminar"
								});
						
						for (int j = 0; j < areas.length; j++) {
							if (participantesBuscar.get(i).getId_especialidad().equals(areas[j][0]))
								areas[j][1] = (Integer.parseInt(areas[j][1]) - 1) + "";
						}
						
						while (modelAreas.getRowCount() > 0)
							modelAreas.removeRow(0);
						
						for (int j = 0; j < areas.length; j++) {
							modelAreas.addRow(new Object[]{areas[j][0], areas[j][1]});
						}
					}
				}
				
			}
		});
		Button33.setBounds(12, 33, 120, 25);
		panel33.add(Button33);
		
		JButton btnRegresar = new JButton("Guardar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conn = new Conexion();
				conn.insertarExportar(1, participantesBuscar);
			}
		});
		btnRegresar.setBounds(325, 410, 150, 25);
		frame.getContentPane().add(btnRegresar);
	}
}
