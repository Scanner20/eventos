package com.apn.service;

import java.util.List;

import com.apn.model.DatCatalogo;


public interface DatCatalogoService {

	List<DatCatalogo> listaCatalogo(String cod) throws Exception;
	
}
