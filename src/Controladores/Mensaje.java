package Controladores;
import java.awt.Color;

import java.awt.EventQueue;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

import java.util.Properties;
import java.awt.event.ActionEvent;

public class Mensaje {

	public JFrame frame;
	public JTextArea textArea112;
	public JTextField textField;
	public JTextField textField_1;
	public JTextArea textArea;
	public static String username="examincs@gmail.com";
	public static String password="examincs12";
	String mensaje="";
	String to="";	
	String Subject="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mensaje window = new Mensaje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mensaje() {
		initialize();
		System.out.println(username+" "+password);
	}
	
	 public void SendMail() {
	        Properties props = new Properties();
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                        
	                    }
	                    
	                });
	      //  session.setDebug(true);
	        System.out.println(username+"f "+password);

	        try {
	        	
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(to));
//	            System.out.println("-----------------------");
	            System.out.println(Subject+"mira*************************");
	            System.out.println(mensaje);
	            message.setSubject(Subject);
	            message.setText(mensaje);
	                     
	            Transport.send(message);
	            //System.out.println(Transport.class+"[[[[[[[[");
	          
	            //JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
	            System.out.println("3233");	
	        } catch (MessagingException e) {
	            
	        }
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//public static String Username;




		frame = new JFrame();
		frame.setBounds(100, 100, 450, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 426, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPara = new JLabel("Para :");
		lblPara.setBounds(47, 41, 46, 14);
		panel.add(lblPara);

		JLabel lblAsunto = new JLabel("Mensaje :");
		lblAsunto.setBounds(47, 88, 89, 14);
		panel.add(lblAsunto);

		JLabel lblNewLabel = new JLabel("Asunto :");
		lblNewLabel.setBounds(47, 62, 89, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(162, 38, 158, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(162, 62, 158, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);

		JButton btnEnviar = new JButton("enviar");
		btnEnviar.setBounds(22, 243, 89, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje=textArea112.getText();
				Subject=textField_1.getText();
				to=textField.getText();
				SendMail();

			}

			
		});
		panel.add(btnEnviar);

		JButton btnCanerlar = new JButton("canerlar");
		btnCanerlar.setBounds(123, 243, 115, 23);
		panel.add(btnCanerlar);

		JButton btnLimpiarcampos = new JButton("limpiarcampos");
		btnLimpiarcampos.setBounds(250, 243, 143, 23);
		btnLimpiarcampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textField.setText("");
				textArea112.setText("");
				
			}
		});
		panel.add(btnLimpiarcampos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 12, 402, 211);
		panel_1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Enviar Email", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textArea112 = new JTextArea();
		textArea112.setBounds(36, 104, 339, 95);
		
		JScrollPane sp = new JScrollPane(textArea112);
		sp.setBounds(12, 103, 381, 96);
		panel_1.add(sp);
	}
}

