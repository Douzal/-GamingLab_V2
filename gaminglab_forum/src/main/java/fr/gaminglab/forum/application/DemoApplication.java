package fr.gaminglab.forum.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"fr.gaminglab.forum.dao"})
@EntityScan(basePackages = {"fr.gaminglab.forum.entity"})
@ComponentScan(basePackages= {"fr.gaminglab"})
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
		
	}

}