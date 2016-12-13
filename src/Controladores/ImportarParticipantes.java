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

public class ImportarParticipantes {
	
	JProgressBar progressBar;
	Hilo hilo;

	private class Hilo extends Thread {
		public void run() {
			progressBar.setValue(progress);
		}
	}
	
	public ImportarParticipantes () {
		
		try {
			String line = "";
			JFileChooser file = new JFileChooser();
			
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.csv", "csv");
			file.setFileFilter(filtro);
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			file.showOpenDialog(file);
			
			File abre = file.getSelectedFile();
			line = abre.getName();
			
			ArrayList<Participante> participantes = new ArrayList<Participante>();
			
			if(abre != null) {
				BufferedReader br = new BufferedReader(new FileReader(abre));
				
				while ((line = br.readLine()) != null) {
					String [] registro = line.split(";");
					if(registro.length < 15)
						break;
					Participante docenteTemp = null;
					for (int i = 0; i < registro.length; i++) {
						registro[3] = registro[3].equals("") ? "null" : registro[3];
						registro[4] = registro[4].equals("") ? "0" : registro[4];
						registro[5] = registro[5].equals("") ? "null" : registro[5];
						registro[6] = registro[6].equals("") ? "null" : registro[6];
						registro[7] = registro[7].equals("") ? "null" : registro[7];
						registro[8] = registro[8].equals("") ? "null" : registro[8];
												
						docenteTemp = new Participante(
								registro[0],
								registro[1],
								registro[2],
								registro[3],
								Integer.parseInt(registro[4]),
								Integer.parseInt(registro[5]),
								registro[6],
								registro[7],
								registro[8],
								Boolean.parseBoolean(registro[9]),
								Integer.parseInt(registro[10]),
								Integer.parseInt(registro[11]),
								Integer.parseInt(registro[12]),
								Integer.parseInt(registro[13]),
								Integer.parseInt(registro[14])
								);
					}
					
					if(docenteTemp == null)
						return;
					participantes.add(docenteTemp);
				}
			}
			
			JFrame frame = new JFrame();
			frame.setBounds(100, 100, 281, 80);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			progressBar = new JProgressBar(0, participantes.size()-1);
			progressBar.setValue(0);
			progressBar.setStringPainted(true);
			progressBar.setBounds(12, 12, 257, 28);
			
			frame.getContentPane().add(progressBar);
			Main.centralizar(frame);
			frame.setVisible(true);
			//Agregar a Derby
			Conexion conn = new Conexion();
			for (int i = 0; i < 1000; i++) {
				progressBar.setValue(i*10);
				Thread.sleep(10);
				progressBar.setStringPainted(true);
			}
//			for (int i = 0; i < participantes.size(); i++) {
//				progressBar.setValue(i);
//				conn.insertarParticipante(participantes.get(i));
//			}
//			frame.dispose();
			
		} catch (Exception e) {
            e.printStackTrace();
		}
	}

}
