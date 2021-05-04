package com.apn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apn.model.DatCatalogo;
import com.apn.model.Expositor;
import com.apn.model.UsuarioPuerto;

@Repository
public interface CatalogoRepository extends CrudRepository<DatCatalogo,String> {
	
	@Query(value=" select * from datcatalogo where cod_catalogo =:cod", nativeQuery = true)
	List<DatCatalogo> listaCatalogo(@Param("cod") String codCatalogo);
	
	
}
