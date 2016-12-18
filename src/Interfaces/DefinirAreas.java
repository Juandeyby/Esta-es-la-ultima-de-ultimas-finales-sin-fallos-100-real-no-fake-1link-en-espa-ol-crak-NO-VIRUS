package Interfaces;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Controladores.Conexion;
import Controladores.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Clases.ParticipanteBuscar;
import Clases.ParticipanteOut;

import javax.swing.SpinnerNumberModel;

public class DefinirAreas  {

	private JPanel contentPane,panel;
	private JLabel lblGeografia,lblFilosofia,lblPsicologia, lblMatematica,lblRazonamientoVerbal,lblRazonamientoLogico,
	lblArea,lblQuimica, lblBiologiaYAmbiente,lblFisica,lblLenguaje,lblLiteratura,lblHistoria,lblCantidad, label, label_1;
	private int cantidadAreasTemp = 0;

	/**
	 * Launch the application.
	 */JFrame frame;
	 private JSpinner spinner1,spinner2, spinner3,spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11;
	 private JSpinner spinner12;
	 private JLabel lblNewLabel;
	 public static void main(String[] args) {
		 DefinirAreas frame = new DefinirAreas(50);
		 frame.frame.setVisible(true);
	 }

	 /**
	  * Create the frame.
	  */
	 public DefinirAreas(int cantidadAreas) {
		 frame = new JFrame();
		 frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 frame.setBounds(100, 100, 472, 339);
		 contentPane = new JPanel();
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 contentPane.setLayout(new BorderLayout(0, 0));
		 frame.setContentPane(contentPane);

		 panel = new JPanel();
		 panel.setBounds(32, 61, 458, 140);
		 panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		 frame.getContentPane().add(panel);

		 panel.setBorder(BorderFactory.createTitledBorder(
				 BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),
				 "Seleccionar areas:", TitledBorder.LEFT, TitledBorder.TOP));
		 frame.getContentPane().add(panel);
		 panel.setLayout(null);
		 panel.setLayout(null);

		 lblArea = new JLabel("Area");
		 lblArea.setBounds(23, 25, 46, 14);
		 panel.add(lblArea);

		 lblCantidad = new JLabel("Cantidad");
		 lblCantidad.setBounds(158, 25, 57, 14);
		 panel.add(lblCantidad);

		 label = new JLabel("Area");
		 label.setBounds(230, 25, 100, 14);
		 panel.add(label);

		 label_1 = new JLabel("Cantidad");
		 label_1.setBounds(374, 25, 57, 14);
		 panel.add(label_1);

		 lblQuimica = new JLabel("Quimica");
		 lblQuimica.setBounds(23, 50, 100, 14);
		 panel.add(lblQuimica);

		 lblBiologiaYAmbiente = new JLabel("Biologia y Ambiente");
		 lblBiologiaYAmbiente.setBounds(23, 80, 120, 14);
		 panel.add(lblBiologiaYAmbiente);

		 lblFisica = new JLabel("Fisica");
		 lblFisica.setBounds(23, 110, 100, 14);
		 panel.add(lblFisica);

		 lblLenguaje = new JLabel("Lenguaje");
		 lblLenguaje.setBounds(23, 140, 100, 14);
		 panel.add(lblLenguaje);

		 lblLiteratura = new JLabel("Literatura");
		 lblLiteratura.setBounds(23, 170, 100, 14);
		 panel.add(lblLiteratura);

		 lblHistoria = new JLabel("Historia");
		 lblHistoria.setBounds(23, 200, 100, 14);
		 panel.add(lblHistoria);

		 lblGeografia = new JLabel("Geografia");
		 lblGeografia.setBounds(230, 50, 100, 14);
		 panel.add(lblGeografia);

		 lblFilosofia = new JLabel("Filosofia");
		 lblFilosofia.setBounds(230, 80, 100, 14);
		 panel.add(lblFilosofia);

		 lblPsicologia = new JLabel("Psicologia");
		 lblPsicologia.setBounds(230, 110, 100, 14);
		 panel.add(lblPsicologia);

