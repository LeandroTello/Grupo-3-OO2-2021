package com.TPOO2.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.TPOO2.entities.PerfilEntity;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PerfilesPDF {


	private List<PerfilEntity> perfiles;



	public PerfilesPDF(List<PerfilEntity> perfiles) {
		super();
		this.perfiles = perfiles;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell celda = new PdfPCell();
		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(1);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("Descripcion", font));

		table.addCell(celda);

	}

	private void writeTableData(PdfPTable table) {
		for (PerfilEntity perfil : perfiles) {
			table.addCell(perfil.getTipoPerfil());

		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A3);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Lista de usuarios\n\n\n", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(85f);
		table.setWidths(new float[] { 1.0f}); // , 1.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.5f 
		table.setSpacingBefore(2);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
