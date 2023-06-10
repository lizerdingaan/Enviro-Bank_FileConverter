package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.unitTests;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services.AccountHolderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@SpringBootTest
public class AccountHolderUnittests {

    @Autowired
    private AccountHolderService accountHolderService;


    @Test
    @DisplayName("Validating the image data string")
    void testImageFormatData(){
        String value = accountHolderService.imageFormatAndData("a", "b", "c");

        assertThat(value).isEqualTo("a | b | c");
        assertThat(value).isNotNull();
    }

    @Test
    @DisplayName("Validating the image uri generator")
    void testImageLink() throws IOException {
        File tempFile = Files.createTempFile("image", ".jpg").toFile();
        URI imageLink = accountHolderService.createImageLink(tempFile);

        assertThat(imageLink).isNotNull();
        assertThat(imageLink).isEqualTo(tempFile.toURI());

    }

    @Test
    @DisplayName("Validate conversion of csv data to image")
    void testCsvDataToImage(){
    }
}
