package com.ipartek.formacion.uf2216;

import java.util.Comparator;

/**
 * Comparador para ordenar una colección de revistas por número de páginas
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
