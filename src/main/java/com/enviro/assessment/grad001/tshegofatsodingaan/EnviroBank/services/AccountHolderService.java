package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.converter.FileParser;
import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.entities.AccountProfileEntity;
import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.util.Base64;

@Service
public class AccountHolderService implements FileParser {

    private final AccountHolderRepository accountHolderRepository;

    @Autowired
    public AccountHolderService(AccountHolderRepository accountHolderRepository){
        this.accountHolderRepository = accountHolderRepository;

    }
    @Override
    public void parseCSV(File csvFile) throws FileNotFoundException {
       // System.out.println(csvFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];
                String imageFormat = data[2];
                String imageData = data[3];

                File convertedImage = this.convertCSVDataToImage(imageData);
                String uri = this.createImageLink(convertedImage).getPath();

                AccountProfileEntity accountProfileEntity = new AccountProfileEntity();
                accountProfileEntity.setAccountHolderName(name);
                accountProfileEntity.setAccountHolderSurname(surname);
                accountProfileEntity.setHttpImageLink(uri);

                accountHolderRepository.save(accountProfileEntity);

            }
        } catch (IOException e) {
            System.out.println("Failed to read CSV file: " + e.getMessage());
        }

    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        byte[] imageData = Base64.getDecoder().decode(base64ImageData);
        File imageFile = null;

        try {
            imageFile = File.createTempFile("image", "jpg"); // creates a temp file to store decoded image data
            Files.write(imageFile.toPath(), imageData); // writes the decoded imageData to the temp file
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }

    @Override
    public URI createImageLink(File fileImage) {
        URI imageLink = fileImage.toURI(); // obtains the URI version of the fileImage
        return imageLink;
    }
}
