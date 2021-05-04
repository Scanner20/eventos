package com.apn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apn.model.DatCatalogo;
import com.apn.service.DatCatalogoService;
import com.apn.repository.CatalogoRepository;;


@Service
public class DatCatalogoServiceImpl implements DatCatalogoService {
	
	Logger LOGGER = LoggerFactory.getLogger(UsuarioPuertoServiceImpl.class);
	
	@Autowired
	 
	CatalogoRepository catalogoRepository;

	@Override
	public List<DatCatalogo> listaCatalogo(String codCatalogo) throws Exception {
		 return catalogoRepository.listaCatalogo(codCatalogo);

	}

}
