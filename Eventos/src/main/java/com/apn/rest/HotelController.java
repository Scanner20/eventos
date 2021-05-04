package com.apn.rest;

import java.util.List;

import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apn.bean.RespuestaWeb;
import com.apn.model.DatCatalogo;
import com.apn.model.Hotel;
import com.apn.service.HotelService;
import com.apn.type.TipoRespuestaWeb;
import com.apn.util.ExceptionUtil;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

	Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	HotelService hotelService;
	
	@GetMapping(value = "/codigo/{codigo}")

	public ResponseEntity<?> loginUsuario(@PathVariable("codigo") String codigo) {

		RespuestaWeb respuestaWeb = new RespuestaWeb();

		try {
			
			
			List<Hotel> oUsuarioCatalogo= hotelService.loginUsuario(codigo);
			

			respuestaWeb.setTipoRespuesta(TipoRespuestaWeb.CORRECTA);
			respuestaWeb.getParametros().put("codigoCatalogo", oUsuarioCatalogo);
			return ResponseEntity.ok(respuestaWeb);
		} catch (Exception excepcion) {
			LOGGER.error("Error en la Clase: HotelController - Metodo: listaCatalogo:", excepcion);
			return ResponseEntity.badRequest().body(ExceptionUtil.controlar(excepcion));
		}
		
	}
}