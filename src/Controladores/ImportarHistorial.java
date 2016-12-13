package Controladores;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Clases.*;

public class ImportarHistorial {
	
	public static void main(String[] args) {
		ImportarHistorial importar = new ImportarHistorial();
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
				
			ArrayList<Historial> historiales = new ArrayList<Historial>();
			
			if(abre != null) {
				BufferedReader br = new BufferedReader(new FileReader(abre));
				while ((line = br.readLine()) != null) {
					String [] registro = line.split(";");
					System.out.println(registro.length);
					if(registro.length < 6)
						break;
					Historial historialTemp = null;
					for (int i = 0; i < registro.length; i++) {
						registro[3] = registro[3].equals("") ? "null" : registro[3];
						registro[4] = registro[4].equals("") ? "0" : registro[4];
												
						historialTemp = new Historial (
								Integer.parseInt(registro[0]),
								Integer.parseInt(registro[1]),
								Integer.parseInt(registro[2]),
								registro[3],
								Integer.parseInt(registro[4]),
								registro[5]
								);
					}
					
					if(historialTemp == null)
						return;
					
					historiales.add(historialTemp);
//					for (int i = 0; i < participantes.size(); i++) {
//						System.out.println(participantes.get(i).toString());
//					}
				}
			}
			
			//Agregar a Derby
			Conexion conn = new Conexion();
			for (int i = 0; i < historiales.size(); i++) {
				conn.insertarHistorial(historiales.get(i));
			}
			
		} catch (IOException e) {
            e.printStackTrace();
		}
	}

}
