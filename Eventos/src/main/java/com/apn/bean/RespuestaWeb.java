package com.apn.bean;

import java.util.HashMap;
import java.util.Map;

import com.apn.type.TipoRespuestaWeb;

import static java.text.MessageFormat.format;


public class RespuestaWeb {

	 private static final long serialVersionUID = 1L;
	    private int codigoRespuesta;
	    private String mensajeRespuesta;
	    private Map<String, Object> parametros;
	    
	    public RespuestaWeb() {
	    
	    	   parametros = new HashMap<String, Object>();
	    }
	    
	    public Map<String, Object> getParametros() {
	        if(parametros==null){
	            parametros = new HashMap<String, Object>();
	        }
	        return parametros;
	    }
	    
	    public void setTipoRespuesta(TipoRespuestaWeb tipoRespuestaWeb) {
	        this.codigoRespuesta = tipoRespuestaWeb.getCodigo();
	        this.mensajeRespuesta = tipoRespuestaWeb.getMensaje();
	    }
	    
	    public void setTipoRespuesta(TipoRespuestaWeb tipoRespuestaWeb, String idError) {
	        this.codigoRespuesta = tipoRespuestaWeb.getCodigo();
	        this.mensajeRespuesta = format(tipoRespuestaWeb.getMensaje(), idError);
	    }

		public int getCodigoRespuesta() {
			return codigoRespuesta;
		}

		public void setCodigoRespuesta(int codigoRespuesta) {
			this.codigoRespuesta = codigoRespuesta;
		}

		public String getMensajeRespuesta() {
			return mensajeRespuesta;
		}

		public void setMensajeRespuesta(String mensajeRespuesta) {
			this.mensajeRespuesta = mensajeRespuesta;
		}

		public void setParametros(Map<String, Object> parametros) {
			this.parametros = parametros;
		}
	    
	    
}