		 lblMatematica = new JLabel("Matematica");
		 lblMatematica.setBounds(230, 140, 100, 14);
		 panel.add(lblMatematica);

		 lblRazonamientoVerbal = new JLabel("Razonamiento Verbal");
		 lblRazonamientoVerbal.setBounds(230, 170, 150, 14);
		 panel.add(lblRazonamientoVerbal);

		 lblRazonamientoLogico = new JLabel("Razonamiento Logico");
		 lblRazonamientoLogico.setBounds(230, 200, 150, 14);
		 panel.add(lblRazonamientoLogico);

		 
		 ChangeListener listener = new ChangeListener() {
			 public void stateChanged(ChangeEvent e) {
				 cantidadAreasTemp = Integer.parseInt(spinner1.getValue().toString())
						 + Integer.parseInt(spinner2.getValue().toString())
						 + Integer.parseInt(spinner3.getValue().toString())
						 + Integer.parseInt(spinner4.getValue().toString())
						 + Integer.parseInt(spinner5.getValue().toString())
						 + Integer.parseInt(spinner6.getValue().toString())
						 + Integer.parseInt(spinner7.getValue().toString())
						 + Integer.parseInt(spinner8.getValue().toString())
						 + Integer.parseInt(spinner9.getValue().toString())
						 + Integer.parseInt(spinner10.getValue().toString())
						 + Integer.parseInt(spinner11.getValue().toString())
						 + Integer.parseInt(spinner12.getValue().toString())
						 ;
				 lblNewLabel.setText("Faltan : " + (cantidadAreas - cantidadAreasTemp));
			 }
		 };
		 
		 spinner1 = new JSpinner();
		 spinner1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner1.addChangeListener(listener);
		 spinner1.setBounds(151, 47, 46, 20);
		 panel.add(spinner1);

		 spinner2 = new JSpinner();
		 spinner2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner2.addChangeListener(listener);
		 spinner2.setBounds(151, 77, 46, 20);
		 panel.add(spinner2);

		 spinner3 = new JSpinner();
		 spinner3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner3.addChangeListener(listener);
		 spinner3.setBounds(151, 107, 46, 20);
		 panel.add(spinner3);

		 spinner4 = new JSpinner();
		 spinner4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner4.addChangeListener(listener);
		 spinner4.setBounds(151, 137, 46, 20);
		 panel.add(spinner4);

		 spinner5 = new JSpinner();
		 spinner5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner5.addChangeListener(listener);
		 spinner5.setBounds(151, 167, 46, 20);
		 panel.add(spinner5);

		 spinner6 = new JSpinner();
		 spinner6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner6.addChangeListener(listener);
		 spinner6.setBounds(151, 197, 46, 20);
		 panel.add(spinner6);

		 spinner7 = new JSpinner();
		 spinner7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner7.addChangeListener(listener);
		 spinner7.setBounds(373, 50, 46, 20);
		 panel.add(spinner7);

		 spinner8 = new JSpinner();
		 spinner8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner8.addChangeListener(listener);
		 spinner8.setBounds(373, 80, 46, 20);
		 panel.add(spinner8);

		 spinner9 = new JSpinner();
		 spinner9.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner9.addChangeListener(listener);
		 spinner9.setBounds(373, 110, 46, 20);
		 panel.add(spinner9);

		 spinner10 = new JSpinner();
		 spinner10.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner10.addChangeListener(listener);
		 spinner10.setBounds(373, 140, 46, 20);
		 panel.add(spinner10);

		 spinner11 = new JSpinner();
		 spinner11.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner11.addChangeListener(listener);
		 spinner11.setBounds(373, 170, 46, 20);
		 panel.add(spinner11);

		 spinner12 = new JSpinner();
		 spinner12.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		 spinner12.addChangeListener(listener);
		 spinner12.setBounds(373, 200, 46, 20);
		 panel.add(spinner12);
		 
