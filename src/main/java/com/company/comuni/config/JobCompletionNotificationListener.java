package com.company.comuni.config;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.comuni.repository.ComuneRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	@Autowired
	private ComuneRepository comuneRepository;

	@Override
	public void afterJob(JobExecution jobExecution) {
	  if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
		  log.info("!!! JOB FINISHED! Time to verify the results");

      comuneRepository
        	.findAll()
        	.forEach(phase -> log.info("Found <" + phase + "> in the database."));
    }
  }
}
