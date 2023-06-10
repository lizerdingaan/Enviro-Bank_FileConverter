package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.utilities.FileParser;
import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.entities.AccountProfileEntity;
import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
    * Reads the CSV files and adds data to the database
    * @param csvFile The file to be parsed
    * */
    @Override
    public void parseCSV(File csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];
                String imageFormat = data[2];
                String imageData = data[3];
                String imageFormatAndData = this.imageFormatAndData(imageFormat, imageData, name);

                File convertedImage = this.convertCSVDataToImage(imageFormatAndData);
                String uri = this.createImageLink(convertedImage).getPath();

                AccountProfileEntity accountProfileEntity = new AccountProfileEntity();
                accountProfileEntity.setAccountHolderName(name);
                accountProfileEntity.setAccountHolderSurname(surname);
                accountProfileEntity.setHttpImageLink(uri);

                accountHolderRepository.save(accountProfileEntity);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Interprets encoded base64 text into a file (image)
     * @param base64ImageData Encoded base64 string
     * @return The converted file image
     */
    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        File imageFile = null;
        String[] imageData = base64ImageData.split(" \\| ");

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(imageData[1]);
            imageFile = File.createTempFile(imageData[2], "."+imageData[0]);
            Files.write(imageFile.toPath(), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFile;
    }

    /**
     * Concatenates three values with a delimiter ('|')
     * @param imageFormat The value 'image/jpeg'
     * @param imageData The encoded base64 text
     * @param name The name of the file
     * @return The concatenated string
     */
    public String imageFormatAndData(String imageFormat, String imageData, String name) {
        try {
            String extension = imageFormat.substring(imageFormat.lastIndexOf('/') + 1);
            return extension + " | " + imageData + " | " + name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates the Uri link to the image
     * @param fileImage The file image
     * @return The Uri link
     */
    @Override
    public URI createImageLink(File fileImage) {
        try{
            URI imageLink = fileImage.toURI(); // obtains the URI version of the fileImage
            return imageLink;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getUriByNameAndSurname(String name, String surname){
        return accountHolderRepository.findAccountProfileEntityByAccountHolderNameAndAccountHolderSurname(name, surname).getHttpImageLink();
    }


    public boolean doesNameExist(String name){
        return accountHolderRepository.existsByName(name);
    }


    public boolean doesSurnameExist(String surname) {
        return accountHolderRepository.existsBySurname(surname);
    }

}
