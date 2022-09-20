package com.example.tarea.application.service;

import com.example.tarea.application.service.dto.TareaInputDTO;
import com.example.tarea.application.service.mapper.TareaInputDTOCreateMapper;
import com.example.tarea.domain.entity.EstadoTarea;
import com.example.tarea.domain.entity.Tarea;
import com.example.tarea.infrastruture.exception.Exception;
import com.example.tarea.domain.repository.TareaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TareaService {

	private final TareaRepository tareaRepository;
	private final TareaInputDTOCreateMapper tareaInputDTOCreateMapper;

	public Tarea getById(Long id) {
		Tarea tarea= this.tareaRepository.getById(id);
		if(tarea==null){
			throw new Exception("Tarea no encontrada", HttpStatus.NOT_FOUND);
		}
		return tarea;
	}


	public List<Tarea> list() {
		return this.tareaRepository.list();
	}


	public Tarea add(TareaInputDTO tareaInputDTO) {
		return this.tareaRepository.add(this.tareaInputDTOCreateMapper.map(tareaInputDTO));
	}

	public Tarea update(Tarea tarea) {
		return this.tareaRepository.update(tarea);
	}

	public void delete(Long id) {
		Tarea tarea=this.getById(id);
		this.tareaRepository.delete(tarea);
	}

	public List<Tarea> listByEstado(EstadoTarea estadoTarea){
		return this.tareaRepository.listByEstado(estadoTarea);
	};

	@Transactional
	public void updateTareaAsFinalizada(Long id){
		this.getById(id);
		this.tareaRepository.updateTareaAsFinalizada(id);
	}

}
