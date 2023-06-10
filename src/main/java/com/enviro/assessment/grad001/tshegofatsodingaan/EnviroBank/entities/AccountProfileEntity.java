package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.entities;

import jakarta.persistence.*;

@Entity
@Table
public class AccountProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String accountHolderName;
    private String accountHolderSurname;
    private String httpImageLink;


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderSurname() {
        return accountHolderSurname;
    }

    public void setAccountHolderSurname(String accountHolderSurname) {
        this.accountHolderSurname = accountHolderSurname;
    }

    public String getHttpImageLink() {
        return httpImageLink;
    }

    public void setHttpImageLink(String httpImageLink) {
        this.httpImageLink = httpImageLink;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AccountProfileEntity{" +
                "id=" + id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountHolderSurname='" + accountHolderSurname + '\'' +
                ", httpImageLink='" + httpImageLink + '\'' +
                '}';
    }
}
