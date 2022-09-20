package com.example.tarea.application.service.mapper;

import com.example.tarea.application.service.dto.TareaInputDTO;
import com.example.tarea.domain.entity.EstadoTarea;
import com.example.tarea.domain.entity.Tarea;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TareaInputDTOCreateMapper implements Mapper<TareaInputDTO, Tarea> {
	@Override
	public Tarea map(TareaInputDTO tareaInputDTO) {
		return new Tarea()
			.setTitulo(tareaInputDTO.getTitulo())
			.setDescripcion(tareaInputDTO.getDescripcion())
			.setFechaCreacion(LocalDateTime.now())
			.setFechaTerminacionEstimada(tareaInputDTO.getFechaTerminacionEstimada())
			.setFinalizada(false)
			.setEstadoTarea(EstadoTarea.ON_TIME);
	}
}
