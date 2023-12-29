package com.example.cagt_be.controller;

import com.example.cagt_be.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @GetMapping("/dash-board/mom-joke")
    public ResponseEntity getMomJoke() throws Exception {
        System.out.println("Api called");
        return new ResponseEntity<>(dashBoardService.getMomJoke(), HttpStatus.OK);
    }
}
