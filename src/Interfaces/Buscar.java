package Interfaces;

import javax.swing.*;


import javax.swing.border.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Clases.Participante;
import Clases.ParticipanteOut;
import Clases.Seleccionado;
import Controladores.Conexion;
import Controladores.Main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Buscar {

	public JFrame frame;
	private JTextField textField;
	private JTextField txtApellidos;
	public ArrayList<Seleccionado> seleccionados;
	DefaultTableModel model;
	int capacidad = 0;
	int contador = 0;
	
	public static void main(String[] args) {
		Buscar buscar = new Buscar();
		buscar.frame.setVisible(true);
	}
	
	public void buscar (String [][] areas) {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("Buscar");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

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
		
		JTable tableSeleccionados = new JTable(new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "Eliminar"}, 0))  {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default:
					return Boolean.class;
				}				
			}
		};
		
		DefaultTableModel model2 = (DefaultTableModel) tableSeleccionados.getModel();

		tableSeleccionados.getColumnModel().getColumn(0).setMinWidth(100);
		tableSeleccionados.getColumnModel().getColumn(1).setMinWidth(200);
		tableSeleccionados.getColumnModel().getColumn(2).setMinWidth(200);
		tableSeleccionados.getColumnModel().getColumn(3).setMinWidth(40);
		
		tableSeleccionados.getModel().addTableModelListener(new TableModelListener() {
			@Override  
			public void tableChanged(TableModelEvent e) {
				
				if(e.getColumn() == 2 && e.getFirstRow() >- 1){
					
					System.out.println("Row : " + e.getFirstRow() +
							" value :" + tableSeleccionados.getValueAt(e.getFirstRow(), e.getColumn()));

				}
			}
		});
		tableSeleccionados.setPreferredScrollableViewportSize(tableSeleccionados.getPreferredSize());
		tableSeleccionados.setBounds(5, 17, 320, 417);
		tableSeleccionados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(250);
		tableSeleccionados.getColumnModel().getColumn(1).setPreferredWidth(70);
		panel.setLayout(null);
		
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

		
		JTable tableParticipantes = new JTable(new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "Agregar"}, 0))  {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default:
					return Boolean.class;
				}				
			}
		};
		
		ArrayList<Integer> direcciones = new ArrayList<Integer>();
		
		DefaultTableModel model = (DefaultTableModel) tableParticipantes.getModel();

		Conexion conn = new Conexion();
		ArrayList<ParticipanteOut> participantes = conn.mostrar();
		
		for (int i = 0; i < participantes.size(); i++) {
			model.addRow(new Object[]{participantes.get(i).getDni_participante(),
					participantes.get(i).getNombre_participante(),
					participantes.get(i).getApellido_participante(),
					new Boolean(false)});
		}
		
		tableParticipantes.getColumnModel().getColumn(0).setMinWidth(100);
		tableParticipantes.getColumnModel().getColumn(1).setMinWidth(200);
		tableParticipantes.getColumnModel().getColumn(2).setMinWidth(200);
		tableParticipantes.getColumnModel().getColumn(3).setMinWidth(40);
		
		for (int i = 0; i < areas.length; i++) {
			capacidad += Integer.parseInt(areas[i][1]);
		}
		System.out.println(capacidad);
		tableParticipantes.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (contador < capacidad) {
					if(e.getColumn() == 3 && e.getFirstRow() >- 1) {
						if (tableParticipantes.getValueAt(e.getFirstRow(), e.getColumn()).equals(true)) {
							direcciones.add(e.getFirstRow());
							contador++;
							model2.addRow(new Object[] {
									model.getValueAt(e.getFirstRow(), 0),
									model.getValueAt(e.getFirstRow(), 1),
									model.getValueAt(e.getFirstRow(), 2),
									false});
						} else {
							contador--;
							System.out.println(direcciones.indexOf(e.getFirstRow()));
							model2.removeRow(direcciones.indexOf(e.getFirstRow()));
							direcciones.remove(direcciones.indexOf(e.getFirstRow()));
						}
						
						//e.getFirstRow() >> Columna
						//tableParticipantes.getValueAt(e.getFirstRow(), e.getColumn());
					}
				} else {
					if (tableParticipantes.getValueAt(e.getFirstRow(), e.getColumn()).equals(false)) {
						contador--;
						System.out.println(contador);
					} else {
						tableParticipantes.setValueAt(false, e.getFirstRow(), e.getColumn());
						contador++;
					}
				}
			}
		});
		
		tableParticipantes.setPreferredScrollableViewportSize(tableParticipantes.getPreferredSize());
		tableParticipantes.setBounds(5, 17, 320, 417);
		tableParticipantes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableParticipantes.getColumnModel().getColumn(0).setPreferredWidth(250);
		tableParticipantes.getColumnModel().getColumn(1).setPreferredWidth(70);
		panel1.setLayout(null);


		JScrollPane scrollPane1 = new JScrollPane(tableParticipantes);
		scrollPane1.setBounds(12, 27, 556, 168);
		panel1.add(scrollPane1);

		JButton btnRegresar = new JButton("Agregar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (areas == null || seleccionados == null) {
					frame.dispose();
				}
				ArrayList<Seleccionado> seleccionadosTemp = new ArrayList<Seleccionado>();
				for (int j = 0; j < model2.getRowCount(); j++) {
					seleccionadosTemp.add(new Seleccionado(
							tableSeleccionados.getValueAt(j, 0) + "",
							124,
							23
							));
					System.out.println(seleccionadosTemp.get(j).toString());
				}
				SeleccionEspecifica seleccionEspecifica = new SeleccionEspecifica();
				seleccionEspecifica.secundario(seleccionadosTemp, areas);
				seleccionEspecifica.frame.setVisible(true);
				Main.centralizar(seleccionEspecifica.frame);
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