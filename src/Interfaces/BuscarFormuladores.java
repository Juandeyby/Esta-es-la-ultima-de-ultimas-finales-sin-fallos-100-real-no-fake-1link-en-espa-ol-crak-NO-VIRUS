package Interfaces;

import javax.swing.*;


import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import Clases.ParticipanteBuscar;
import Clases.Seleccionado;
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

public class BuscarFormuladores {

	public JFrame frame;
	private JTextField textField;
	private JTextField txtApellidos;
	public ArrayList<Seleccionado> seleccionados;
	DefaultTableModel model;
	int capacidad = 0;
	int contador = 0;
	Conexion conn;
	JTable tableParticipantes;
	DefaultTableModel modelSeleccionados;
	DefaultTableModel modelParticipantes;
	
	public void buscar (List<ParticipanteBuscar> participantesBuscar, ArrayList<ArrayList<Object>> areas) {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("Buscar");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		conn = new Conexion();
		
		if (participantesBuscar.size() > 0) {
			Collections.sort(participantesBuscar, new Comparator<ParticipanteBuscar>() {
				public int compare(final ParticipanteBuscar object1, final ParticipanteBuscar object2) {
					return object1.getApellido_participante().compareTo(object2.getApellido_participante());
				}
			});
		}
		
		for (int i = 0; i < participantesBuscar.size(); i++) {
			System.out.println(participantesBuscar.get(i).toString());
		}

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Ayuda");
		menuBar.add(mnNewMenu);

		JMenuItem mntmVerManual = new JMenuItem("Ver Manual");
		mnNewMenu.add(mntmVerManual);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 290, 580, 214);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Resultados", TitledBorder.LEFT, TitledBorder.TOP));
		
		JTable tableSeleccionados = new JTable(new DefaultTableModel(new Object[]{"DNI", "Nombre", "Apellido", "Especialidad", "Eliminar"}, 0));
		
		modelSeleccionados = (DefaultTableModel) tableSeleccionados.getModel();

		tableSeleccionados.getColumnModel().getColumn(0).setMinWidth(75);
		tableSeleccionados.getColumnModel().getColumn(1).setMinWidth(130);
		tableSeleccionados.getColumnModel().getColumn(2).setMinWidth(130);
		tableSeleccionados.getColumnModel().getColumn(3).setMinWidth(90);
		tableSeleccionados.getColumnModel().getColumn(4).setMinWidth(100);
		
		tableSeleccionados.setPreferredScrollableViewportSize(tableSeleccionados.getPreferredSize());
		tableSeleccionados.setBounds(5, 17, 320, 417);
		tableSeleccionados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(250);
		tableSeleccionados.getColumnModel().getColumn(1).setPreferredWidth(70);
		panel.setLayout(null);
		
