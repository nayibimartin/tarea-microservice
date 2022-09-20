package com.example.tarea.domain.repository;

import com.example.tarea.domain.entity.EstadoTarea;
import com.example.tarea.domain.entity.Tarea;

import java.util.List;

public interface TareaRepository {
	Tarea getById(Long id);
	List<Tarea> list();
	List<Tarea> listByEstado(EstadoTarea estadoTarea);
	Tarea add(Tarea tarea);
	Tarea update(Tarea tarea);
	void delete(Tarea tarea);
	void updateTareaAsFinalizada(Long id);
}
