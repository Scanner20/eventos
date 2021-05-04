package com.apn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apn.model.Agenda;
import com.apn.repository.AgendaRepository;
import com.apn.service.AgendaService;

@Service
public class AgendaServiceImpl implements AgendaService{
	
	
	Logger LOGGER = LoggerFactory.getLogger(AgendaServiceImpl.class);
	
	@Autowired
	AgendaRepository agendaRepository;

	@Override
	public List<Agenda> loginUsuario(String id) throws Exception {
		return agendaRepository.loginUsuario(id);
	}


}
