package Controladores;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import Interfaces.Login;

public class Main {
	
	public static void main(String[] args) {
		Conexion conn = new Conexion();
//		conn.nuevo();
		Login login = new Login();
		centralizar(login.frmExaminV);
		login.frmExaminV.setVisible(true);
	}

	public static void centralizar (JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
}