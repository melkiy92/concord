package com.example.concord.controllers;

import com.example.concord.dtos.IdDTO;
import com.example.concord.dtos.FioDTO;
import com.example.concord.services.Encryptor;
import com.example.concord.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Encryptor encryptor;
    private static final Logger log = Logger.getLogger(UserController.class);

    @PostMapping("/fio")
    public ResponseEntity<FioDTO> findFio(@RequestBody IdDTO idDTO) {
        String encryptedId = encryptor.encryptText(idDTO.toString());
        String decryptedId = encryptor.decryptText(encryptedId);
        FioDTO fioDTO;
        try {
            fioDTO  = userService.findFio(idDTO);
        } catch (NoSuchElementException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String encryptedFio = encryptor.encryptText(fioDTO.toString());
        String decryptedFio = encryptor.decryptText(encryptedFio);
        log.info("\n" + "Request: " + idDTO.toString() + "\n" + "=== encryption id: " +  encryptedId + "\n" + "=== decryption id: " +  decryptedId + "\n" +
                "Response: " + fioDTO.toString()  + "\n" + "=== encryption fio: " +  encryptedFio + "\n" + "=== decryption fio: " +  decryptedFio );
        return new ResponseEntity<>(fioDTO, HttpStatus.CREATED);
    }

}
