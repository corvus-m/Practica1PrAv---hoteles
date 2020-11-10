package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//
//private boolean distribucion_camas(int personas) {
//	
//	return ((this.getCamas_ind() + this.getCamas_matrimonio()*2) >= personas)? true: false;
//
//}

class DistribucionTest {	//las funciones calcular_precio y distribucion_camas he tenido que hacerlas publicas para los test
	Habitacion algo= new Habitacion("habi de hasta 8", 4, 2);	//4 ind y 2 matri
	Habitacion alga= new Habitacion("habi de hasta 8", 6, 0);
	@Test
	void testDistribucion() {
		assertEquals(true , algo.distribucion_camas(8,true));
		assertEquals(false , algo.distribucion_camas(9,true));
	}
	
	@Test
	void testDistribucion2() {
		assertEquals(false , alga.distribucion_camas(6,true));
		assertEquals(true , alga.distribucion_camas(6,false));
	}
	

}
