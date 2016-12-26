package Interfaces;

import java.awt.EventQueue;

import java.util.*;


import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Clases.ParticipanteOut;
import Clases.ParticipantePDF;
import Controladores.Conexion;
import Controladores.Main;

import javax.swing.JTextArea;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public static String username = "unsadmision@gmail.com";
	public static String password = "unsadmision123";
	String mensaje="";
	String to="";	
	String Subject="";
	JProgressBar progressBar;
	ArrayList<String> lista;
	JTextArea textArea;
	int i;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		Window window = new Window();
//	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	public void SendMail1() {
		Properties props = new Properties();
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

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(mensaje);

			Transport.send(message);
			//JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
			System.out.println("3233");	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public void SendMail2() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(mensaje);

			Transport.send(message);
			//JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
			System.out.println("3233");	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void SendMail3() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.outlook.com");

		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(mensaje);

			Transport.send(message);
			//JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
			System.out.println("3233");	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void SendMail4() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.yahoo.com");

		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(mensaje);

			Transport.send(message);
			//JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
			System.out.println("3233");	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public void SendMail5() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.unsa.edu.pe");

		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(mensaje);

			Transport.send(message);
			//JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
			System.out.println("3233");	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void SendMail6() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.unsa.edu.pe");

		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(mensaje);

			Transport.send(message);
			//JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
			System.out.println("3233");	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//public static String Username;
		Conexion conn = new Conexion();
		ArrayList<ParticipantePDF> participantes = conn.mostrarNuevo(0);
		lista = new ArrayList<String>();
		
		for (int i = 0; i < participantes.size(); i++) {
			ParticipanteOut participantesTemp = conn.mostrarParticipante(participantes.get(i).getDni_paarticipante());
			if (!participantesTemp.getCorreo_participante().equals("null"))
				lista.add(participantesTemp.getCorreo_participante());
			if (!participantesTemp.getCorreo_institucional_participante().equals("null"))
				lista.add(participantesTemp.getCorreo_institucional_participante());
		}
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 428, 266);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		
		JLabel lblAsunto = new JLabel("Mensaje");
		lblAsunto.setBounds(12, 38, 66, 14);
		panel.add(lblAsunto);

		JLabel lblNewLabel = new JLabel("Asunto");
		lblNewLabel.setBounds(12, 12, 66, 14);
		panel.add(lblNewLabel);


		textField_1 = new JTextField("Proceso de Admisión");
		textField_1.setColumns(10);
		textField_1.setBounds(96, 10, 320, 20);
		panel.add(textField_1);

		textArea = new JTextArea("Buenos Días Señor(a)\n\n"
				+ "Usted fue elegido para participar en el \n"
				+ "proceso de Admisión de la Unsa.\n\nSaludos\n"
				+ "Comité de Admisión\n"
				+ "Universidad Nacional de San Agustín\nArequipa - Perú");
		textArea.setBounds(96, 42, 320, 153);
		panel.add(textArea);
		

		JButton btnCanerlar = new JButton("Cancelar");
		btnCanerlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCanerlar.setBounds(148, 206, 120, 23);
		panel.add(btnCanerlar);

		JButton btnLimpiarcampos = new JButton("Limpiar");
		btnLimpiarcampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textArea.setText("");
			}
		});

		btnLimpiarcampos.setBounds(280, 206, 136, 23);
		panel.add(btnLimpiarcampos);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(12, 206, 124, 23);
		panel.add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "¿Seguro que Desea Enviar Mensajes?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if(i == 0){
					new Thread(new Hilo()).start();
				}
			}
		});
	}
	
	private class Hilo implements Runnable {
		@Override
		public void run() {
			JFrame frameEmergente = new JFrame("Enviando");
			frameEmergente.setBounds(100, 100, 281, 60);
			frameEmergente.getContentPane().setLayout(null);
			
			progressBar = new JProgressBar(0, lista.size());
			progressBar.setStringPainted(true);
			progressBar.setBounds(12, 12, 257, 28);
			progressBar.setValue(0);
			
			frameEmergente.getContentPane().add(progressBar);
			Main.centralizar(frameEmergente);
			frameEmergente.setVisible(true);
			
			for (i = 0; i < lista.size(); i++) {
				progressBar.setString("Enviando a " + lista.get(i));
				progressBar.setValue(i);
				String p=lista.get(i);
				to=p;;
				String[]parts=p.split("@");
				System.out.println(parts[0]);
				String part1=parts[0];
				String part2=parts[1];
				System.out.println(part2);

				mensaje = textArea.getText();
				Subject = textField_1.getText();

				if(part2.equals('h')){
					SendMail2();
				}
				else{
					if(part2.equals('o')){
						SendMail3();
					}
					else{
						if(part2.equals('y')){
							SendMail4();
						}
						else{
							if(part2.equals('u')){
								SendMail5();
							}
							else
								SendMail1();
						}	
					}
				}
			}
			frameEmergente.dispose();
			JOptionPane.showMessageDialog(null, "Exito Al Enviar Mensajes");
			frame.dispose();
		}
	}

}
