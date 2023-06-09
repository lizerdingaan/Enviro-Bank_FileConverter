package com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.controllers;

import com.enviro.assessment.grad001.tshegofatsodingaan.EnviroBank.services.AccountHolderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    private final AccountHolderService accountHolderService;

    public ImageController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }


    @GetMapping(value = "/{name}/{surname}")
    public void gethttpImageLink(@PathVariable String name, @PathVariable String surname){
        System.out.println("Hello world");

    }
}
