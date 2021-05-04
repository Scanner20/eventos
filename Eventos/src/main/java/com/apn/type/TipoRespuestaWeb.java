package com.apn.type;

public enum TipoRespuestaWeb {
	CORRECTA(1, "La accion se ha ejecutado correctamente."),
	ERROR(-1, "OcurriÃ³ un error inesperado con ID {0}, por favor informar al Ã¡rea correspondiente.");

	private final int codigo;

	private final String mensaje;

	private TipoRespuestaWeb(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}
}
