package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;

@SpringBootApplication
public class EnviroBankApplication implements CommandLineRunner {

	private final AccountHolderService accountHolderService;

	@Autowired
	public EnviroBankApplication(AccountHolderService accountHolderService) {
		this.accountHolderService = accountHolderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EnviroBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String csvFile = "1672815113084-GraduateDev_AssessmentCsv_Ref003.csv";
		Resource csvResource = new ClassPathResource(csvFile);
		accountHolderService.parseCSV(csvResource.getFile());
	}
}
