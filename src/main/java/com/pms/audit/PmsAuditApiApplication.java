package com.pms.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.pms.audit"})
public class PmsAuditApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsAuditApiApplication.class, args);
	}

}
