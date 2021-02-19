package com.company.comuni.dto;

import org.springframework.stereotype.Component;

import com.company.comuni.entities.Comune;

@Component
public class ComuneDTOMapper extends AbstractDTOMapper<ComuneDTO, Comune> {

	@Override
	public ComuneDTO entityToDTO(Comune entity) {
		return ComuneDTO.builder()
				.codiceCatastaleComune( entity.getCodiceCatastaleComune())
				.codiceComune( entity.getCodiceComune() )
				.codiceProvincia( entity.getCodiceProvincia() )
				.progressivoComune( entity.getProgressivoComune() )
				.denominazioneComune( entity.getDenominazioneComune() )
				.siglaAutomobilistica( entity.getSiglaAutomobilistica() )
				.codiceRipartizioneGeografica(entity.getCodiceRipartizioneGeografica() )
				.ripartizioneGeografica( entity.getRipartizioneGeografica() )
				.codiceRegione( entity.getCodiceRegione() )
				.denominazioneRegione( entity.getDenominazioneRegione() )
			.build();
	}

	@Override
	public Comune dtoToEntity(ComuneDTO dto) {
		Comune entity = new Comune();
		entity.setCodiceCatastaleComune( dto.getCodiceCatastaleComune() );
		entity.setCodiceComune( dto.getCodiceComune() );
		entity.setCodiceProvincia( dto.getCodiceProvincia() );
		entity.setProgressivoComune( dto.getProgressivoComune() );
		entity.setDenominazioneComune( dto.getDenominazioneComune() );
		entity.setSiglaAutomobilistica( dto.getSiglaAutomobilistica() );
		entity.setCodiceRipartizioneGeografica( dto.getCodiceRipartizioneGeografica() );
		entity.setRipartizioneGeografica( dto.getRipartizioneGeografica() );
		entity.setCodiceRegione( dto.getCodiceRegione() );
		entity.setDenominazioneRegione( dto.getDenominazioneRegione() );
		
		return entity;
	}
	
}
