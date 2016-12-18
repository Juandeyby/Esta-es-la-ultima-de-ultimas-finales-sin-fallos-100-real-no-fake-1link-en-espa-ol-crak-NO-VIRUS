package Interfaces;

import javax.swing.*;

import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

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

public class SeleccionContador {

	public JFrame frame;
	DefaultTableModel model;
	JTable table11;

	public SeleccionContador (List<ParticipanteBuscar> participantesBuscar, ArrayList<Object> capacidad) {
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

		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 602, 390);
		panel1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Lista Seleccionada", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		table11 = new JTable(new DefaultTableModel(new Object[]{"DNI", "Nombre", "Apellido", "Eliminar"}, 0));
		
		table11.getColumnModel().getColumn(0).setMinWidth(70);
		table11.getColumnModel().getColumn(1).setMinWidth(200);
		table11.getColumnModel().getColumn(2).setMinWidth(200);
		table11.getColumnModel().getColumn(3).setMinWidth(100);
		
		model = (DefaultTableModel) table11.getModel();
		
		for (int i = 0; i < capacidad.size(); i++) {
			capacidad.set(1, 0);
		}
		
		for (int i = 0; i < participantesBuscar.size(); i++) {
			if (!participantesBuscar.get(i).isBuscar()) {
				model.addRow(new Object[]{
						participantesBuscar.get(i).getDni_participante(),
						participantesBuscar.get(i).getNombre_participante(),
						participantesBuscar.get(i).getApellido_participante(),
						"Eliminar"
						});
				
				capacidad.set(1, Integer.parseInt(capacidad.get(1).toString()) + 1);
			}
		}
		
		Action eliminar = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		    	int modelRow = Integer.valueOf(e.getActionCommand());
		        
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).getDni_participante().equals(model.getValueAt(modelRow, 0))) {
						participantesBuscar.get(i).setBuscar(true);
						
						capacidad.set(1, Integer.parseInt(capacidad.get(1).toString()) - 1);
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
				BuscarContador buscarContador = new BuscarContador(participantesBuscar, capacidad);
				buscarContador.frame.setVisible(true);
				Main.centralizar(buscarContador.frame);
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
				
				int control = Integer.parseInt(textField.getText());
				
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
				
				SeleccionContador seleccionControladores = new SeleccionContador(participantesBuscar, capacidad);
				seleccionControladores.frame.setVisible(true);
				Main.centralizar(seleccionControladores.frame);
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
				
				int seleccionados = 0;
				for (int i = 0; i < participantesBuscar.size(); i++) {
					if (!participantesBuscar.get(i).isBuscar())
						seleccionados++;
				}
				
				// no debe susperar el numero de faltantes de la base de datos
				for (int j = 0; j < Integer.parseInt(capacidad.get(0).toString()) - seleccionados; j++) {
					int random = (int) (Math.random()*(participantesBuscar.size()));
					if (!participantesBuscar.get(random).isBuscar() && participantesBuscar.get(random).isVisto())
						j--;
					else {
						int k;
						for (k = 0; k < historialOut.size(); k++) {
							if (historialOut.get(k).getDni_participante().equals(participantesBuscar.get(random).getDni_participante())) {
								participantesBuscar.get(random).setVisto(true);
								j--;
								break;
							}
						}
						if (k == historialOut.size()) {
							participantesBuscar.get(random).setBuscar(false);
						}
					}
					
					boolean vistoTodos = true;
					for (int i = 0; i < participantesBuscar.size(); i++) {
						if (!participantesBuscar.get(i).isVisto()) {
							vistoTodos = false;
							break;
						}
					}
					
					if (vistoTodos) {
						JOptionPane.showMessageDialog(null, "Participantes insuficientes para cubrir");
						return;
					}
				}
				
				SeleccionContador seleccionEspecificaFormuladores = new SeleccionContador(participantesBuscar, capacidad);
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
				int i = JOptionPane.showConfirmDialog(null, "¿Desea Guardar la Selección?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if(i == 0){
					Conexion conn = new Conexion();
					conn.insertarExportar(4, participantesBuscar);
					JOptionPane.showMessageDialog(null, "Exito al Guardar Lista", "Exito", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
			}
		});
		btnRegresar.setBounds(325, 410, 150, 25);
		frame.getContentPane().add(btnRegresar);
	}
	
	public boolean buscarAreas (ParticipanteBuscar participanteBuscar, ArrayList<ArrayList<Object>> areas) {
		for (int i = 0; i < areas.size(); i++) {
			if (areas.get(i).get(0).toString().equals(participanteBuscar.getId_especialidad())) {
				if (Integer.parseInt(areas.get(i).get(1).toString()) == Integer.parseInt(areas.get(i).get(2).toString()))
					return false;
				else
					areas.get(i).set(2, Integer.parseInt(areas.get(i).get(2).toString()) + 1);
				break;
			}
		}
		return true;
	}
}