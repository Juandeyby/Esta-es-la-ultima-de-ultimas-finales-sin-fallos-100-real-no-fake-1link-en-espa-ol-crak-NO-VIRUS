package Controladores;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import Clases.ParticipanteOut;
import Clases.ParticipantePDF;

public class ExportarPDF  {
	

	public void crearPDF(FileOutputStream archivo, Document doc, int cod) {
		try {
			String cabecera = "";
			switch(cod){
			case 0:
				cabecera = "SELECCIONADOS";
				break;
			case 1:
				cabecera = "FORMULADORES";
				break;
			case 2:
				cabecera = "TECNICOS";
				break;
			case 3:
				cabecera = "CONTROLADORES";
				break;
			case 4:
				cabecera = "CONTADORES";
				break;
			case 5:
				cabecera = "CONSERJES";
				break;
			case 6:
				cabecera = "PORTEROS";
				break;
			case 7:
				cabecera = "VERIFICADOR";
				break;
			}
			//agregando imagen
			Image foto = Image.getInstance("./Imagenes/escudo.png");
			foto.scaleToFit(50, 50);
			foto.setAlignment(Element.CCITT_ENDOFLINE);
			doc.add(foto);

			//agregando imagen fondo


			Image fondo=Image.getInstance("./Imagenes/escudofondo.png");
			fondo.getBorderColorTop();

			fondo.scaleToFit(600, 600);
			fondo.setAbsolutePosition(60, 65);
			fondo.setAlignment(Element.ALIGN_CENTER);
			doc.add(fondo);

			//encabezado
			Paragraph encabezado=new Paragraph("  "+"\n\n    UNIVERSIDAD NACIONAL DE \n"+"  "							
					+"  SAN AGUSTIN DE AREQUIPA"
					+"                        ",
					FontFactory.getFont("arial",9,Font.BOLD));

			encabezado.setAlignment(Element.ALIGN_LEFT);
			doc.add(encabezado);

			//seleccion
			Paragraph sele=new Paragraph(cabecera,
					FontFactory.getFont("arial",15,Font.BOLD));

			sele.setAlignment(Element.ALIGN_CENTER);
			doc.add(sele);
			//fecha

			Date fecha = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String fecha1 = "Fecha:  " + formato.format(fecha);
			Paragraph fechaa=new Paragraph(fecha1,FontFactory.getFont("arial",9,Font.NORMAL));
			fechaa.setAlignment(Element.ALIGN_RIGHT);

			doc.add(new Paragraph(fechaa));			
			//hora

			DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			String hora="Hora: "+hourFormat.format(fecha);
			Paragraph horaa=new Paragraph(hora,FontFactory.getFont("arial",9,Font.NORMAL));
			horaa.setAlignment(Element.ALIGN_RIGHT);
			doc.add(new Paragraph(horaa));	

			//linea

			String linea="______________________________________________________________________________\n\n ";
			Paragraph lineaa=new Paragraph(linea);
			horaa.setAlignment(Element.ALIGN_CENTER);
			doc.add(new Paragraph(lineaa));	 
			
			Conexion conn = new Conexion();
			ArrayList<ParticipantePDF> participantes = conn.mostrarNuevo(cod);

			float [] f = {1, 2, 3, 3, 3};
			PdfPTable tabla = new PdfPTable(f);
			
			PdfPCell pdf;
			pdf = new PdfPCell(new Phrase("N°", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK)));
			pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdf.setVerticalAlignment(Element.ALIGN_CENTER);
			pdf.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pdf.setBorder(Rectangle.NO_BORDER);
			tabla.addCell(pdf);
			pdf = new PdfPCell(new Phrase("DNI", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK)));
			pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdf.setVerticalAlignment(Element.ALIGN_CENTER);
			pdf.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pdf.setBorder(Rectangle.NO_BORDER);
			tabla.addCell(pdf);
			pdf = new PdfPCell(new Phrase("Nombres", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK)));
			pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdf.setVerticalAlignment(Element.ALIGN_CENTER);
			pdf.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pdf.setBorder(Rectangle.NO_BORDER);
			tabla.addCell(pdf);
			pdf = new PdfPCell(new Phrase("Apellidos", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK)));
			pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdf.setVerticalAlignment(Element.ALIGN_CENTER);
			pdf.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pdf.setBorder(Rectangle.NO_BORDER);
			tabla.addCell(pdf);
			pdf = new PdfPCell(new Phrase("Cargos", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK)));
			pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdf.setVerticalAlignment(Element.ALIGN_CENTER);
			pdf.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pdf.setBorder(Rectangle.NO_BORDER);
			tabla.addCell(pdf);
			
			for (int i = 0; i < participantes.size(); i++) {
				pdf = new PdfPCell(new Phrase(i +"", FontFactory.getFont("arial",8 , Font.NORMAL)));
				pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdf.setVerticalAlignment(Element.ALIGN_CENTER);
				pdf.setBorder(Rectangle.NO_BORDER);
				tabla.addCell(pdf);
				pdf = new PdfPCell(new Phrase(participantes.get(i).getDni_paarticipante(), FontFactory.getFont("arial", 8, Font.NORMAL)));
				pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdf.setVerticalAlignment(Element.ALIGN_CENTER);
				pdf.setBorder(Rectangle.NO_BORDER);
				tabla.addCell(pdf);
				pdf = new PdfPCell(new Phrase(participantes.get(i).getNombre_participante(), FontFactory.getFont("arial", 8, Font.NORMAL)));
				pdf.setHorizontalAlignment(Element.ALIGN_LEFT);
				pdf.setVerticalAlignment(Element.ALIGN_CENTER);
				pdf.setBorder(Rectangle.NO_BORDER);
				tabla.addCell(pdf);
				pdf = new PdfPCell(new Phrase(participantes.get(i).getApellido_participante(), FontFactory.getFont("arial", 8, Font.NORMAL)));
				pdf.setHorizontalAlignment(Element.ALIGN_LEFT);
				pdf.setVerticalAlignment(Element.ALIGN_CENTER);
				pdf.setBorder(Rectangle.NO_BORDER);
				tabla.addCell(pdf);
				pdf = new PdfPCell(new Phrase(participantes.get(i).getCargo_participante() , FontFactory.getFont("arial",8 , Font.NORMAL)));
				pdf.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdf.setVerticalAlignment(Element.ALIGN_CENTER);
				pdf.setBorder(Rectangle.NO_BORDER);
				tabla.addCell(pdf);
			}
			doc.add(tabla);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error"+e);
		}		
	}
}