package Interfaces;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Clases.ParticipanteOut;
import Controladores.ButtonColumn;
import Controladores.Conexion;
import Controladores.ImportarHistorial;
import Controladores.ImportarParticipantes;
import Controladores.Main;


public class SesionAdministrador {

	public JFrame frame;
	DefaultTableModel model;
	JTable table;
	private JTextField apellidotextField_2;
	Conexion conn;

	public SesionAdministrador() {
		initialize();
	}
	
	public static void main(String[] args) {
		SesionAdministrador sesion = new SesionAdministrador();
		sesion.frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.setResizable(false);
	
		 JTextField nombretextField;
		 JTextField dnitextField;
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.setTitle("Sesion Administrador");
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("Mi perfil");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerfilAdministradorGeneral perfiladministradorgeneral = new PerfilAdministradorGeneral();
				Main.centralizar(perfiladministradorgeneral.frame);
				perfiladministradorgeneral.frame.setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem mntmSalir = new JMenuItem("Cerrar Sesión");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				Main.centralizar(login.frmExaminV);
				login.frmExaminV.setVisible(true);
			}
		});
		mnNewMenu.add(mntmSalir);
		
		JMenu mnGenerarCuenta = new JMenu("Generar Cuenta");
		menuBar.add(mnGenerarCuenta);
		
		JMenuItem mntmTeAmoMongola = new JMenuItem("Generar cuenta temporal");
		mntmTeAmoMongola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerarCuenta generarCuenta = new GenerarCuenta();
				Main.centralizar(generarCuenta.frame);
				generarCuenta.frame.setVisible(true);
			}
		});
		mnGenerarCuenta.add(mntmTeAmoMongola);
		
		JMenu mnNewMenu_1 = new JMenu("Importar Datos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmImportarDatos = new JMenuItem("Importar Participantes");
		mntmImportarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImportarParticipantes importarParticipantes = new ImportarParticipantes(model);
				
			}
		});
		mnNewMenu_1.add(mntmImportarDatos);
		
		JMenuItem mntmImportarHistorial = new JMenuItem("Importar Historial");
		mntmImportarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImportarHistorial importarHistorial = new ImportarHistorial();
			}
		});
		mnNewMenu_1.add(mntmImportarHistorial);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerManual = new JMenuItem("Ver manual");

		mntmVerManual.addActionListener(new ActionListener() {			
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
		mnAyuda.add(mntmVerManual);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		
		JMenuItem mntmInformacinDelSoftware = new JMenuItem("Informaci\u00F3n del software");
		mntmInformacinDelSoftware.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acerca acerca = new Acerca();
				acerca.frame.setVisible(true);
				Main.centralizar(acerca.frame);
			}
		});
		mnAcercaDe.add(mntmInformacinDelSoftware);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 249, 173));
		panel.setBounds(23, 12, 751, 115);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Buscar Participantes", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 249, 173));
		panel_1.setBounds(23, 171, 751, 370);
		panel_1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Resultados", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable(new DefaultTableModel(new Object[]{"DNI", "Nombre", "Apellido", "Funcion", "Participante", "Estado", "Perfil"}, 0))  {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable (int fila, int columna) {
				if (columna == 0 || columna == 1 || columna == 2 || columna == 3 || columna == 4)
					return false;
				else
					return true;
			}
		
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				default:
					return Boolean.class;
				}
			}
		};
		
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.getColumnModel().getColumn(6).setMinWidth(50);
		

		model = (DefaultTableModel) table.getModel();
		conn = new Conexion();
		ArrayList<ParticipanteOut> participantes = conn.mostrar();
		
		for (int i = 0; i < participantes.size(); i++) {
			model.addRow(new Object[] {
					participantes.get(i).getDni_participante(),
					conn.refinar(participantes.get(i).getNombre_participante()),
					conn.refinar(participantes.get(i).getApellido_participante()),
					conn.refinar(participantes.get(i).getId_funcion()),
					conn.refinar(participantes.get(i).getId_tipo_participante()),
					Boolean.parseBoolean(participantes.get(i).isEstado_participante() + ""),
					"Ver"
					});
		}
		
		table.getModel().addTableModelListener(new TableModelListener() {
			@Override  
			public void tableChanged(TableModelEvent e) {
				if(e.getColumn() == 5 && e.getFirstRow() > -1){
					conn = new Conexion();
					conn.cambioEstadoParticipante (model.getValueAt(e.getFirstRow(), 0).toString() + "",
							Boolean.parseBoolean(model.getValueAt(e.getFirstRow(), 5).toString() + ""));
				}
			}
		});
		
		Action perfil = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf(e.getActionCommand());
		    	Conexion conn = new Conexion();
		    	ParticipanteOut participante = conn.perfil(
		    			((DefaultTableModel)table.getModel()).getValueAt(modelRow, 0) + "",
		    			((DefaultTableModel)table.getModel()).getValueAt(modelRow, 3) + "",
		    			((DefaultTableModel)table.getModel()).getValueAt(modelRow, 4) + "");
		    	if (participante.getId_tipo_participante().equals("DOCENTE")) {
		    		PerfilDocente perfildocente = new PerfilDocente();
		    		perfildocente.initialize(participante);
					Main.centralizar(perfildocente.frame);
					perfildocente.frame.setVisible(true);
		    	} else {
		    		PerfilAdministrativo perfiladministrativo = new PerfilAdministrativo();
			    	perfiladministrativo.initialize(participante);
					Main.centralizar(perfiladministrativo.frame);
					perfiladministrativo.frame.setVisible(true);
		    	}
		    }
		};
		
		ButtonColumn buttonColumn = new ButtonColumn(table, perfil, 6);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(12, 23, 727, 335);
		table.setBounds(10, 11, 321, 134);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setBounds(13, 23, 720, 335);
		panel_1.add(table);
		
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel);
		
		JLabel lblTipo = new JLabel("Tipo de Participantes");
		lblTipo.setBounds(12, 36, 259, 14);
		panel.add(lblTipo);
		
		JLabel lblNombres_1 = new JLabel("Apellidos :");
		lblNombres_1.setBounds(180, 71, 100, 14);
		panel.add(lblNombres_1);
		
		dnitextField = new JTextField();
		dnitextField.setBounds(450, 34, 100, 20);
		panel.add(dnitextField);
		dnitextField.setColumns(10);
		
		nombretextField = new JTextField();
		nombretextField.setBounds(90, 69, 75, 20);
		panel.add(nombretextField);
		nombretextField.setColumns(10);
		
		JLabel lblNombres = new JLabel("DNI :");
		lblNombres.setBounds(370, 29, 144, 28);
		panel.add(lblNombres);
		
		JComboBox comboBox_3 = new JComboBox(new String [] {""});
		comboBox_3.setForeground(new Color(77, 1, 33));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setEnabled(false);
		comboBox_3.setBounds(450, 68, 175, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox = new JComboBox(new String [] {"", "DOCENTE", "ADMINISTRATIVO"});
		comboBox.setForeground(new Color(77, 1, 33));
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("DOCENTE")) {
					comboBox_3.removeAllItems();
					comboBox_3.addItem("");
					comboBox_3.addItem("DIRECTORESCUELA");
					comboBox_3.addItem("DIRECTORDEPARTAMENTO");
					comboBox_3.addItem("DOCENTE");
					comboBox_3.addItem("JEFEPRACTICAS");
					comboBox_3.addItem("DECANO");
					comboBox_3.setEnabled(true);
				} else if (comboBox.getSelectedItem().equals("ADMINISTRATIVO")) {
					comboBox_3.removeAllItems();
					comboBox_3.addItem("");
					comboBox_3.addItem("CONSEJERO");
					comboBox_3.addItem("COORDINADOR");
					comboBox_3.addItem("SECRETARIA");
					comboBox_3.addItem("PORTERO");
					comboBox_3.addItem("CONSERJE");
					comboBox_3.addItem("BIBLIOTECARIO");
					comboBox_3.setEnabled(true);
				} else {
					comboBox_3.removeAllItems();
					comboBox_3.addItem("");
					comboBox_3.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(180, 33, 176, 20);
		panel.add(comboBox);
		
		JLabel lblFuncin = new JLabel("Función :");
		lblFuncin.setBounds(370, 64, 124, 28);
		panel.add(lblFuncin);
		
		JLabel lblNewLabel = new JLabel("Nombres :");
		lblNewLabel.setBounds(12, 69, 75, 15);
		panel.add(lblNewLabel);
		
		apellidotextField_2 = new JTextField();
		apellidotextField_2.setBounds(260, 69, 100, 19);
		panel.add(apellidotextField_2);
		apellidotextField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(77, 1, 33));
		btnNewButton.setBounds(342, 136, 110, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				
				conn = new Conexion();
				ArrayList<ParticipanteOut> participantes = conn.mostrar();
			
				for (int i = 0; i < participantes.size(); i++) {
					if (participantes.get(i).getDni_participante().indexOf(dnitextField.getText().toString().toUpperCase()) > -1 &&
							participantes.get(i).getNombre_participante().indexOf(nombretextField.getText().toString().toUpperCase()) > -1 &&
							participantes.get(i).getApellido_participante().indexOf(apellidotextField_2.getText().toString().toUpperCase()) > -1 &&
							participantes.get(i).getId_funcion().indexOf(comboBox_3.getSelectedItem().toString()) > -1
							) {
						if (comboBox.getSelectedItem().toString().equals("DOCENTE") &&
								participantes.get(i).getId_tipo_participante().equals("DOCENTE")) {
							model.addRow(new Object[] {
									participantes.get(i).getDni_participante(),
									conn.refinar(participantes.get(i).getNombre_participante()),
									conn.refinar(participantes.get(i).getApellido_participante()),
									conn.refinar(participantes.get(i).getId_funcion()),
									conn.refinar(participantes.get(i).getId_tipo_participante()),
									Boolean.parseBoolean(participantes.get(i).isEstado_participante() + ""),
									"Ver"
									});
						} else if (comboBox.getSelectedItem().toString().equals("ADMINISTRATIVO") &&
								participantes.get(i).getId_tipo_participante().equals("ADMINISTRATIVO")) {
							model.addRow(new Object[] {
									participantes.get(i).getDni_participante(),
									conn.refinar(participantes.get(i).getNombre_participante()),
									conn.refinar(participantes.get(i).getApellido_participante()),
									conn.refinar(participantes.get(i).getId_funcion()),
									conn.refinar(participantes.get(i).getId_tipo_participante()),
									Boolean.parseBoolean(participantes.get(i).isEstado_participante() + ""),
									"Ver"
									});
						} else if (comboBox.getSelectedItem().toString().equals("")) {
							model.addRow(new Object[] {
									participantes.get(i).getDni_participante(),
									conn.refinar(participantes.get(i).getNombre_participante()),
									conn.refinar(participantes.get(i).getApellido_participante()),
									conn.refinar(participantes.get(i).getId_funcion()),
									conn.refinar(participantes.get(i).getId_tipo_participante()),
									Boolean.parseBoolean(participantes.get(i).isEstado_participante() + ""),
									"Ver"
									});
						}
					}
				}
			}
		});
		
	}
}