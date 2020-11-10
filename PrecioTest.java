package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrecioTest {
	

	Habitacion algo= new Habitacion("Jamon202", 2, 1);
	Suite algoDelux= new Suite("Jamon202 Delux", 2, 1, 4, 5);
	@Test
	void testCalcular_precio() {
		assertEquals((double)34.5, algo.calcular_precio());
	}
	
	@Test
	void testCalcular_precio2() {
		assertEquals( (double)37.3, algoDelux.calcular_precio());
	}

}
