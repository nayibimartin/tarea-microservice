package com.example.tarea.infrastruture.persistence.postgresql;

import com.example.tarea.domain.entity.EstadoTarea;
import com.example.tarea.domain.entity.Tarea;
import com.example.tarea.domain.repository.TareaRepository;
import com.example.tarea.infrastruture.persistence.TareaJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TareaPostgreSQLRepository implements TareaRepository {

	private final TareaJPARepository tareaJPARepository;

	@Override
	public Tarea getById(Long id) {
		return this.tareaJPARepository.findById(id).orElse(null);
	}

	@Override
	public List<Tarea> list() {
		return this.tareaJPARepository.findAll();
	}

	@Override
	public List<Tarea> listByEstado(EstadoTarea estadoTarea) {
		return this.tareaJPARepository.findAllByEstadoTarea(estadoTarea);
	}

	@Override
	public Tarea add(Tarea tarea) {
		return this.tareaJPARepository.save(tarea);
	}

	@Override
	public Tarea update(Tarea tarea) {
		return this.tareaJPARepository.save(tarea);
	}

	@Override
	public void delete(Tarea tarea) {
		this.tareaJPARepository.delete(tarea);
	}

	@Override
	public void updateTareaAsFinalizada(Long id) {
		this.tareaJPARepository.markTareaAsFinalizada(id);
	}
}