		 lblNewLabel = new JLabel("Faltan :" + (cantidadAreas - cantidadAreasTemp));
		 lblNewLabel.setForeground(Color.RED);
		 lblNewLabel.setBounds(23, 230, 175, 15);
		 panel.add(lblNewLabel);
		 
		 
		 JButton btnContinuar = new JButton("Continuar");
		 btnContinuar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 for (int i = 1; i <= 12; i++)
					 cantidadAreasTemp += Integer.parseInt(spinner11.getValue().toString());
				 if (cantidadAreasTemp == cantidadAreas) {
					 
					 ArrayList<ArrayList<Object>> areas = new ArrayList<ArrayList<Object>>();
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(0).add("QUIMICA");
					 areas.get(0).add(Integer.parseInt(spinner1.getValue().toString()));
					 areas.get(0).add(0);
					 areas.get(0).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(1).add("BIOLOGIA");
					 areas.get(1).add(Integer.parseInt(spinner2.getValue().toString()));
					 areas.get(1).add(0);
					 areas.get(1).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(2).add("FISICA");
					 areas.get(2).add(Integer.parseInt(spinner3.getValue().toString()));
					 areas.get(2).add(0);
					 areas.get(2).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(3).add("LENGUAJE");
					 areas.get(3).add(Integer.parseInt(spinner4.getValue().toString()));
					 areas.get(3).add(0);
					 areas.get(3).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(4).add("LITERATURA");
					 areas.get(4).add(Integer.parseInt(spinner5.getValue().toString()));
					 areas.get(4).add(0);
					 areas.get(4).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(5).add("HISTORIA");
					 areas.get(5).add(Integer.parseInt(spinner6.getValue().toString()));
					 areas.get(5).add(0);
					 areas.get(5).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(6).add("GEOGRAFIA");
					 areas.get(6).add(Integer.parseInt(spinner7.getValue().toString()));
					 areas.get(6).add(0);
					 areas.get(6).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(7).add("FILOSOFIA");
					 areas.get(7).add(Integer.parseInt(spinner8.getValue().toString()));
					 areas.get(7).add(0);
					 areas.get(7).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(8).add("PSICOLOGIA");
					 areas.get(8).add(Integer.parseInt(spinner9.getValue().toString()));
					 areas.get(8).add(0);
					 areas.get(8).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(9).add("MATEMATICA");
					 areas.get(9).add(Integer.parseInt(spinner10.getValue().toString()));
					 areas.get(9).add(0);
					 areas.get(9).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(10).add("RAZVERBAL");
					 areas.get(10).add(Integer.parseInt(spinner11.getValue().toString()));
					 areas.get(10).add(0);
					 areas.get(10).add(new Color(77, 1, 33));
					 
					 areas.add(new ArrayList<Object>());
					 areas.get(11).add("RAZMATEMATICO");
					 areas.get(11).add(Integer.parseInt(spinner12.getValue().toString()));
					 areas.get(11).add(0);
					 areas.get(11).add(new Color(77, 1, 33));
					 
					 List<ParticipanteBuscar> participantesBuscar = new ArrayList<ParticipanteBuscar>();
					 Conexion conn = new Conexion();
					 ArrayList<ParticipanteOut> participantesTemp = conn.mostrar();
					 for (int i = 0; i < participantesTemp.size(); i++) {
				 		 participantesBuscar.add(new ParticipanteBuscar(participantesTemp.get(i), true));
					 }
					 SeleccionEspecificaFormuladores seleccionEspecificaFormuladores = new SeleccionEspecificaFormuladores(participantesBuscar, areas);
					 seleccionEspecificaFormuladores.frame.setVisible(true);
					 Main.centralizar(seleccionEspecificaFormuladores.frame);
					 frame.dispose();
				 } else if ((cantidadAreasTemp > cantidadAreas)) {
					 JOptionPane.showMessageDialog(null, "Cantidad Excedida");
				 } else {
					 JOptionPane.showMessageDialog(null, "Complete Cantidad, Faltan : " + (cantidadAreas - cantidadAreasTemp));
				 }
			 }
		 });
		 btnContinuar.setBounds(250, 242, 125, 23);
		 panel.add(btnContinuar);
	 }
}