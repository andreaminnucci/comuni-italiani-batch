package com.company.comuni.config;

import java.util.Arrays;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.comuni.batch.ComuneItemReader;
import com.company.comuni.batch.ComuneItemWriter;
import com.company.comuni.dto.ComuneDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableBatchProcessing
public class ComuneBatchConfiguration {

	@Autowired
    private YAMLProperties properties;
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
    public StepBuilderFactory stepBuilderFactory;
	
	@Bean
    public ComuneItemReader reader() {
		log.info("{}: {}", properties.getList().length, Arrays.toString(properties.getList()));
        return new ComuneItemReader(properties.getFileName(), properties.getSheetName(), properties.getColumnsMapping());
    }
	
	@Bean
    public ComuneItemWriter writer(DataSource dataSource) {
        return new ComuneItemWriter();
    }
	
	@Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importComuni")
	        .incrementer(new RunIdIncrementer())
	        .listener(listener)
	        .flow(step1)
	        .end()
	        .build();
    }
	 
	@Bean
    public Step step1(ComuneItemWriter writer) {
        return stepBuilderFactory.get("step1")
	            .<ComuneDTO, ComuneDTO> chunk(10)
	            .reader(reader())
	            .writer(writer)
            .build();
    }
}
