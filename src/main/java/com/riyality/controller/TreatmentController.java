package com.riyality.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.constants.MessageConstants;
import com.riyality.dto.patient.TreatmentRequestDto;
import com.riyality.dto.patient.TreatmentResponceDto;
import com.riyality.service.impl.TreatmentServiceImp;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {
   @Autowired
	private TreatmentServiceImp service;
   
   @PostMapping
   public ResponseEntity<String> addTreatments( @RequestBody List<TreatmentRequestDto> dtos) {
       boolean allSuccessful = true;
       
           boolean isAdded = service.addTreatment(dtos);
           if (!isAdded) {
               allSuccessful = false;
         
           }
       if (allSuccessful) {
           return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_TREATMENT_SUCCESS_M);
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_TREATMENT_ERROR);
       }
   }
   
   @GetMapping("/list/{admission}")
   public ResponseEntity<List<TreatmentResponceDto>> TreatmentList(@PathVariable Long admission){
	   return ResponseEntity.status(HttpStatus.OK).body(service.allTreatments(admission));
   }
}
