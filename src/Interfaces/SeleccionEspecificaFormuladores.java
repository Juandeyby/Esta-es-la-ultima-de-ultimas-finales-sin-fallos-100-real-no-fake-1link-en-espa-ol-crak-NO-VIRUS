package Interfaces;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import Clases.FormatoTablaAreas;
import Clases.FormatoTablaFormuladores;
import Clases.HistorialOut;
import Clases.ParticipanteBuscar;
import Clases.ParticipantePromedio;
import Controladores.ButtonColumn;
import Controladores.Conexion;
import Controladores.Main;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class SeleccionEspecificaFormuladores {

	public JFrame frame;
	DefaultTableModel model;
	JTable table11;
	DefaultTableModel modelAreas;

	public SeleccionEspecificaFormuladores (List<ParticipanteBuscar> participantesBuscar, ArrayList<ArrayList<Object>> areas) {
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
		FormatoTablaAreas formatoTablaAreas = new FormatoTablaAreas();
		table22.setDefaultRenderer(Object.class, formatoTablaAreas);
		
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
		
		FormatoTablaFormuladores formatoTablaformuladores = new FormatoTablaFormuladores(participantesBuscar);
		table11.setDefaultRenderer(Object.class, formatoTablaformuladores);
		
		table11.getColumnModel().getColumn(0).setMinWidth(70);
		table11.getColumnModel().getColumn(1).setMinWidth(110);
		table11.getColumnModel().getColumn(2).setMinWidth(110);
		table11.getColumnModel().getColumn(3).setMinWidth(100);
		
		model = (DefaultTableModel) table11.getModel();
		modelAreas = (DefaultTableModel) table22.getModel();
		
		for (int i = 0; i < areas.size(); i++) {
			areas.get(i).set(2, 0);
		}
		
		for (int i = 0; i < participantesBuscar.size(); i++) {
			if (!participantesBuscar.get(i).isBuscar()) {
				model.addRow(new Object[]{
						participantesBuscar.get(i).getDni_participante(),
						participantesBuscar.get(i).getNombre_participante(),
						participantesBuscar.get(i).getApellido_participante(),
						"Eliminar"
						});
				
				for (int j = 0; j < areas.size(); j++) {
					if (participantesBuscar.get(i).getId_especialidad().equals(areas.get(j).get(0).toString()))
						areas.get(j).set(2, Integer.parseInt(areas.get(j).get(2).toString()) + 1);
				}
			}
		}
		
		while (modelAreas.getRowCount() > 0)
			modelAreas.removeRow(0);
		
		for (int j = 0; j < areas.size(); j++) {
			modelAreas.addRow(new Object[] {
					areas.get(j).get(0).toString(),
					Integer.parseInt(areas.get(j).get(1).toString()) - Integer.parseInt(areas.get(j).get(2).toString()),
					});
		}
		
		Action eliminar = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		    	int modelRow = Integer.valueOf(e.getActionCommand());
		        
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).getDni_participante().equals(model.getValueAt(modelRow, 0))) {
						participantesBuscar.get(i).setBuscar(true);
						
						for (int j = 0; j < areas.size(); j++) {
							System.out.println(areas.get(j).get(0).toString());
							if (participantesBuscar.get(i).getId_especialidad().equals(areas.get(j).get(0).toString()))
								areas.get(j).set(2, Integer.parseInt(areas.get(j).get(2).toString()) - 1);
						}
						
						while (modelAreas.getRowCount() > 0)
							modelAreas.removeRow(0);
						
						for (int j = 0; j < areas.size(); j++) {
							modelAreas.addRow(new Object[] {
									areas.get(j).get(0).toString(),
									Integer.parseInt(areas.get(j).get(1).toString()) - Integer.parseInt(areas.get(j).get(2).toString()),
									});
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
		Button31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarFormuladores buscar = new BuscarFormuladores();
				buscar.buscar(participantesBuscar, areas);
				buscar.frame.setVisible(true);
				Main.centralizar(buscar.frame);
				frame.dispose();
			}
		});
//		Button31.setEnabled(false);
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
				Conexion conn = new Conexion();
				List<HistorialOut> historialOut = new ArrayList<HistorialOut>();
				historialOut = conn.mostrarHistorial();
				
				List<ParticipantePromedio> participantesPromedios= conn.experienciaPromedio(historialOut);
				
				if (participantesPromedios.size() > 0) {
					Collections.sort(participantesPromedios, new Comparator<ParticipantePromedio>() {
						public int compare(final ParticipantePromedio object1, final ParticipantePromedio object2) {
							if (object1.getExperienciaPromedio() > object2.getExperienciaPromedio())
								return -1;
							else if (object1.getExperienciaPromedio() < object2.getExperienciaPromedio())
								return 1;
							else
								return 0;
						}
					});
				}
				
				for (int i = 0; i < participantesPromedios.size(); i++) {
					System.out.println(participantesPromedios.get(i).toString());
				}
				
				int total = 0;
				for (int i = 0; i < areas.size(); i++) {
					total += Integer.parseInt(areas.get(i).get(1).toString());
				}
				
				int seleccionados = 0;
				for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar())
						seleccionados++;
				}
				
				int control = Integer.parseInt(textField.getText());
				
				if (total - seleccionados < Integer.parseInt(textField.getText())) {
					control = total - seleccionados;
				}
				
				for (int i = 0; i < participantesPromedios.size(); i++) {
					if (control == 0)
						break;
					for (int j = 0; j < participantesBuscar.size(); j++) {
						if (participantesPromedios.get(i).getDni_participante().equals(participantesBuscar.get(j).getDni_participante())
								&& participantesBuscar.get(j).isBuscar()) {
							participantesBuscar.get(j).setBuscar(false);
							control--;
							break;
						}
					}
				}
				
				SeleccionEspecificaFormuladores seleccionEspecificaFormuladores = new SeleccionEspecificaFormuladores(participantesBuscar, areas);
				seleccionEspecificaFormuladores.frame.setVisible(true);
				Main.centralizar(seleccionEspecificaFormuladores.frame);
				frame.dispose();
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
				Conexion conn = new Conexion();
				List<HistorialOut> historialOut = new ArrayList<HistorialOut>();
				historialOut = conn.mostrarHistorial();
				
				int total = 0;
				for (int i = 0; i < areas.size(); i++) {
					total += Integer.parseInt(areas.get(i).get(1).toString());
				}
				
				int seleccionados = 0;
				for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar())
						seleccionados++;
				}
				// no debe susperar el numero de faltantes de la base de datos
				for (int j = 0; j < total - seleccionados; j++) {
					System.out.println(j);
					int random = (int) (Math.random()*(participantesBuscar.size()));
					if (!participantesBuscar.get(random).isBuscar())
						j--;
					else {
						int k;
						for (k = 0; k < historialOut.size(); k++) {
							if (historialOut.get(k).getDni_participante().equals(participantesBuscar.get(random).getDni_participante())) {
								j--;
								break;
							}
						}
						if (k == historialOut.size()) {
							participantesBuscar.get(random).setBuscar(false);
						}
					}
				}
				
				SeleccionEspecificaFormuladores seleccionEspecificaFormuladores = new SeleccionEspecificaFormuladores(participantesBuscar, areas);
				seleccionEspecificaFormuladores.frame.setVisible(true);
				Main.centralizar(seleccionEspecificaFormuladores.frame);
				frame.dispose();
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
