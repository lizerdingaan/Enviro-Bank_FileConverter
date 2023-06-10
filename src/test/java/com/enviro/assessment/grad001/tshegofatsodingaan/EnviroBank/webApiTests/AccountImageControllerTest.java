package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.webApiTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /v1/api/image/ - successful")
    void testSuccessfulImageGet() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/api/image/Momentum/Health"))
                .andExpect(content().contentType(MediaType.IMAGE_PNG))
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    @DisplayName("GET /v1/api/image/ - not found")
    void testNotFoundImageGet() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/api/image/tshego/Health"))
                .andExpect(status().isNotFound());
    }



}
