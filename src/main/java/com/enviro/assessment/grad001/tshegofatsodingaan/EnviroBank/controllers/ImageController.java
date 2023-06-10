package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.controllers;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services.AccountHolderService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
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
    public ResponseEntity<FileSystemResource> gethttpImageLink(@PathVariable String name, @PathVariable String surname){

        if(accountHolderService.doesNameExist(name) && accountHolderService.doesSurnameExist(surname)){
            String uri = accountHolderService.getUriByNameAndSurname(name, surname);
            FileSystemResource fileSystemResource = new FileSystemResource(uri);
            return ResponseEntity
                    .ok()
                    .contentType(uri.contains(".jpg") || uri.contains(".jpeg") ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG)
                    .body(fileSystemResource);
        }

        return ResponseEntity.notFound().build();
    }
}
