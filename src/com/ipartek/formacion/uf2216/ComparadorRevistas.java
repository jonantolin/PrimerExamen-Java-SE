package com.ipartek.formacion.uf2216;

import java.util.Comparator;

/**
 * Comparador para ordenar una colecci�n de revistas por n�mero de p�ginas
 * 
 * @author Jon
 *
 */
public class ComparadorRevistas implements Comparator<Revista> {

	@Override
	public int compare(Revista o1, Revista o2) {
		
		return Integer.parseInt(o1.getNumPaginas()) - Integer.parseInt(o2.getNumPaginas());
	}

}
