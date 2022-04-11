package com.mypack;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job createJob() {
		return jobBuilderFactory.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(createStep1()).end().build();
	}
	
	@Bean
	public Step createStep1() {
		return stepBuilderFactory.get("MyStep1")
				.<String, String> chunk(3)
				.reader(new MyCustomReader())
				.processor(new MyCustomProcessor())
				.writer(new MyCustomWriter())
				.build();
	}
	
}
