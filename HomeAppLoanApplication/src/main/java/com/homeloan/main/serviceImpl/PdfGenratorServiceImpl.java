package com.homeloan.main.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.homeloan.main.model.SanctionLetter;
import com.homeloan.main.service.PdfGenratorService;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

@Service
public class PdfGenratorServiceImpl implements PdfGenratorService {
	
	
	public ByteArrayInputStream createpdf() {
		String title = "Dream Home Finance Limited";
        String contentofpdf = "Pdf Generation Process";

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, out);

            HeaderFooter footer = new HeaderFooter(true, new Phrase(" (Sanction Letter)"));
            footer.setAlignment(Element.ALIGN_RIGHT);
            footer.setBorderWidthBottom(0);
            document.setFooter(footer);

            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Paragraph titlePara = new Paragraph(title, titleFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(titlePara);

         

            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 20);
            Paragraph subtitlePara = new Paragraph("Sanction Letter", subtitleFont);
            subtitlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitlePara);
            
            Paragraph emptyLine = new Paragraph();
            emptyLine.setSpacingBefore(10); // Set the top margin for the empty line
            document.add(emptyLine);
            
            LineSeparator line = new LineSeparator();
 
            document.add(line);
           
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());

	}
	
	public ByteArrayInputStream createSanctionLetterpdf( SanctionLetter sanctionLetter) {
		String title = "Dream Home Finance Limited";
       

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, out);

            HeaderFooter footer = new HeaderFooter(true, new Phrase(" (Sanction Letter)"));
            footer.setAlignment(Element.ALIGN_RIGHT);
            footer.setBorderWidthBottom(0);
            document.setFooter(footer);

            document.open();
            
            
            

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Paragraph titlePara = new Paragraph(title, titleFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(titlePara);

         

            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 20);
            Paragraph subtitlePara = new Paragraph("Sanction Letter", subtitleFont);
            subtitlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitlePara);
            Paragraph emptyLine = new Paragraph();
            emptyLine.setSpacingBefore(10); // Set the top margin for the empty line
            document.add(emptyLine);
            
            LineSeparator line = new LineSeparator();
            
            document.add(line);
            
            
            StringBuilder letterBuilder = new StringBuilder();
            letterBuilder.append("Date: ").append(sanctionLetter.getSanctionDate()).append("\n\n");

	        letterBuilder.append("Dear ").append(sanctionLetter.getApplicantName()).append(",\n\n");

	        letterBuilder.append("Congratulations! We are pleased to inform you that your home loan application has been sanctioned by Dream Home Finance Limited.\n\n");

	        letterBuilder.append("Loan Details:\n");
	        letterBuilder.append("Product: ").append(sanctionLetter.getProducthomeEquity()).append("\n");
	        letterBuilder.append("Loan Amount: ").append(sanctionLetter.getLoanammount()).append("\n");
	        letterBuilder.append("Rate of Interest: ").append("7").append("%\n");
	        letterBuilder.append("Loan Tenure: ").append(sanctionLetter.getLoanTenure()).append(" Year\n");
	        letterBuilder.append("Monthly EMI: ").append(sanctionLetter.getMonthlyEmiAmount()).append("\n");

	        letterBuilder.append("Mode of Payment: ").append(sanctionLetter.getModeOfPayment()).append("\n");

	        letterBuilder.append("Terms and Conditions:\n");
	        letterBuilder.append(sanctionLetter.getTermsCondition()).append("\n\n");

	        letterBuilder.append("Remarks: ").append(sanctionLetter.getRemarks()).append("\n\n");

	        letterBuilder.append("Please review the attached document for the detailed terms and conditions of your home loan. If you have any further questions or need assistance, feel free to contact us at ").append(sanctionLetter.getContactno()).append(".\n\n");

	        letterBuilder.append("Thank you for choosing Dream Home Finance Limited. We look forward to serving you.\n\n");

	        letterBuilder.append("Sincerely,\n");
	        letterBuilder.append("Dream Home Finance Limited\n");
	        
	        String string = letterBuilder.toString();
	        
	        Font parafont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph sanctionletterpara = new Paragraph(string, parafont);
            subtitlePara.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(sanctionletterpara);
	        
            
            
            
          
            
           
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());

	}

	@Override
	public byte[] createSanctionLetterPdf(SanctionLetter letter) {
	    String title = "Dream Home Finance Limited";
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Document document = new Document();

	    try {
	        PdfWriter.getInstance(document, out);
	        document.open();

	        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
	        Paragraph titlePara = new Paragraph(title, titleFont);
	        titlePara.setAlignment(Element.ALIGN_CENTER);
	        document.add(titlePara);

	        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 20);
	        Paragraph subtitlePara = new Paragraph("Sanction Letter", subtitleFont);
	        subtitlePara.setAlignment(Element.ALIGN_CENTER);
	        document.add(subtitlePara);

	        document.add(Chunk.NEWLINE); // Add a blank line

	        // Add the letter content using Paragraph
	        Paragraph letterContent = new Paragraph();

	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String formattedDate = dateFormat.format(new Date());

	        letterContent.add("Date: " + formattedDate + "\n\n");
	        letterContent.add("Dear " + letter.getApplicantName() + ",\n\n");
	        letterContent.add("Congratulations! We are pleased to inform you that your home loan application has been sanctioned by Dream Home Finance Limited.\n\n");

	        // Add loan details
	        letterContent.add("Loan Details:\n");
	        letterContent.add("Product: " + letter.getProducthomeEquity() + "\n");
	        letterContent.add("Loan Amount: " + letter.getLoanammount() + "\n");
	        letterContent.add("Rate of Interest: " + letter.getRateOfInterest() + "%\n");
	        letterContent.add("Loan Tenure: " + letter.getLoanTenure() + " months\n");
	        letterContent.add("Monthly EMI: " + letter.getMonthlyEmiAmount() + "\n\n");

	        // Add terms and conditions
	        letterContent.add("Terms and Conditions:\n");
	        letterContent.add("1. The borrower must provide accurate and up-to-date information throughout the loan tenure.\n");
	        letterContent.add("2. The borrower agrees to make timely monthly repayments as per the agreed schedule.\n");
	        letterContent.add("3. Failure to make timely repayments may result in penalties and affect the credit score.\n");
	        // Add more terms and conditions as per your requirements

	        letterContent.add("\n");

	        // Add remaining content
	        letterContent.add("Remarks: " + letter.getRemarks() + "\n\n");
	        letterContent.add("Please review the attached document for the detailed terms and conditions of your home loan. If you have any further questions or need assistance, feel free to contact us at " + letter.getContactno() + ".\n\n");
	        letterContent.add("Thank you for choosing Dream Home Finance Limited. We look forward to serving you.\n\n");
	        letterContent.add("Sincerely,\n");
	        letterContent.add("Dream Home Finance Limited\n");

	        document.add(letterContent);

	        document.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return out.toByteArray();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	 
	 
	 
	}
	


