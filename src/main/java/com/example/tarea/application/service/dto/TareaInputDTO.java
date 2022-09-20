package com.example.tarea.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class TareaInputDTO {
	private String titulo;
	private String descripcion;
	private LocalDateTime fechaTerminacionEstimada;

}
