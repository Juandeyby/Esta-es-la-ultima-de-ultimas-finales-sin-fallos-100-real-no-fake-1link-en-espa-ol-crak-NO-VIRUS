package Controladores;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Clases.*;

public class ImportarParticipantes {
	
	JProgressBar progressBar;
	ArrayList<Participante> participantes;
	public int i = 0;
	DefaultTableModel model;
	private BufferedReader br;

	private class Hilo implements Runnable {
		@Override
		public void run() {
			JFrame frame = new JFrame("Importando Participantes");
			frame.setBounds(100, 100, 281, 60);
			frame.getContentPane().setLayout(null);
			
			progressBar = new JProgressBar(0, participantes.size()-1);
			progressBar.setStringPainted(true);
			progressBar.setBounds(12, 12, 257, 28);
			progressBar.setValue(0);
			
			frame.getContentPane().add(progressBar);
			Main.centralizar(frame);
			frame.setVisible(true);
			
			Conexion conn = new Conexion();
			for (i = 0; i < participantes.size(); i++) {
				progressBar.setValue(i);
				conn.insertarParticipante(participantes.get(i));
			}
			
			ArrayList<ParticipanteOut> participantes = conn.mostrar();
		
			for (int i = 0; i < participantes.size(); i++) {
				model.addRow(new Object[] {
						participantes.get(i).getDni_participante(),
						conn.refinar(participantes.get(i).getNombre_participante()),
						conn.refinar(participantes.get(i).getApellido_participante()),
						conn.refinar(participantes.get(i).getId_funcion()),
						conn.refinar(participantes.get(i).getId_tipo_participante()),
						Boolean.parseBoolean(participantes.get(i).isEstado_participante() + ""),
						"Ver"
						});
			}
			frame.dispose();
		}
	}
	
	public ImportarParticipantes (DefaultTableModel model) {
		this.model = model;
		
		try {
			String line = "";
			JFileChooser file = new JFileChooser();
			
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.csv", "csv");
			file.setFileFilter(filtro);
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			file.showOpenDialog(file);
			
			File abre = file.getSelectedFile();
			line = abre.getName();
			
			participantes = new ArrayList<Participante>();
			
			if(abre != null) {
				br = new BufferedReader(new FileReader(abre));
				
				while ((line = br.readLine()) != null) {
					String [] registro = line.split(";");
					if(registro.length < 15)
						break;
					Participante docenteTemp = null;
					for (int i = 0; i < registro.length; i++) {
						docenteTemp = new Participante(
								registro[0],
								registro[1],
								registro[2],
								registro[3].equals("") ? "null" : registro[3],
								Integer.parseInt(registro[4].equals("") ? "0" : registro[4]),
								Integer.parseInt(registro[5].equals("") ? "null" : registro[5]),
								registro[6].equals("") ? "null" : registro[6],
								registro[7].equals("") ? "null" : registro[7],
								registro[8].equals("") ? "null" : registro[8],
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
			
			//Agregar a Derby
			new Thread(new Hilo()).start();
			
		} catch (Exception e) {
            e.printStackTrace();
		}
	}

}
