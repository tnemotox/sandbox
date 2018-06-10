package com.example;

import com.example.domain.model.BenchmarkEntity;
import com.example.domain.repository.BenchmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

    /**
     * レコードを適当に挿入しておく
     */
    @Bean
    public CommandLineRunner demo(BenchmarkRepository repository) {
        return (args) -> {
            repository.save(new BenchmarkEntity(1, 1));
            repository.save(new BenchmarkEntity(500000, 500000));
            repository.save(new BenchmarkEntity(900000, 900000));
        };
    }}
