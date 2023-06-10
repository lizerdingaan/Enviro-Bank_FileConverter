package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.repository;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.entities.AccountProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountProfileEntity, String> {
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AccountProfileEntity a WHERE a.accountHolderName = :nameValue")
    boolean existsByName(@Param("nameValue") String nameValue);
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AccountProfileEntity a WHERE a.accountHolderSurname = :surnameValue")
    boolean existsBySurname(@Param("surnameValue") String surnameValue);
    AccountProfileEntity findAccountProfileEntityByAccountHolderName(String accountHolderName);
    AccountProfileEntity findAccountProfileEntityByAccountHolderSurname(String accountHolderSurname);

    AccountProfileEntity findAccountProfileEntityByAccountHolderNameAndAccountHolderSurname(String accountHolderName, String accountHolderSurname);


}
