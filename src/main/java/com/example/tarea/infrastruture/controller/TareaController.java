package com.example.tarea.infrastruture.controller;

import com.example.tarea.application.service.TareaService;
import com.example.tarea.application.service.dto.TareaInputDTO;
import com.example.tarea.domain.entity.EstadoTarea;
import com.example.tarea.domain.entity.Tarea;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@AllArgsConstructor
public class TareaController {

	private final TareaService tareaService;

	@PostMapping
	public ResponseEntity<Tarea> add(@RequestBody TareaInputDTO tareaInputDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.tareaService.add(tareaInputDTO));
	}

	@GetMapping
	public ResponseEntity<List<Tarea>> list(){
		List<Tarea> tareas=this.tareaService.list();
		if(tareas.isEmpty()){
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tareas);
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Tarea>> listByEstado(@PathVariable("estado") EstadoTarea estadoTarea){
		List<Tarea> tareas=this.tareaService.listByEstado(estadoTarea);
		if(tareas.isEmpty()){
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tareas);
	}

	@PatchMapping("/finished/{id}")
	public ResponseEntity<Void> updateTareaAsFinalizada(@PathVariable("id") Long id){
		this.tareaService.updateTareaAsFinalizada(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		this.tareaService.delete(id);
		return ResponseEntity.ok().build();
	}
}