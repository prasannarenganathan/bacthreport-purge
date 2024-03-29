package com.cnasurety.extagencyint.batches.ivans.purge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.cnasurety.extagencyint.batches.ivans.purge.config.ApplicationConfig;
import com.cnasurety.extagencyint.batches.ivans.purge.service.PurgeService;

@Configuration
@EnableBatchProcessing
@Component
public class SuretyIvansPurgeJobConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    PurgeService purgeService;
    
    @Autowired
    ApplicationConfig applicationConfig;
       
    
    @Bean
    @StepScope
    public Tasklet purgeTransactionsTablesTasklet(@Value("#{jobParameters['message']}") String message) {
        LOGGER.info(message);

        return (stepContribution, chunkContext) -> {
        	purgeService.purgeTables(applicationConfig.getDays());
            return RepeatStatus.FINISHED;
        };
    }

 
    @Bean
    public Step purgeTransactiosStep() {

        return stepBuilderFactory.get("purgeTransactionsTablesTasklet")
                .tasklet(purgeTransactionsTablesTasklet("deleting Transaction tables records which are less than 90 days")).build();

    }
    
   
    
    @Bean
    public Job PurgeJob() {
    	
        
        JobBuilder jobBuilder = jobBuilderFactory
                .get("Export Job: " + String.valueOf(new java.util.Random().nextInt()));
        SimpleJobBuilder sbuilder = jobBuilder.
        		start(purgeTransactiosStep());
        Job job = sbuilder.build();
        return job;

    }

   
}
