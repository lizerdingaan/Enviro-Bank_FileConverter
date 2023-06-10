package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.modelTests;


import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.entities.AccountProfileEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AccountProfileTests {

    @Test
    @DisplayName("Test account holder name")
    void testAccountHolderName(){
        AccountProfileEntity accountProfileEntity = new AccountProfileEntity();
        accountProfileEntity.setAccountHolderName("Tshego");

        assertThat(accountProfileEntity.getAccountHolderName()).isNotNull();
    }

    @Test
    @DisplayName("Test account holder surname")
    void testAccountHolderSurname(){
        AccountProfileEntity accountProfileEntity = new AccountProfileEntity();
        accountProfileEntity.setAccountHolderSurname("Dingaan");

        assertThat(accountProfileEntity.getAccountHolderSurname()).isNotNull();
    }

    @Test
    @DisplayName("Test image http link")
    void testImageHttpLink(){
        AccountProfileEntity accountProfileEntity = new AccountProfileEntity();
        accountProfileEntity.setHttpImageLink("/hello/world");

        assertThat(accountProfileEntity.getHttpImageLink()).isNotNull();
    }

}
