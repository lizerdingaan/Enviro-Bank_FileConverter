package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.converter;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.util.Base64;

public class CSVFileParser implements FileParser{

    /*
    * Reads and processes the content of the csv file
    * */
    @Override
    public void parseCSV(File csvFile) throws FileNotFoundException {
        try (BufferedReader reader = Files.newBufferedReader(csvFile.toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String surname = data[1];
                String imageFormat = data[2];
                String imageData = data[3];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * returns file obj representing the temp image file
    * */
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


    /*
    * Returns URI representing the local file path of the image file
    * */
    @Override
    public URI createImageLink(File fileImage) {

        URI imageLink = fileImage.toURI(); // obtains the URI version of the fileImage
        return imageLink;
    }
}
