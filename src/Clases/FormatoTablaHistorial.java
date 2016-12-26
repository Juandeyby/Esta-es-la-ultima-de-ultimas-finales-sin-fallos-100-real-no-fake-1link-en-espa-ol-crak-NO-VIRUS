package Clases;

import java.awt.Color;

import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTablaHistorial extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
	
	List<HistorialOut> historial;
	JPopupMenu menu;
	
	public FormatoTablaHistorial(List<HistorialOut> participantesBuscar) {
		this.historial = participantesBuscar;
		menu = new JPopupMenu();
	}
	
	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
//		for (int i = 0; i < historial.size(); i++) {
//			if (table.getValueAt(row, 5).equals(historial.get(i).getObservacion_historial_proceso())) {
//				
//			}
//		}
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	menu = new JPopupMenu();
		        menu.add(new JLabel("Esta es una prueba con JPopupMenu"));
		        menu.setVisible(true);
                menu.setBounds(0, 0, 100, 50);
                menu.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
		    }
		});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	menu.setVisible(false);
		    }
		});
		
//		//Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
//		if( table.getValueAt(row, 0).equals(false) ) {
//			setBackground(Color.red);
//		}
		
		super.getTableCellRendererComponent(table, value, selected, focused, row, column);
		return this;
	}
}