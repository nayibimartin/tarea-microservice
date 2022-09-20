package com.example.tarea.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarea")
@Data @AllArgsConstructor @NoArgsConstructor
@Accessors(chain = true)
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titulo;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaTerminacionEstimada;
	private Boolean finalizada;
	private EstadoTarea estadoTarea;

}
