package com.apn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apn.model.Expositor;
import com.apn.model.UsuarioPuerto;

@Repository

public interface UsuarioPuertoRepository extends CrudRepository<UsuarioPuerto,String> {

	@Query(value=" select * from usuariopuerto  where cod_usuario =:lp", nativeQuery = true)
	List<UsuarioPuerto> listaPuertos(@Param("lp") String lp);
	
}
