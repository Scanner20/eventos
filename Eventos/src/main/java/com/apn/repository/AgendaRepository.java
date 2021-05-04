package com.apn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apn.model.Agenda;

@Repository

public interface AgendaRepository extends CrudRepository<Agenda,String> {
	
	@Query(value=" select " + 
	        "       a.tema," + 
			"       a.id_agenda," + 
	        "       e.nombre AS Nombre," +
			"       e.apellido AS Apellido," + 
			"       a.fecha " + 
			"       from" +
			"       agenda a" + 
			"       inner join expositor e ON a.id_expositor = e.id_expositor", nativeQuery = true)
	
	List<Agenda>loginUsuario(@Param("id") String id);
	
}

