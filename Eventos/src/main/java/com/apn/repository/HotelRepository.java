package com.apn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apn.model.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel,String> {
	
	@Query(value=" select * from hotel", nativeQuery = true)
	List<Hotel>loginUsuario(@Param("codigo") String codigo);
	
}
