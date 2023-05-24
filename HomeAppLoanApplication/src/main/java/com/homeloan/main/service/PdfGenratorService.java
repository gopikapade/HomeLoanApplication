package com.homeloan.main.service;

import java.io.ByteArrayInputStream;

import com.homeloan.main.model.SanctionLetter;

public interface PdfGenratorService {
	
	public ByteArrayInputStream createpdf();

	public ByteArrayInputStream createSanctionLetterpdf( SanctionLetter sanctionLetter);

	public byte[] createSanctionLetterPdf(SanctionLetter letter);

}
