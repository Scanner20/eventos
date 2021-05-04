package com.apn.service;
import java.util.List;

import com.apn.model.Expositor;
import com.apn.model.UsuarioPuerto;

public interface UsuarioPuertoService {
	
	List<UsuarioPuerto> listaPuertos(String lp) throws Exception;
	
}
