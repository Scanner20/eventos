package com.apn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apn.model.Hotel;
import com.apn.repository.HotelRepository;
import com.apn.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	
	Logger LOGGER = LoggerFactory.getLogger(HotelServiceImpl.class);
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> loginUsuario(String codigo) throws Exception {
		return hotelRepository.loginUsuario(codigo);
	}


}
