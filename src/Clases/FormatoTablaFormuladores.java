package Clases;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTablaFormuladores extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
	
	List<ParticipanteBuscar> participantesBuscar;
	
	public FormatoTablaFormuladores(List<ParticipanteBuscar> participantesBuscar) {
		this.participantesBuscar = participantesBuscar;
	}
	
	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		String patron = getDNI(table.getValueAt(row, 0).toString());
//		System.out.println(patron);
		
		switch (patron) {
		
		case "QUIMICA":
			setBackground(new Color(255, 198, 175));
//			table.setForeground(Color.black);
			break;
		case "BIOLOGIA":
			setBackground(new Color(255, 229, 175));
//			table.setForeground(Color.black);
			break;
		case "FISICA":
			setBackground(new Color(251, 255, 175));
//			table.setForeground(Color.black);
			break;
		case "LENGUAJE":
			setBackground(new Color(221, 255, 175));
//			table.setForeground(Color.black);
			break;
		case "LITERATURA":
			setBackground(new Color(175, 255, 229));
//			table.setForeground(Color.black);
			break;
		case "HISTORIA":
			setBackground(new Color(175, 226, 255));
//			table.setForeground(Color.black);
			break;
		case "GEOGRAFIA":
			setBackground(new Color(175, 190, 255));
//			table.setForeground(Color.black);
			break;
		case "FILOSOFIA":
			setBackground(new Color(213, 175, 255));
//			table.setForeground(Color.black);
			break;
		case "PSICOLOGIA":
			setBackground(new Color(249, 178, 255));
//			table.setForeground(Color.black);
			break;
		case "MATEMATICA":
			setBackground(new Color(255, 178, 215));
//			table.setForeground(Color.black);
			break;
		case "RAZVERBAL":
			setBackground(new Color(255, 178, 178));
//			table.setForeground(Color.black);
			break;
		case "RAZMATEMATICO":
			setBackground(new Color(192, 192, 192));
//			table.setForeground(Color.black);
			break;
			
		default:
			break;
		}
		
		
//		//Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
//		if( table.getValueAt(row, 0).equals(false) ) {
//			setBackground(Color.red);
//		}
		
		super.getTableCellRendererComponent(table, value, selected, focused, row, column);
		return this;
	}
	
	public String getDNI (String dni_participante) {
		for (int i = 0; i < participantesBuscar.size(); i++) {
			if (!participantesBuscar.get(i).isBuscar() &&
					participantesBuscar.get(i).getDni_participante().equals(dni_participante))
				return participantesBuscar.get(i).getId_especialidad();
		}
		return "";
	}
}