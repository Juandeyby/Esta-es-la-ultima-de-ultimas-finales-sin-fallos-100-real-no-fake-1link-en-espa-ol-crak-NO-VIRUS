package Interfaces;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Manual {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manual window = new Manual();
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
	public Manual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 249, 173));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrSs = new JTextArea();
		txtrSs.setBackground(new Color(255, 249, 173));
		txtrSs.setEditable(false);
		txtrSs.setEnabled(false);;
		Font font = new Font("Arial", Font.CENTER_BASELINE, 12);
//		txtrSs.setFont(font);
		txtrSs.setText("Como animal de compañía,\n"
				+ "es una de las mascotas más populares\n"
				+ "en todo el mundo. Debido a que su\n"
				+ "domesticación es relativamente\n"
				+ "reciente, pueden vivir en ambientes\n"
				+ "silvestres formando pequeñas colonias\n"
				+ "relacionándose con otros gatos monteses\n"
				+ "y los seres humanos no controlan el\n"
				+ "suministro de alimentos o la cría.\n"
				+ "La asociación del gato con los humanos\n"
				+ "lo condujo a figurar prominentemente en\n"
				+ "la mitología y en leyendas de diferentes\n"
				+ "culturas, incluyendo a las civilizaciones\n"
				+ "egipcia, japonesa, china y escandinava.\n"
				+ "Se observa un efecto relativamente modesto de la domesticación en el genoma del gato basado en su reciente divergencia con los gatos monteses, la mezcla continua entre gatos domésticos y monteses, y las escasas diferencias morfológicas, siendo excepciones, las diferencias de comportamiento de los gatos monteses en relación con la docilidad, la gracilidad y la pigmentación. El efecto de la domesticación del gato parece ser modesto en comparación con otros mamíferos, debido principalmente a:\n\nLa historia reciente domesticación del gato.\nLa ausencia de una fuerte selección para las características físicas específicas a diferencia de muchos otros mamíferos domésticos criados para comida, el pastoreo, la caza o la seguridad, el gato se ha domesticado principalmente en el período antiguo porque es un depredador que ayudaba a mantener controlados los roedores que comían los granos[cita requerida] .\nEl aislamiento limitado de las poblaciones silvestres con los gatos domésticos.\nEl proceso de la domesticación postula que los rasgos morfológicos y fisiológicos modificados por la domesticación de los gatos se explican por las consecuencias directas e indirectas de los déficit de células de la cresta neural durante el desarrollo embrionario y propone que los cambios en estos genes de la cresta neural están relacionados con la docilidad. Esto sugiere que la selección para la docilidad, como resultado de acostumbrarse a los seres humanos para obtener recompensas de comida, es la principal fuerza que alteró los primeros genomas del gato doméstico.");
		txtrSs.setBounds(12, 12, 426, 243);
		
		JScrollPane sp = new JScrollPane(txtrSs);
		sp.setBounds(12, 12, 426, 243);
		frame.getContentPane().add(sp);
	}
}
