package com.company.comuni.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "comune", schema = "anagrafiche",
	uniqueConstraints = { 
			@UniqueConstraint(name = "uk_com_codice_provincia_progressivo_comune", columnNames = { "com_codice_provincia", "com_progressivo_comune" } ),
			@UniqueConstraint(name = "uk_com_codice_catastale_comune", columnNames = { "com_codice_catastale_comune" } ),
			@UniqueConstraint(name = "uk_com_codice_comune", columnNames = { "com_codice_comune" } ),
	})
public class Comune {

	@Id
	@SequenceGenerator(name = "comune_sequence_generator", sequenceName = "comune_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comune_sequence_generator")
	@Column(name = "com_id")
	private Long id;
	
	@Version
	@Column(name = "com_version", nullable = false)
	private Date version;
	
	@Column(name = "com_codice_catastale_comune", length = 4, nullable = false)
	private String codiceCatastaleComune;
	
	@Column(name = "com_codice_comune", length = 6, nullable = false)
	private String codiceComune;
	
	@Column(name = "com_codice_provincia", length = 3, nullable = false)
	private String codiceProvincia;
	
	@Column(name = "com_progressivo_comune", length = 3, nullable = false)
	private String progressivoComune;
	
	@Column(name = "com_denominazione_comune", length = 40, nullable = false)
	private String denominazioneComune;
	
	@Column(name = "com_sigla_automobilistica", length = 2, nullable = false)
	private String siglaAutomobilistica;
	
	@Column(name = "com_codice_ripartizione_geografica", nullable = false)
	private Integer codiceRipartizioneGeografica;
	
	@Column(name = "com_ripartizione_geografica", length = 10, nullable = false)
	private String ripartizioneGeografica;
	
	@Column(name = "com_codice_regione", length = 2, nullable = false)
	private String codiceRegione;
	
	@Column(name = "com_denominazione_regione", length = 30, nullable = false)
	private String denominazioneRegione;
}
