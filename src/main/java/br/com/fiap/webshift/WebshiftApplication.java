package br.com.fiap.webshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication()
@EnableAutoConfiguration 
@ComponentScan(basePackages={"br.com.fiap.webshift"}) 
@EnableJpaRepositories(basePackages="br.com.fiap.webshift.repository") 
@EnableTransactionManagement 
@EntityScan(basePackages="")

public class WebshiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshiftApplication.class, args);
	}

}
