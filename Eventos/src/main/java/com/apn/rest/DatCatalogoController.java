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
import com.apn.model.DatGrupoCat;
import com.apn.model.Expositor;
import com.apn.model.UsuarioPuerto;
import com.apn.service.DatCatalogoService;
import com.apn.service.ExpositorService;
import com.apn.type.TipoRespuestaWeb;
import com.apn.util.ExceptionUtil;

@RestController
@RequestMapping(value = "/usuario")

public class DatCatalogoController {
	
	Logger LOGGER = LoggerFactory.getLogger(UsuarioPuertoController.class);
	
	@Autowired
	
	DatCatalogoService catalogoPuertoService;

	@GetMapping(value = "/catalogo/{codigoCatalogo}")
	
	public ResponseEntity<?> listaCatalogo(@PathVariable("codigoCatalogo") String codCatalogo) {

		RespuestaWeb respuestaWeb = new RespuestaWeb();

		try {
			
	
			List<DatCatalogo> oUsuarioCatalogo= catalogoPuertoService.listaCatalogo(codCatalogo);
			
			//for(DatGrupoCat object :  oUsuarioCatalogo.getDatGrupoCat()) {
				
			//}
			
			///LOGGER.info("PUERTO : "+oUsuarioPuerto.get);
			
			respuestaWeb.setTipoRespuesta(TipoRespuestaWeb.CORRECTA);
			respuestaWeb.getParametros().put("codigoCatalogo", oUsuarioCatalogo);
			return ResponseEntity.ok(respuestaWeb);
		} catch (Exception excepcion) {
			LOGGER.error("Error en la Clase: ExpositorController - Metodo: listaCatalogo:", excepcion);
			return ResponseEntity.badRequest().body(ExceptionUtil.controlar(excepcion));
		}
		
	}
}
