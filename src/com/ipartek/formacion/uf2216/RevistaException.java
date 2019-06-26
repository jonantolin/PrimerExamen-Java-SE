package com.ipartek.formacion.uf2216;

public class RevistaException extends Exception {
	
	/**
	 * Excepcion especial que se lanzar� si no se introducen los datos de revista,
	 * tal y como se especifican
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR_TITULO = "El t�tulo debe ser mayor a 3 caracteres y menor de 150";
	public static final String ERROR_ISBN = "El ISBN debe tener 10 caracteres alfanum�ricos exactos";
	public static final String ERROR_NUMPAGINAS = "La revista debe tener 1 p�gina como m�nimo";

	public RevistaException (String mensajeError) {
		super(mensajeError);
	}
	
}
