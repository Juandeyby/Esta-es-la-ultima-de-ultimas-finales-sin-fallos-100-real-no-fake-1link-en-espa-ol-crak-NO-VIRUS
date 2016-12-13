package Controladores;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import Clases.Usuario;

public class Actualizar {
	public int estado=-2;

	public Actualizar(String uno, String dos,String tres,String cuatro,String cinco) throws SQLException{
		Connection conn = null;

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Statement sta = conn.createStatement();
		Conexion p = new Conexion();
		Usuario user = p.consulta("admin");
		if(uno.equals(user.getContrasenia_usuario())){
			estado=2;
			System.out.println("---------------------");
			if(dos.equals(tres)){
				if(!cuatro.equals("") && !cinco.equals("")){
					if(dos.equals("")){
						estado=5;}
					else{
						String sentece = "UPDATE usuario SET contrasenia_usuario = '" + dos + "',"+"pregunta_secreta_usuario = '" + cuatro + "',"
								+"respuesta_pregunta_secreta_usuario = '" + cinco + "'"
								+ " WHERE id_usuario = 1";
						estado=sta.executeUpdate(sentece);
					}
				}
			}
		}
	}


}
