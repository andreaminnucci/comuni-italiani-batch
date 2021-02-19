package com.company.comuni.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.company.comuni.entities.Comune;

public interface ComuneRepository extends 
					PagingAndSortingRepository<Comune, Long>,
					CrudRepository<Comune, Long>,
					JpaSpecificationExecutor<Comune> {
	
}
