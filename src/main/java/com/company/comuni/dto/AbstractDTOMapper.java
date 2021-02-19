package com.company.comuni.dto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDTOMapper<D, E> {
	
	abstract public D entityToDTO(E entity);
	
	abstract public E dtoToEntity(D dto);
	
	public List<D> entitiesToDTOs(List<E> entities) {
		return entities.stream()
				.map(e -> this.entityToDTO(e))
				.collect(Collectors.toList());
	}
	
	public List<E> dtosToEntities(List<D> dtos) {
		return dtos.stream()
				.map(d -> this.dtoToEntity(d))
				.collect(Collectors.toList());
	}
}
