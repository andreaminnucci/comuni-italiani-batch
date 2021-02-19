package com.company.comuni.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComuneDTO {

	@NotNull
	@Size(min = 4, max = 4)
	private String codiceCatastaleComune;
	
	@NotNull
	@Size(min = 6, max = 6)
	private String codiceComune;
	
	@NotNull
	@Size(min = 3, max = 3)
	private String codiceProvincia;
	
	@NotNull
	@Size(min = 3, max = 3)
	private String progressivoComune;
	
	@NotNull
	@Size(min = 1, max = 30)
	private String denominazioneComune;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String siglaAutomobilistica;
	
	@NotNull
	private Integer codiceRipartizioneGeografica;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String ripartizioneGeografica;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String codiceRegione;
	
	@NotNull
	@Size(min = 1, max = 30)
	private String denominazioneRegione;
}
