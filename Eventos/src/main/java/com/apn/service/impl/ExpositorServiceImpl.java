package com.apn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apn.model.DatCatalogo;
import com.apn.model.Expositor;
import com.apn.repository.ExpositorRepository;
import com.apn.service.ExpositorService;

@Service
public class ExpositorServiceImpl implements ExpositorService{
	
	
	Logger LOGGER = LoggerFactory.getLogger(ExpositorServiceImpl.class);
	
	@Autowired
	ExpositorRepository expositorRepository;

	@Override
	public List<Expositor> loginUsuario(String id) throws Exception {
		return expositorRepository.loginUsuario(id);
	}


}
