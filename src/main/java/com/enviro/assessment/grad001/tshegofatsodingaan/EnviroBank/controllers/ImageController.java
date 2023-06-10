package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.controllers;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services.AccountHolderService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    private final AccountHolderService accountHolderService;

    public ImageController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }


    @GetMapping(value = "/{name}/{surname}")
    public void gethttpImageLink(@PathVariable String name, @PathVariable String surname){
        /*Optional<String> nameEntity = accountHolderService.getUriByName(name).describeConstable();
        Optional<String> surnameEntity = accountHolderService.getUriBySurname(surname).describeConstable();*/

        /*if(nameEntity.isEmpty() || surnameEntity.isEmpty()){
            return ResponseEntity.notFound().build();
        }*/
        System.out.println(accountHolderService.getUriByName(name));

    }
}
