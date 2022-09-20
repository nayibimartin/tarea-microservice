package com.example.tarea.infrastruture.persistence;

import com.example.tarea.domain.entity.EstadoTarea;
import com.example.tarea.domain.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaJPARepository extends JpaRepository<Tarea, Long> {
	List<Tarea> findAllByEstadoTarea(EstadoTarea estadoTarea);

	@Modifying
	@Query(value = "update tarea set finalizada=true where id=:id", nativeQuery = true)
	void markTareaAsFinalizada(@Param("id") Long id);
}
