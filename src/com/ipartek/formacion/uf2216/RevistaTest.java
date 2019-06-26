package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaTest {
	
	Revista revista;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		revista = new Revista();
	}

	@After
	public void tearDown() throws Exception {
		revista = null;
	}

	
	@Test
	public void testRevista() throws Exception {
		
		revista = new Revista("Interviu", "A123456789", "100", false);
		
		assertEquals("Interviu", revista.getTitulo());
		assertEquals("A123456789", revista.getIsbn());
		assertEquals("100", revista.getNumPaginas());
		assertFalse(revista.isFormato());
		
	}
	
	
	@Test (expected = Exception.class)
	public void testSetTitulo() throws Exception {
		
		String incorrecto = ".";
		String correcto = "Supercoches";
		
		revista.setTitulo(correcto);
		assertEquals(correcto, revista.getTitulo());
		
		revista.setTitulo(incorrecto);
		revista.setTitulo(null);
		
		
	}

	@Test (expected = Exception.class)
	public void testSetIsbn() throws Exception {
		
		String incorrecto = ".";
		String correcto = "123456789A";
		
		revista.setIsbn(correcto);
		assertEquals(correcto, revista.getIsbn());
		
		revista.setTitulo(incorrecto);
		revista.setTitulo(null);
	}

	@Test (expected = Exception.class)
	public void testSetNumPaginas() throws Exception {
		String incorrecto = "0";
		String correcto = "200";
		
		revista.setIsbn(correcto);
		assertEquals(correcto, revista.getNumPaginas());
		
		revista.setNumPaginas(incorrecto);
		revista.setNumPaginas(null);
	}

	@Test
	public void testSetFormato() {
		
		revista.setFormato(true);
		assertTrue(revista.isFormato());
		
		revista.setFormato(false);
		assertFalse(revista.isFormato());
	}

}
