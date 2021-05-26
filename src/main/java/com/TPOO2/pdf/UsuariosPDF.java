package com.TPOO2.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.TPOO2.entities.UsuarioEntity;
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

public class UsuariosPDF {

	private List<UsuarioEntity> usuarios;

	public UsuariosPDF(List<UsuarioEntity> usuarios) {
		super();
		this.usuarios = usuarios;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell celda = new PdfPCell();
		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(1);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("Nombre", font));

		table.addCell(celda);

		celda.setPhrase(new Phrase("Apellido", font));
		table.addCell(celda);

		celda.setPhrase(new Phrase("E-mail", font));
		table.addCell(celda);

		celda.setPhrase(new Phrase("Tipo de documento", font));
		table.addCell(celda);

		celda.setPhrase(new Phrase("Numero de documento", font));
		table.addCell(celda);

		celda.setPhrase(new Phrase("Nombre de usuario", font));
		table.addCell(celda);

		celda.setPhrase(new Phrase("Tipo de perfil", font));
		table.addCell(celda);

	}

	private void writeTableData(PdfPTable table) {
		for (UsuarioEntity usuario : usuarios) {
			table.addCell(usuario.getNombre());
			table.addCell(usuario.getApellido());
			table.addCell(usuario.getEmail());
			table.addCell(usuario.getTipo().name());
			table.addCell(String.valueOf(usuario.getDni()));
			table.addCell(usuario.getNombreUsuario());
			table.addCell(usuario.getPerfil().getTipoPerfil());

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

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(85f);
		table.setWidths(new float[] { 1.0f, 1.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.5f });
		table.setSpacingBefore(2);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}