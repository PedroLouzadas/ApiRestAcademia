package com.residencia.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	TurmaService turmaService;
	
	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma(){
		return new ResponseEntity<>(turmaService.findAllTurma(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> findTurmaById(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if(null == turma)
			throw new NoSuchElementFoundException("Não foi encontrada Turma com o id " + id);
		else
			return new ResponseEntity<>(turmaService.findTurmaById(id), HttpStatus.OK);
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<TurmaDTO> findTurmaDTOById(@PathVariable Integer id) {
		TurmaDTO turmaDTO = turmaService.findTurmaDTOById(id);
		return new ResponseEntity<>(turmaDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma){
		return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
	}

	@PostMapping("/dto")
	public ResponseEntity<TurmaDTO> saveTurmaDTO(@RequestBody TurmaDTO turmaDTO){
		TurmaDTO turmadto = turmaService.saveTurmaDTO(turmaDTO);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Turma> uptadeTurma(@RequestBody Turma turma){
		return new ResponseEntity<>(turmaService.updateTurma(turma), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Integer id){
		Turma turma = turmaService.findTurmaById(id);
		if(null == turma)
			throw new NoSuchElementFoundException("Não foi encontrada Turma com o id " + id);
		turmaService.deleteTurma(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
