package com.ipartek.formacion.uf2216;

public class RevistaException extends Exception {
	
	/**
	 * Excepcion especial que se lanzará si no se introducen los datos de revista,
	 * tal y como se especifican
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR_TITULO = "El título debe ser mayor a 3 caracteres y menor de 150";
	public static final String ERROR_ISBN = "El ISBN debe tener 10 caracteres alfanuméricos exactos";
	public static final String ERROR_NUMPAGINAS = "La revista debe tener 1 página como mínimo";

	public RevistaException (String mensajeError) {
		super(mensajeError);
	}
	
}
