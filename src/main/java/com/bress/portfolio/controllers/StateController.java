package com.bress.portfolio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bress.portfolio.entities.State;
import com.bress.portfolio.services.StateServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/states")
public class StateController extends BaseControllerImpl<State, StateServiceImpl> {
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam Long filtro) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.search(filtro));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
		             .body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}

}
