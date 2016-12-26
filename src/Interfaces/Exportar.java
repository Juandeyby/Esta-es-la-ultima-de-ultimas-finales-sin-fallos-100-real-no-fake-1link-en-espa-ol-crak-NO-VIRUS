package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import Controladores.ExportarPDF;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.SystemColor;


public class Exportar {

	public JFrame frame;

	private JPanel contentPane,panel;
	private JButton btn_exportar;
	private JTextField txt_ruta;
	private JCheckBox chckbxSleccionarTodo;
	private JLabel lblOpciones; 
	private JRadioButton radio_tbn_tecnicos,radio_btn_formuladores, radio_btn_controladores,radio_btn_contadores,
	radio_btn_porteros,radio_btn_verificadores,radio_btn_conserjes;

	ExportarPDF a = new ExportarPDF();

	public Exportar() {

		frame = new JFrame();
		frame.setTitle("Exportar");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 522, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);

		lblOpciones = new JLabel("Opciones");
		lblOpciones.setBounds(12, 13, 137, 15);



		chckbxSleccionarTodo = new JCheckBox("Seleccionar todo");
		chckbxSleccionarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxSleccionarTodo.isSelected() == true){
					radio_btn_formuladores.setEnabled(false);
					radio_tbn_tecnicos.setEnabled(false);
					radio_btn_controladores.setEnabled(false);
					radio_btn_contadores.setEnabled(false);
					radio_btn_conserjes.setEnabled(false);
					radio_btn_porteros.setEnabled(false);
					radio_btn_verificadores.setEnabled(false);
				} else {
					radio_btn_formuladores.setEnabled(true);
					radio_tbn_tecnicos.setEnabled(true);
					radio_btn_controladores.setEnabled(true);
					radio_btn_contadores.setEnabled(true);
					radio_btn_conserjes.setEnabled(true);
					radio_btn_porteros.setEnabled(true);
					radio_btn_verificadores.setEnabled(true);
				}
			}
		});
		chckbxSleccionarTodo.setBounds(12, 35, 195, 23);
		contentPane.setLayout(null);


		panel = new JPanel();
		panel.setBounds(12, 61, 498, 163);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel);

		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				"Seleccionar categoria", TitledBorder.LEFT, TitledBorder.TOP));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setLayout(null);

		radio_btn_formuladores = new JRadioButton("Formuladores");
		radio_btn_formuladores.setBounds(20, 30, 149, 23);
		panel.add(radio_btn_formuladores);

		radio_tbn_tecnicos = new JRadioButton("Tecnicos");
		radio_tbn_tecnicos.setBounds(20, 60, 201, 23);
		panel.add(radio_tbn_tecnicos);

		radio_btn_controladores = new JRadioButton("Controladores");
		radio_btn_controladores.setBounds(20, 90, 201, 23);
		panel.add(radio_btn_controladores);

		radio_btn_contadores = new JRadioButton("Contadores");
		radio_btn_contadores.setBounds(225, 30, 265, 23);
		panel.add(radio_btn_contadores);

		radio_btn_conserjes = new JRadioButton("Conserjes");
		radio_btn_conserjes.setBounds(225, 60, 265, 23);
		panel.add(radio_btn_conserjes);

		radio_btn_porteros = new JRadioButton("Porteros");
		radio_btn_porteros.setBounds(225, 90, 265, 23);
		panel.add(radio_btn_porteros);

		radio_btn_verificadores = new JRadioButton("Verificadores");
		radio_btn_verificadores.setBounds(225, 120, 265, 23);
		panel.add(radio_btn_verificadores);


		ButtonGroup g=new ButtonGroup();
		g.add(radio_btn_formuladores);
		g.add(radio_btn_conserjes);
		g.add(radio_btn_contadores);
		g.add(radio_btn_verificadores);
		g.add(radio_btn_porteros);
		g.add(radio_tbn_tecnicos);
		g.add(radio_btn_controladores);


		btn_exportar = new JButton("Exportar");
		btn_exportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxSleccionarTodo.isSelected()==true){	
					enviarDatos(0);
				}
				else if(radio_btn_formuladores.isSelected()==true){
					enviarDatos(1);
				}
				else if(radio_tbn_tecnicos.isSelected()==true){
					enviarDatos(2);
				}
				else if(radio_btn_controladores.isSelected()==true){
					enviarDatos(3);
				}
				else if(radio_btn_contadores.isSelected()==true){
					enviarDatos(4);
				}
				else if(radio_btn_conserjes.isSelected()==true){
					enviarDatos(5);
				}
				else if(radio_btn_porteros.isSelected()==true){
					enviarDatos(6);
				}
				else if(radio_btn_verificadores.isSelected()==true){
					enviarDatos(7);
				}
			}

		});
		btn_exportar.setBounds(187, 236, 117, 25);
		contentPane.add(lblOpciones);
		contentPane.add(chckbxSleccionarTodo);
		contentPane.add(btn_exportar);

		txt_ruta = new JTextField();
		txt_ruta.setForeground(SystemColor.window);
		txt_ruta.setEditable(false);
		txt_ruta.setEnabled(false);
		txt_ruta.setBounds(167, 10, 343, 20);
		contentPane.add(txt_ruta);
		txt_ruta.setColumns(10);
	}
	public void enviarDatos(int cod){
		JFileChooser dlg= new JFileChooser();
		int option=dlg.showSaveDialog(dlg);
		if(option==JFileChooser.APPROVE_OPTION){
			File f=dlg.getSelectedFile();
			txt_ruta.setText(f.toString());
		}
		String ruta = txt_ruta.getText();

		try {
			FileOutputStream archivo=new FileOutputStream(ruta + ".pdf");
			Document doc=new Document();

			PdfWriter.getInstance(doc, archivo).setInitialLeading(20);
			doc.open();
			a.crearPDF(archivo,doc,cod);

			JOptionPane.showMessageDialog(null, "pdf creado correctamente");
			doc.close();
			archivo.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error"+e);
		}
	}
}