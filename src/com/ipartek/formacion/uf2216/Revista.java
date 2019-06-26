package com.ipartek.formacion.uf2216;


/**
 * 
 * POJO de una Revista.
 * Consta de atributos: titulo, ISBN, numPáginas y formato
 * 
 * 
 * titulo: String (min 3, max 150) 
 * isbn: String (exactamente 10 caracteres)
 * numPaginas: String (min 1 página que será un digito)
 * format: boolean (true -> "Digital  false-> "Papel")
 * 
 * A su vez los setters controlan que se introducen los datos con las reglas descritas
 * 
 * @author Jon
 *
 */
public class Revista implements Leible {

	private String titulo; //min 3, max 150
	private String isbn; // alfanumerico exactamente 10
	private String numPaginas; // min 1
	private boolean formato; // true = digital, false = papel
	
	public Revista() {
		this.titulo = "Por defecto";
		this.isbn = "1234567890";
		this.numPaginas = "50";
		this.formato = true;
	}
	
	public Revista(String titulo, String isbn, String numPaginas, boolean formato) throws Exception {
		super();
		setTitulo(titulo);
		setIsbn(isbn);
		setNumPaginas(numPaginas);
		setFormato(formato);
	}

	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Establece el titulo
	 * @param titulo String (debe tener entre 3 y 150 caracteres)
	 * @throws Exception Si no tiene esas reglas o es null
	 */
	public void setTitulo(String titulo) throws Exception {
		
		if(titulo != null) {
			
			if(titulo.length() >= 3 && titulo.length() <= 150) {
				this.titulo = titulo;
				
			}else {
				throw new RevistaException(RevistaException.ERROR_TITULO);
			}
			
		}else {
			throw new Exception("Se ha introducido un titulo nulo");
		}
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Establece el ISBN
	 * @param isbn String (Debe tener exactamente 10 caracteres alfanumericos)
	 * @throws Exception Si no tiene esas reglas o es null
	 */
	public void setIsbn(String isbn) throws Exception {
		
		if(titulo != null) {
			
			if(isbn.length() == 10) { 
				
				this.isbn = isbn;
				
			}else {
				
				throw new RevistaException(RevistaException.ERROR_ISBN);
			}
			
		}else {
			throw new Exception("Se ha introducido un isbn nulo");
		}

	}

	public String getNumPaginas() {
		return numPaginas;
	}
	
	
	/**
	 * Establece el número de páginas.
	 * @param numPaginas String (Será un digito, siempre igual o mayor a 1)
	 * @throws Exception Si es una letra, un numero negativo, 0 o null
	 */
	public void setNumPaginas(String numPaginas) throws Exception {
		
		if(titulo != null) {
			
			if(Integer.parseInt(numPaginas) >= 1 ) { 
				
				this.numPaginas = numPaginas;
				
			}else {
				throw new RevistaException(RevistaException.ERROR_NUMPAGINAS);
			}
		}else {
			throw new Exception("Se ha introducido un numero de páginas nulo");
		}
	}
	
	/**
	 * Devuelve true si es digital o false si es papel, se establecera diferencia en toString()
	 * @return boolean true -> Digital , false -> Papel
	 * @see toString()
	 */
	public boolean isFormato() {
		return formato;
	}

	/**
	 * 
	 * @param formato true será "Digital", false "Papel"
	 */
	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		
		String formatoRevista="";
		String resul="";
		
		if(formato) {
			formatoRevista = "Digital";
		}else {
			formatoRevista = "Papel";
		}
		
		
		resul = String.format("%20s | %12s | %12s | %12s", titulo, isbn, numPaginas, formatoRevista);
		return resul;
	}
	
	
	
	
}
