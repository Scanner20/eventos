package com.apn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apn.model.DatCatalogo;
import com.apn.model.Expositor;

@Repository
public interface ExpositorRepository extends CrudRepository<Expositor,String> {
	
	@Query(value=" select * from expositor ", nativeQuery = true)
	List<Expositor>loginUsuario(@Param("id") String id);
	
}
