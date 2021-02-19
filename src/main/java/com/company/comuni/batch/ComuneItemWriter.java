package com.company.comuni.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.comuni.dto.ComuneDTO;
import com.company.comuni.dto.ComuneDTOMapper;
import com.company.comuni.repository.ComuneRepository;

public class ComuneItemWriter implements ItemWriter<ComuneDTO> {

	@Autowired
    private ComuneRepository comuneRepository;
	
	@Autowired
	private ComuneDTOMapper comuneDTOMapper;
	  
	@Override
	public void write(List<? extends ComuneDTO> items) throws Exception {
		items.forEach(dto -> {			
			comuneRepository.save( comuneDTOMapper.dtoToEntity(dto) );
		});
	}

}
