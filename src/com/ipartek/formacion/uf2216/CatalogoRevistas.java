package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * 
 * Aplicación para guardar un catálogo de revistas.
 * Permite introducir nuevas revistas, mostrar el catálogo actual y guardar en fichero de texto
 * 
 * @author Jon
 *
 */
public class CatalogoRevistas {

	private static Revista revistaNueva;
	public static Scanner sc = new Scanner(System.in);
	private static ArrayList<Revista> listaRevistas = new ArrayList<Revista>();
	
	private static final String MOSTRAR_CATALOGO = "1";
	private static final String INTRODUCIR_REVISTA = "2";
	private static final String GUARDAR_CATALOGO = "3";
	private static final String SALIR = "0";

	
	/**
	 * Crea un objeto Revista y pide datos por teclado para rellenar sus atributos
	 * Si se introduce mal un dato lo volverá a pedir hasta introducirlo bien.
	 * Una vez introducidos los datos, muestra un resumen de estos y pregunta si se desea guardar en listado o cancelar
	 */
	private static void nuevaRevista() {
		
		
		revistaNueva = new Revista();
		
		System.out.println("\nIntroduzca los datos de la revista");
		
		boolean insertado = true;
		
		do {
			insertado = insertarTitulo();	
		} while (!insertado);
		
		do {
			insertado = insertarIsbn();
		} while (!insertado);
		
		do {
			insertado = insertarNumPaginas();	
		} while (!insertado);

		
		String aux = "";
		
		do {
			System.out.println("\nIntroduzca formato: \n(1) -> Digital \n(2)-> Papel");
			
			aux = sc.next();
			
			if(aux.equals("1")) {
				revistaNueva.setFormato(true);
			}else if (aux.equals("2")){
				revistaNueva.setFormato(false);
			}else {
				System.out.println("Opcion introducida incorrecta.");
			}
			
			
		}while(!aux.equals("1") && !aux.equals("2"));
		
		System.out.println("\nResumen de datos introducidos");
		System.out.println("------------------------------");
		System.out.printf("%20s %12s %12s %12s","Titulo |", "ISBN|", "Núm. Páginas|", "Formato");
		System.out.println("\n--------------------------------------------");
		System.out.println(revistaNueva.toString());
		
		String confirmacion = "";
		
		do {
			
			System.out.println("Desea guardar la revista?\n(1) -> Sí \n(2) -> No, rehacer");

			confirmacion = sc.next();
			
			if(confirmacion.equals("1")) {
				
				listaRevistas.add(revistaNueva);
				System.out.println("Revista añadida al catálogo.");
				
			}else if (confirmacion.equals("2")){
				
				System.out.println("Operación de introducir revista cancelada.");
				break;
				
			}else {
				System.out.println("Opción introducida incorrecta.");
			}
			
			
		}while(!confirmacion.equals("1") && !confirmacion.equals("2"));
		
		

	}

	/**
	 * Inserta titulo y devuelve true si se ha introducido correctamente
	 * @return boolean true = si se ha introducido bien, false = si ha fallado
	 */
	private static boolean insertarTitulo() {

		boolean resul = false;
		
		try {

			System.out.println("\nIntroduzca el título: ");
			
			revistaNueva.setTitulo(sc.nextLine());
			resul = true;

		} catch (RevistaException e) {

			System.out.println("Lo siento, " + e.getMessage());
			System.out.println("Vuelva a intentarlo");

		} catch (Exception e) {

			System.out.println("Error");
		}

		return resul;
	}

	/**
	 * Inserta ISBN y devuelve true si se ha introducido correctamente
	 * @return boolean true = si se ha introducido bien, false = si ha fallado
	 */
	private static boolean insertarIsbn() {

		boolean resul = false;
		
		try {

			System.out.println("\nIntroduzca el ISBN: ");
			
			revistaNueva.setIsbn(sc.next());
			resul = true;

		} catch (RevistaException e) {

			System.out.println("Lo siento, " + e.getMessage());
			System.out.println("Vuelva a intentarlo");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return resul;
	}
	
	
	/**
	 * Inserta Número de páginas y devuelve true si se ha introducido correctamente
	 * @return boolean true = si se ha introducido bien, false = si ha fallado
	 */
	private static boolean insertarNumPaginas() {

		boolean resul = false;
		
		try {

			System.out.println("\nIntroduzca el número de páginas: ");
			revistaNueva.setNumPaginas(sc.next());
			resul = true;

		} catch (RevistaException e) {

			System.out.println("Lo siento, " + e.getMessage());
			System.out.println("Vuelva a intentarlo");

		} catch (Exception e) {

			System.out.println("Error, debe introducir un número");
		}

		return resul;
	}
	
	private static void listado() {
		
		if(listaRevistas.size() > 0) {
			
			Collections.sort(listaRevistas, new ComparadorRevistas());
			
			System.out.println("            CATALOGO DE REVISTAS ");
			System.out.println("-----------------------------------------------------");
			System.out.printf("%20s %12s %12s %12s","Titulo |", "ISBN|", "Núm. Páginas|", "Formato");
			System.out.println("\n--------------------------------------------------------------------------------------");
			System.out.println("");
			for(Revista revista : listaRevistas) {
				
				System.out.println(revista);
			}
			
		}else {
			
			System.out.println("No hay revistas en el catálogo.");
		}
		

		
	}
	
	/**
	 * Guarda el catálogo actual en un fichero de texto
	 * Se guardará en la raiz del proyecto donde se ejecute
	 */
	private static void guardarCatalogo() {
		
		try{
			
    		FileWriter almacen = new FileWriter("catalogo.txt");
            BufferedWriter buff = new BufferedWriter(almacen); 
            
            for(Revista revista: listaRevistas) {
            	buff.write(revista.toString()+"\n");
            }
            
            System.out.println("Catálogo guardado con éxito. ");
            buff.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
		
	}
	
	
	/**
	 * Pinta el menú principal
	 */
	private static void menuPrincipal() {
		
		System.out.println("\n--------------------------------------------------"
				+ "\n        Introduce la opción que quieras:"
				+ "\n\n            1 -> Ver Catálogo"
				+ "\n            2 -> Introducir nueva revista" 
				+ "\n            3 -> Guardar revista" 
				+ "\n\n            0 -> Salir" 
				+ "\n\n--------------------------------------------------" 
				+ "\n\nIntroduzca número: ");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido al Catálogo de revistas");
		System.out.println("----------------------------------");
		
		
		String opcion = "0";
		
		do {
			
			menuPrincipal();
			
			opcion = sc.next();
			
			sc = new Scanner(System.in);
			
			switch(opcion) {
			
				case MOSTRAR_CATALOGO:
					listado();
					break;
					
				case INTRODUCIR_REVISTA:
					nuevaRevista();
					break;	
				
				case GUARDAR_CATALOGO:
					guardarCatalogo();
					break;
					
				case SALIR:
					System.out.println("Hasta pronto");
					break;	
	
				default:
					System.out.println("Introduzca una opción correcta (número del 1 al 3 ó 0 para salir)");
			}
			
		}while(!opcion.equals(SALIR));
		
		sc.close();
	}

}
