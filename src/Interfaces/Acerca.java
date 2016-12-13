package Interfaces;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Acerca {

	public JFrame frame;

	public Acerca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Acerca de EXAMIN");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnElSoftwareexamin = new JTextPane();
		txtpnElSoftwareexamin.setEditable(false);
		txtpnElSoftwareexamin.setText("El software \"Examin\" fue desarrollado por los alumnos de la\r\nEscuela Profesional de Ingenieria de Sistemas:\r\n\r\nDesarrolladores\r\n- Carlos Chullo, Juan Deyby\r\n- Farfan Choquehuanca, Maria Elisabeth\r\n- Flores Torres, Lourdes Alexsandra\r\n- Gallegos Valdivia, Juan Jose\r\n\r\nAnalistas\r\n- Brousset Lopez, Wendy Avelina\r\n- Huallpa Tapia, Luis David\r\n- Jimenez Gonzales, Luis Alberto\r\n- Vilca Chusi, Lisbet Nilda");
		txtpnElSoftwareexamin.setBounds(12, 12, 426, 276);
		frame.getContentPane().add(txtpnElSoftwareexamin);
	}
}
