package Interfaces;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Clases.FormatoTablaFormuladores;
import Clases.FormatoTablaHistorial;
import Clases.HistorialOut;
import Clases.ParticipanteOut;
import Controladores.Actualizar;
import Controladores.Conexion;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JTable;

public class PerfilAdministrativo {

	public JFrame frame;
	JPopupMenu menu = new JPopupMenu();

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(ParticipanteOut participante) {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 597);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 249, 173));
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Perfil Administrativo", TitledBorder.LEFT, TitledBorder.TOP));
		panel.setBounds(12, 12, 454, 355);
		frame.getContentPane().add(panel);
		frame.setTitle("Perfil Administrativo");
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("DNI");
		lblUsuario.setBounds(110, 34, 135, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Nombres");
		lblContrasea.setBounds(110, 62, 135, 14);
		panel.add(lblContrasea);
		
		JLabel lblPreguntaSecreta = new JLabel("Telefono");
		lblPreguntaSecreta.setBounds(110, 118, 135, 14);
		panel.add(lblPreguntaSecreta);
		
		JLabel lblNewLabel = new JLabel("Imagen Docente");
		lblNewLabel.setBounds(15, 40, 85, 111);
		panel.add(lblNewLabel);
				
		ImageIcon persona = new ImageIcon("./Imagenes/administrador.png");
        ImageIcon icono1 = new ImageIcon(persona.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(icono1);
        
        JLabel lblConfirmarContrasea = new JLabel("Apellidos");
        lblConfirmarContrasea.setBounds(110, 90, 74, 14);
        panel.add(lblConfirmarContrasea);
        
        JLabel lblRespuesta = new JLabel("Telefono de Oficina");
        lblRespuesta.setBounds(110, 146, 135, 14);
        panel.add(lblRespuesta);
        
        JLabel lblCelular = new JLabel("Celular");
        lblCelular.setBounds(110, 171, 135, 14);
        panel.add(lblCelular);
        
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(110, 196, 135, 14);
        panel.add(lblCorreo);
        
        JLabel lblCorreoInstitucional = new JLabel("Correo Institucional");
        lblCorreoInstitucional.setBounds(110, 221, 135, 14);
        panel.add(lblCorreoInstitucional);
        
        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setBounds(110, 246, 135, 14);
        panel.add(lblDireccion);
        
        JLabel lblFacultad = new JLabel("Función");
        lblFacultad.setBounds(110, 271, 135, 14);
        panel.add(lblFacultad);    
        
        JLabel lblNewLabel_1 = new JLabel(participante.getDni_participante());
        lblNewLabel_1.setBounds(270, 34, 172, 14);
        panel.add(lblNewLabel_1);
        
        JLabel label_1 = new JLabel(participante.getNombre_participante());
        label_1.setBounds(270, 62, 172, 14);
        panel.add(label_1);
        
        JLabel label_2 = new JLabel(participante.getApellido_participante());
        label_2.setBounds(270, 88, 172, 14);
        panel.add(label_2);
        
        JLabel label_3 = new JLabel(participante.getTelefono_participante());
        label_3.setBounds(270, 118, 172, 14);
        panel.add(label_3);
        
        JLabel label_4 = new JLabel(participante.getTelefono_oficina_participante()+"");
        label_4.setBounds(270, 146, 172, 14);
        panel.add(label_4);
        
        JLabel label_5 = new JLabel(participante.getCelular_participante()+"");
        label_5.setBounds(270, 171, 172, 14);
        panel.add(label_5);
        
        JLabel label_6 = new JLabel(participante.getCorreo_participante());
        label_6.setBounds(270, 196, 172, 14);
        panel.add(label_6);
        
        JLabel label_7 = new JLabel(participante.getCorreo_institucional_participante());
        label_7.setBounds(270, 221, 172, 14);
        panel.add(label_7);
        
        JLabel label_8 = new JLabel(participante.getDireccion_participante());
        label_8.setBounds(270, 246, 172, 14);
        panel.add(label_8);
        
        JLabel label_9 = new JLabel(participante.getId_funcion());
        label_9.setBounds(270, 271, 172, 14);
        panel.add(label_9);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(BorderFactory.createTitledBorder(
        				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),

        				"Historial", TitledBorder.LEFT, TitledBorder.TOP));
        panel_1.setBackground(new Color(255, 249, 173));
        panel_1.setBounds(12, 373, 454, 188);
        frame.getContentPane().add(panel_1);
        
        
        JTable table = new JTable(new DefaultTableModel(new Object[]{"TIPO", "FASE", "AÑO", "CARGO", "EXP", "OBS"}, 0))  {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable (int fila, int columna) {
				if (columna == 0 || columna == 1 || columna == 2 || columna == 3 || columna == 4 || columna == 5)
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
					return String.class;
				}
			}
		};
		
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(35);
		table.getColumnModel().getColumn(2).setMinWidth(35);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setMinWidth(35);
		table.getColumnModel().getColumn(5).setMinWidth(60);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Conexion conn = new Conexion();
		List<HistorialOut> historial_proceso = conn.mostrarHistorial(participante.getDni_participante());
		
//		FormatoTablaHistorial formatoTablaHistorial = new FormatoTablaHistorial(historial_proceso);
//		table.setDefaultRenderer(Object.class, formatoTablaHistorial);
		
		for (int i = 0; i < historial_proceso.size(); i++) {
			model.addRow(new Object[] {
					historial_proceso.get(i).getId_tipo_proceso(),
					historial_proceso.get(i).getId_fase_proceso(),
					historial_proceso.get(i).getAnio_proceso(),
					historial_proceso.get(i).getId_cargo_proceso(),
					historial_proceso.get(i).getExperiencia_historial_proceso(),
					historial_proceso.get(i).getObservacion_historial_proceso()
					});
		}
		
		table.addMouseListener(new PopClickListener());
		
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 21, 314, 156);
        panel_1.add(scrollPane);
        
        JLabel label = new JLabel("Grafico");
        label.setBounds(342, 22, 100, 100);
        panel_1.add(label);
        
        ImageIcon grafico = new ImageIcon("./Imagenes/grafico.png");
        ImageIcon icono2 = new ImageIcon(grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono2);
        
        JButton button = new JButton("Ver Grafico");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.setBounds(330, 134, 112, 23);
        panel_1.add(button);
	}
	
	class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    public void mouseReleased(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e){
	        PopUpDemo menu = new PopUpDemo(e);
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
	
	class PopUpDemo extends JPopupMenu {
	    JMenuItem anItem;
	    public PopUpDemo(MouseEvent e){
	    	JTable target = (JTable) e.getSource();
			int row = target.getSelectedRow();
		    int column = target.getSelectedColumn();
		    if (row > -1 && column  > -1) {
		    	anItem = new JMenuItem(target.getValueAt(row, column).toString());
		    	add(anItem);
		    }
	    }
	}
}


