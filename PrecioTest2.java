package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrecioTest2 {
	
//	private double calcular_precio() {
//		
//		return (double)(this.getEstrellas_hotel()*4) + (this.getCamas_ind()*(2.0+0.5*this.getEstrellas_hotel())) + (this.getCamas_matrimonio()*(3.0+0.5*this.getEstrellas_hotel()));
//		
//		
//		
//	}
	Habitacion algo= new Habitacion("Jamon202", 2, 1);
	@Test
	void testCalcular_precio() {
		assertEquals(algo.calcular_precio(), (double)34.5);
	}
	
	@Test
	void testCalcular_precio2() {
		assertEquals(algo.calcular_precio(), (double)34.5);
	}
	
	void testgetCamas_matrimonio() {
		assertEquals(4, algo.getCamas_matrimonio());
	}

}
