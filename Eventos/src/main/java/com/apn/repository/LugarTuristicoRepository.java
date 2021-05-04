package com.apn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apn.model.LugarTuristico;

@Repository
public interface LugarTuristicoRepository extends CrudRepository<LugarTuristico,String> {
	
	@Query(value=" select * from lugarturistico", nativeQuery = true)
	List<LugarTuristico>loginUsuario(@Param("id") String id);
	
}
