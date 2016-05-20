package com.example.springmvc3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
		Map<String, Object> data, 
		Document doc, PdfWriter writer, 
		HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Table table = new Table(2);
		table.addCell("YEAR");
		table.addCell("SALES");
		
		for (int i = 2001; i < 2013; i++) {
			table.addCell(String.format("%d", i));
			table.addCell(
				String.format("%,d", (int)(Math.random() * 90000) + 10000));
		}
		
		doc.add(table);
		
		
	}

}