		Action elminar = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).getDni_participante().equals(modelSeleccionados.getValueAt(modelRow, 0)))
						participantesBuscar.get(i).setBuscar(true);
				}
		    	
		    	while (modelParticipantes.getRowCount() > 0)
		    		modelParticipantes.removeRow(0);
		    	
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).isBuscar())
						modelParticipantes.addRow(new Object[]{
								participantesBuscar.get(i).getDni_participante(),
								participantesBuscar.get(i).getNombre_participante(),
								participantesBuscar.get(i).getApellido_participante(),
								participantesBuscar.get(i).getId_especialidad(),
								"Agregar"});
				}
		    	
		    	while (modelSeleccionados.getRowCount() > 0)
		    		modelSeleccionados.removeRow(0);
		    	
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar())
						modelSeleccionados.addRow(new Object[]{
								participantesBuscar.get(i).getDni_participante(),
								participantesBuscar.get(i).getNombre_participante(),
								participantesBuscar.get(i).getApellido_participante(),
								participantesBuscar.get(i).getId_especialidad(),
								"Eliminar"});
				}
		    }
		};
		
		ButtonColumn buttonColumn1 = new ButtonColumn(tableSeleccionados, elminar, 4);
		buttonColumn1.setMnemonic(KeyEvent.VK_D);

		
		JScrollPane scrollPane2 = new JScrollPane(tableSeleccionados);
		scrollPane2.setBounds(12, 23, 556, 179);
		panel.add(scrollPane2);
		frame.getContentPane().add(panel);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 71, 580, 207);
		panel1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Buscar", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel1);

		
		tableParticipantes = new JTable(new DefaultTableModel(new Object[]{"DNI", "Nombre", "Apellido", "Especialidad", "Agregar"}, 0));
		
		modelParticipantes = (DefaultTableModel) tableParticipantes.getModel();

		conn = new Conexion();
		for (int i = 0; i < participantesBuscar.size(); i++) {
			if (participantesBuscar.get(i).isBuscar())
				modelParticipantes.addRow(new Object[]{
						participantesBuscar.get(i).getDni_participante(),
						participantesBuscar.get(i).getNombre_participante(),
						participantesBuscar.get(i).getApellido_participante(),
						participantesBuscar.get(i).getId_especialidad(),
						"Agregar"});
		}
		
		tableParticipantes.getColumnModel().getColumn(0).setMinWidth(75);
		tableParticipantes.getColumnModel().getColumn(1).setMinWidth(130);
		tableParticipantes.getColumnModel().getColumn(2).setMinWidth(130);
		tableParticipantes.getColumnModel().getColumn(3).setMinWidth(90);
		tableParticipantes.getColumnModel().getColumn(4).setMinWidth(100);
		
		for (int i = 0; i < areas.size(); i++) {
			capacidad += Integer.parseInt(areas.get(i).get(1).toString());
		}
		System.out.println(capacidad);
		
		tableParticipantes.setPreferredScrollableViewportSize(tableParticipantes.getPreferredSize());
		tableParticipantes.setBounds(5, 17, 320, 417);
		tableParticipantes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableParticipantes.getColumnModel().getColumn(0).setPreferredWidth(250);
		tableParticipantes.getColumnModel().getColumn(1).setPreferredWidth(70);
		panel1.setLayout(null);
		
		Action agregar = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
		        int modelRow = Integer.valueOf(e.getActionCommand());
		        
		        int seleccionados = 0;
				for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar()
							&& participantesBuscar.get(i).getId_especialidad().equals(modelParticipantes.getValueAt(modelRow, 3).toString()))
						seleccionados++;
				}
		        
				int area = 0;
				while (area < areas.size()) {
					if (areas.get(area).get(0).equals(modelParticipantes.getValueAt(modelRow, 3).toString())) {
						break;
					}
					area++;
				}
				
		        if (Integer.parseInt(areas.get(area).get(1).toString()) - seleccionados == 0) {
		        	JOptionPane.showMessageDialog(null, "Excedio Cantidad de " + modelParticipantes.getValueAt(modelRow, 3).toString() + ".");
					return;
		        }
		        
		    	modelSeleccionados.addRow(new Object[] {
						modelParticipantes.getValueAt(modelRow, 0),
						modelParticipantes.getValueAt(modelRow, 1),
						modelParticipantes.getValueAt(modelRow, 2),
						modelParticipantes.getValueAt(modelRow, 3),
						"Eliminar"});

		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).getDni_participante().equals(modelParticipantes.getValueAt(modelRow, 0)))
						participantesBuscar.get(i).setBuscar(false);
				}
		    	
		    	while (modelParticipantes.getRowCount() > 0)
		    		modelParticipantes.removeRow(0);
		    	
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).isBuscar())
						modelParticipantes.addRow(new Object[]{
								participantesBuscar.get(i).getDni_participante(),
								participantesBuscar.get(i).getNombre_participante(),
								participantesBuscar.get(i).getApellido_participante(),
								participantesBuscar.get(i).getId_especialidad(),
								"Agregar"});
				}
		    }
		};
		
		ButtonColumn buttonColumn2 = new ButtonColumn(tableParticipantes, agregar, 4);
		buttonColumn2.setMnemonic(KeyEvent.VK_D);


		JScrollPane scrollPane1 = new JScrollPane(tableParticipantes);
		scrollPane1.setBounds(12, 27, 556, 168);
		panel1.add(scrollPane1);

		JButton btnRegresar = new JButton("Agregar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				SeleccionEspecificaFormuladores seleccionEspecificaFormuladores = new SeleccionEspecificaFormuladores(participantesBuscar, areas);
				seleccionEspecificaFormuladores.frame.setVisible(true);
				Main.centralizar(seleccionEspecificaFormuladores.frame);
				frame.dispose();
			}
		});
		
		btnRegresar.setBounds(209, 516, 150, 25);
		frame.getContentPane().add(btnRegresar);

		textField = new JTextField();
		textField.setBounds(40, 40, 150, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(220, 40, 150, 19);
		frame.getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(40, 20, 150, 15);
		frame.getContentPane().add(lblNombre);

		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while (modelParticipantes.getRowCount() > 0)
		    		modelParticipantes.removeRow(0);

				System.out.println(txtApellidos.getText());
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).isBuscar()) {
						if (participantesBuscar.get(i).getNombre_participante().indexOf(textField.getText()) != -1 &&
								participantesBuscar.get(i).getApellido_participante().indexOf(txtApellidos.getText()) != -1)
							modelParticipantes.addRow(new Object[]{
									participantesBuscar.get(i).getDni_participante(),
									participantesBuscar.get(i).getNombre_participante(),
									participantesBuscar.get(i).getApellido_participante(),
									participantesBuscar.get(i).getId_especialidad(),
									"Agregar"});
					}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setBounds(220, 20, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		button.setBounds(400, 25, 150, 25);
		frame.getContentPane().add(button);
		frame.getContentPane().add(panel1);
		
	}
}