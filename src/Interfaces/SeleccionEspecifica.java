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

public class SeleccionEspecifica {

	public JFrame frame;
	private ArrayList<Seleccionado> seleccionados;
	DefaultTableModel model;
	JTable table11;
	
	public static void main(String[] args) {
		String [][] areas = {{"QUIMICA", 5 + ""},
				{"BIOLOGIA",  5 + ""},
				{"FISICA",  5 + ""},
				{"LENGUAJE",  5 + ""},
				{"LITERATURA",  0 + ""},
				{"HISTORIA",  0 + ""},
				{"GEOGRAFIA",  0 + ""},
				{"FILOSOLOFIA",  0 + ""},
				{"PSICOLOGIA", 0 + ""},
				{"MATEMATICA", 0 + ""},
				{"RAZVERBAL", 0 + ""},
				{"RAZMATEMATICO", 0 + ""},
				};
		SeleccionEspecifica seleccionEspecifica = new SeleccionEspecifica();
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
				Buscar buscar = new Buscar();
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
	
	public void secundario (ArrayList<ParticipanteOut> seleccionados, String [][] areas) {
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
		panel1.setBounds(10, 10, 330, 390);
		panel1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Lista Seleccionada", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		table11 = new JTable(new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "Eliminar"}, 0))  {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default:
					return Boolean.class;
				}				
			}
		};
		
		table11.getColumnModel().getColumn(0).setMinWidth(25);
		table11.getColumnModel().getColumn(1).setMinWidth(100);
		table11.getColumnModel().getColumn(2).setMinWidth(100);
		table11.getColumnModel().getColumn(3).setMinWidth(50);
		
		model = (DefaultTableModel) table11.getModel();
		
		for (int i = 0; seleccionados != null && i < seleccionados.size(); i++) {
			model.addRow(new Object[]{
					seleccionados.get(i).getDni_participante(),
					seleccionados.get(i).getNombre_participante(),
					seleccionados.get(i).getApellido_participante(),
					false
					});
		}
		
		table11.getModel().addTableModelListener(new TableModelListener() {
			@Override  
			public void tableChanged(TableModelEvent e) {
				
				if(e.getColumn() == 6 && e.getFirstRow() >- 1){
					Conexion conn = new Conexion();
//						System.out.println(conn.cambioEstadoParticipante(
//								Integer.parseInt(buscador[e.getFirstRow()][0]),
//								!Boolean.parseBoolean(buscador[e.getFirstRow()][6])
//								));

				}
			}
		});
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
		Button31.setEnabled(false);
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
		lblCantidad.setBounds(40, 60, 70, 15);
		panel32.add(lblCantidad);

		JTextField textField = new JTextField();
		textField.setBounds(120, 55, 70, 25);
		panel32.add(textField);
		textField.setColumns(10);
		
		JButton Button32 = new JButton("Seleccionar");
		Button32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ParticipanteOut> seleccionadosTemp = new ArrayList<ParticipanteOut>();
				
				Conexion conn = new Conexion();
				ArrayList<ParticipanteOut> participantes = conn.mostrar();
				
				for (int i = 0; i < participantes.size(); i++) {
					boolean temp = false;
					for (int j = 0; j < seleccionados.size(); j++) {
						if (participantes.get(i).getDni_participante() == seleccionados.get(j).getDni_participante()) {
							temp = true;
							continue;
						}
					}
					if(!temp) {
						seleccionadosTemp.add(new ParticipanteOut(
								participantes.get(i).getDni_participante(),
								participantes.get(i).getNombre_participante(),
								participantes.get(i).getApellido_participante()
								));
					}
				}
				
				for (int i = 0; i < seleccionadosTemp.size() && i < Integer.parseInt(textField.getText()); i++) {
					seleccionados.add(seleccionadosTemp.get(i));
				}
				
				SeleccionEspecifica seleccionEspecifica = new SeleccionEspecifica();
				seleccionEspecifica.secundario(seleccionados, areas);
				seleccionEspecifica.frame.setVisible(true);
				Main.centralizar(seleccionEspecifica.frame);
				frame.dispose();
			}
		});
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
		Button33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ParticipanteOut> seleccionadosTemp = new ArrayList<ParticipanteOut>();
				
				Conexion conn = new Conexion();
				ArrayList<ParticipanteOut> participantes = conn.mostrar();
				
				for (int i = 0; i < participantes.size(); i++) {
					boolean temp = false;
					for (int j = 0; j < seleccionados.size(); j++) {
						if (participantes.get(i).getDni_participante() == seleccionados.get(j).getDni_participante()) {
							temp = true;
							continue;
						}
					}
					if(!temp) {
						seleccionadosTemp.add(new ParticipanteOut(
								participantes.get(i).getDni_participante(),
								participantes.get(i).getNombre_participante(),
								participantes.get(i).getApellido_participante()
								));
					}
				}
				
				boolean [] random = new boolean [seleccionadosTemp.size()];
				for (int i = 0; i < seleccionadosTemp.size(); i++) {
					if (random[(int) (Math.random()*seleccionadosTemp.size())]) {
						i--;
					} else {
						seleccionados.add(seleccionadosTemp.get(i));
						random[i] = true;
					}
				}
				
				SeleccionEspecifica seleccionEspecifica = new SeleccionEspecifica();
				seleccionEspecifica.secundario(seleccionados, areas);
				seleccionEspecifica.frame.setVisible(true);
				Main.centralizar(seleccionEspecifica.frame);
				frame.dispose();
			}
		});
		Button33.setBounds(57, 30, 120, 25);
		panel33.add(Button33);
		
		JButton btnRegresar = new JButton("Guardar");
		btnRegresar.setBounds(325, 410, 150, 25);
		frame.getContentPane().add(btnRegresar);
	}
}
