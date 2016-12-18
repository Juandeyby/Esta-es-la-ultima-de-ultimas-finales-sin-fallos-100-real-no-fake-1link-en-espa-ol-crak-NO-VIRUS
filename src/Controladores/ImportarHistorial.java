package Controladores;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import Clases.*;

public class ImportarHistorial {
	
	JProgressBar progressBar;
	ArrayList<Historial> historiales;
	public int i = 0;
	private BufferedReader br;

	private class Hilo implements Runnable {
		@Override
		public void run() {
			JFrame frame = new JFrame("Importando Historial");
			frame.setBounds(100, 100, 281, 60);
			frame.getContentPane().setLayout(null);
			
			progressBar = new JProgressBar(0, historiales.size()-1);
			progressBar.setStringPainted(true);
			progressBar.setBounds(12, 12, 257, 28);
			progressBar.setValue(0);
			
			frame.getContentPane().add(progressBar);
			Main.centralizar(frame);
			frame.setVisible(true);
			
			Conexion conn = new Conexion();
			for (i = 0; i < historiales.size(); i++) {
				progressBar.setValue(i);
				conn.insertarHistorial(historiales.get(i));
			}

			frame.dispose();
		}
	}
	
	public ImportarHistorial () {
		
		try {
			String line = "";
			JFileChooser file = new JFileChooser();
			
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.csv", "csv");
			file.setFileFilter(filtro);
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			file.showOpenDialog(file);
			
			File abre = file.getSelectedFile();
			line = abre.getName();
			
			historiales = new ArrayList<Historial>();
			
			if(abre != null) {
				br = new BufferedReader(new FileReader(abre));
				
				while ((line = br.readLine()) != null) {
					String [] registro = line.split(";");
					if(registro.length < 7)
						continue;
					Historial historialTemp = null;
					for (int i = 0; i < registro.length; i++) {
						historialTemp = new Historial(
								registro[0],
								Integer.parseInt(registro[1]),
								Integer.parseInt(registro[2]),
								Integer.parseInt(registro[3]),
								Integer.parseInt(registro[4]),
								Integer.parseInt(registro[5]),
								registro[6].equals("") ? "null" : registro[6]
								);
					}
					
					if(historialTemp == null)
						return;
					historiales.add(historialTemp);
				}
			}
			
			//Agregar a Derby
			new Thread(new Hilo()).start();
			
		} catch (Exception e) {
            e.printStackTrace();
		}
	}

}
