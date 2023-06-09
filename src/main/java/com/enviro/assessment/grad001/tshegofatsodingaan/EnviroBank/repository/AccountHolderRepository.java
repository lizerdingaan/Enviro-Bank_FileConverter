package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.repository;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.entities.AccountProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountProfileEntity, String> {

    String findAccountProfileEntityByAccountHolderName(String accountHolderName);
    String findAccountProfileEntityByAccountHolderSurname(String accountHolderSurname);
    String findAccountProfileEntityByHttpImageLink(String httpImageLink);

}
