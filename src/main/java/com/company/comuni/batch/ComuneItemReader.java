package com.company.comuni.batch;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.company.comuni.dto.ComuneDTO;

public class ComuneItemReader implements ItemReader<ComuneDTO> {
	private final String CODICE_REGIONE_COL = "CODICE_REGIONE_COL";
	private final String CODICE_PROVINCIA_COL = "CODICE_PROVINCIA_COL";
	private final String PROGRESSIVO_COMUNE_COL = "PROGRESSIVO_COMUNE_COL";
	private final String CODICE_COMUNE_COL = "CODICE_COMUNE_COL";
	private final String DENOMINAZIONE_COMUNE_COL = "DENOMINAZIONE_COMUNE_COL";
	private final String CODICE_RIPARTIZIONE_GEOGRAFICA_COL = "CODICE_RIPARTIZIONE_GEOGRAFICA_COL";
	private final String RIPARTIZIONE_GEOGRAFICA_COL = "RIPARTIZIONE_GEOGRAFICA_COL";
	private final String DENOMINAZIONE_REGIONE_COL = "DENOMINAZIONE_REGIONE_COL";
	private final String SIGLA_AUTOMOBILISTICA_COL = "SIGLA_AUTOMOBILISTICA_COL";
	private final String CODICE_CATASTALE_COMUNE_COL = "CODICE_CATASTALE_COMUNE_COL";

	private Iterator<ComuneDTO> results;
	
	private String fileName;
	private String sheetName;
	private Map<String, Integer> columnsMapping;
	
	public ComuneItemReader(String fileName, String sheetName, Map<String, Integer> columnsMapping) {
		this.fileName = fileName;
		this.sheetName = sheetName;
		this.columnsMapping = columnsMapping;
	}
	
	@Override
	public ComuneDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (this.results == null) {
            Resource resource = new ClassPathResource(fileName);
            List<ComuneDTO> list = readFromExcel(resource);
            this.results = list.iterator();
        }
        return this.results.hasNext() ? this.results.next() : null; 
    }
	
	
	/**
     * Java method to read dates from Excel file in Java.
     * This method read value from .XLS file, which is an OLE
     * format. 
     * 
     * @param file
     * @throws IOException 
     */
    public List<ComuneDTO> readFromExcel(Resource resource) throws IOException {       
        List<ComuneDTO> results = new ArrayList<>();
        InputStream inputStream = resource.getInputStream();
        
        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowtot = sheet.getPhysicalNumberOfRows();
        
        for ( int rownum = 1; rownum < rowtot; rownum++ ) {
			Row row = sheet.getRow(rownum);

			String codiceRegione 				= row.getCell( columnsMapping.get(CODICE_REGIONE_COL) ).getStringCellValue().trim();
			String codiceProvincia 				= row.getCell( columnsMapping.get(CODICE_PROVINCIA_COL) ).getStringCellValue().trim();
			String progressivoComune 			= row.getCell( columnsMapping.get(PROGRESSIVO_COMUNE_COL) ).getStringCellValue().trim();
			String codiceComune		 			= row.getCell( columnsMapping.get(CODICE_COMUNE_COL) ).getStringCellValue().trim();
			String denominazioneComune 			= row.getCell( columnsMapping.get(DENOMINAZIONE_COMUNE_COL) ).getStringCellValue();
			int codiceRipartizioneGeografica 	= (int) row.getCell( columnsMapping.get(CODICE_RIPARTIZIONE_GEOGRAFICA_COL) ).getNumericCellValue();
			String ripartizioneGeografica 		= row.getCell(	columnsMapping.get(RIPARTIZIONE_GEOGRAFICA_COL) ).getStringCellValue().trim();
			String denominazioneRegione 		= row.getCell( columnsMapping.get(DENOMINAZIONE_REGIONE_COL) ).getStringCellValue().trim();
			String siglaAutomobilistica 		= row.getCell( columnsMapping.get(SIGLA_AUTOMOBILISTICA_COL) ).getStringCellValue().trim();
			String codiceCatastaleComune 		= row.getCell( columnsMapping.get(CODICE_CATASTALE_COMUNE_COL) ).getStringCellValue().trim();
			
			ComuneDTO dto = ComuneDTO.builder()
					.codiceRegione(codiceRegione)
					.codiceProvincia(codiceProvincia)
					.progressivoComune(progressivoComune)
					.codiceComune(codiceComune)
					.denominazioneComune(denominazioneComune)
					.ripartizioneGeografica(ripartizioneGeografica)
					.codiceRipartizioneGeografica(codiceRipartizioneGeografica)
					.denominazioneRegione(denominazioneRegione)
					.siglaAutomobilistica(siglaAutomobilistica)
					.codiceCatastaleComune(codiceCatastaleComune)
				.build();
			
			results.add(dto);
        }

    	workbook.close();
        return results;
    }

}
