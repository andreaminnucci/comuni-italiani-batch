package com.company.comuni;



import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.comuni.dto.ComuneDTO;

//@SpringBootTest
public class ComuniItalianiBatchApplicationTests {

	private static Validator validator;
	
	@BeforeClass
	public static void setupValidatorInstance() {
	    validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void contextLoads() {
		ComuneDTO comuneDTO = ComuneDTO.builder()
				.codiceCatastaleComune("1234")
		.build();
		
		Set<ConstraintViolation<ComuneDTO>> violations = validator.validate(comuneDTO);
		assertThat(violations.size()).isEqualTo(0);
		
	}
}
