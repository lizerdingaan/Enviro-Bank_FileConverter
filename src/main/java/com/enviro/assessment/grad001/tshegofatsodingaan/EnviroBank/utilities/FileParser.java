package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile) throws FileNotFoundException;
    File convertCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
}
