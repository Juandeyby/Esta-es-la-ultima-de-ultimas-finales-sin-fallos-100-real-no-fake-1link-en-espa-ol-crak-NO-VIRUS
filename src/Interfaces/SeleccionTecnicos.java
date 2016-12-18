package Interfaces;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import Clases.FormatoTablaAreas;
import Clases.FormatoTablaFormuladores;
import Clases.ParticipanteBuscar;
import Controladores.ButtonColumn;
import Controladores.Conexion;
import Controladores.Main;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SeleccionTecnicos {

	public JFrame frame;
	DefaultTableModel model;
	JTable table11;

	public SeleccionTecnicos(List<ParticipanteBuscar> participantesBuscar, ArrayList<Object> capacidad) {
		frame = new JFrame();
		ImageIcon img = new ImageIcon("./Imagenes/escudo.png");
		frame.setIconImage(img.getImage());
		frame.setTitle("Selección Técnicos");
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
		
		Action eliminar = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		    	int modelRow = Integer.valueOf(e.getActionCommand());
		        
		    	for (int i = 0; i < participantesBuscar.size(); i++) {
					if (participantesBuscar.get(i).getDni_participante().equals(model.getValueAt(modelRow, 0))) {
						participantesBuscar.get(i).setBuscar(true);
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
				BuscarTecnicos buscarTecnicos = new BuscarTecnicos(participantesBuscar, capacidad);
				buscarTecnicos.frame.setVisible(true);
				Main.centralizar(buscarTecnicos.frame);
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
