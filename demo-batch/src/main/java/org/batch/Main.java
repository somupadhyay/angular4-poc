package org.batch;

import org.batch.config.BatchConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(BatchConfiguration.class, args)));
	}
}
