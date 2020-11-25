package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAnadirValor {

	Habitacion porDefecto= new Habitacion("Habitacion por defecto", 2, 1);
	Habitacion conPiscina= new Habitacion("Habi con piscina", 2, 1);
	Habitacion conTodo= new Habitacion("Habi completa", 2, 1);
	@Test
	void test() {
		assertEquals(0 , porDefecto.anadir_valor());
		assertEquals(34.5, porDefecto.calcular_precio());
	}
	
	@Test
	void test2() {
		conPiscina.setPisc_incluida(true);
		assertEquals(1.5 , conPiscina.anadir_valor());
		assertEquals(36, conPiscina.calcular_precio()); //precio por defecto +1.5
	}
	
	
	@Test
	void test3() {
		conTodo.setPisc_incluida(true);
		conTodo.setIncluye_buffet(true);
		assertEquals(3 , conTodo.anadir_valor());
		assertEquals(37.5, conTodo.calcular_precio());	//precio por defecto +3
	}

}
