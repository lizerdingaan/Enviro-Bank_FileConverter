package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.converter;

import java.io.*;
import java.net.URI;

public class CSVFileParser implements FileParser{
    @Override
    public void parseCSV(File csvFile) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        return null;
    }

    @Override
    public URI createImageLink(File fileImage) {
        return null;
    }
}
