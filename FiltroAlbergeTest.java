package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FiltroAlbergeTest {
	Hotel hot = new Hotel("Ritas palace", 4, "Barcelona, calle del cordero");
	
	Albergue Alber = new Albergue("Ritas palace", 4, "Barcelona, calle del cordero", "montaña");


//este test es el desarrollo del FiltroHotelTest (anteriormente no implementado) en una clase hija, de forma que comprueba el filtro del hotel como el de albergue
	
	@Test
	void test() {
		

		Alber.anade_hab("Standar", 2, 1);
		Alber.anade_hab("Individual", 1, 0);
		Alber.anade_hab_suite("Individual", 1, 0, 4);
		Alber.anade_hab("Doble standar", 4, 4);
		Alber.anade_hab_suite("Familia grande", 0, 4, 3);
		Alber.anade_hab("Magnifica", 2, 2);
		
		assertEquals(4, Alber.filtra_Hotel(1, 500, 1) );	//este test es para comprobar si el filtro con instance of suite funciona bien
		
		int dias=4;
		System.out.println("\n\n\n" + Alber.habitaciones.get(0).calcular_precio()*dias);	//imprimo los precios para luego comprobar si el filtro funciona bien
		System.out.println(Alber.habitaciones.get(1).calcular_precio()*dias);
		System.out.println(Alber.habitaciones.get(3).calcular_precio()*dias);
		System.out.println(Alber.habitaciones.get(5).calcular_precio()*dias);
		
		//sabiendo que los precios son 116, 80, 208, 136
		assertEquals(2, Alber.filtra_Hotel(1, 125, dias) );
		
		//sabiendo que los precios son 104.4, 72, 187.2, 122.4 
		System.out.println("\n\n\n" + Alber.habitaciones.get(0).calcular_precio()*dias*0.9);	//imprimo los precios para luego comprobar si el filtro funciona bien
		System.out.println(Alber.habitaciones.get(1).calcular_precio()*dias*0.9);
		System.out.println(Alber.habitaciones.get(3).calcular_precio()*dias*0.9);
		System.out.println(Alber.habitaciones.get(5).calcular_precio()*dias*0.9);
		
		assertEquals(3, Alber.filtra_Hotel(1, 125, dias, 10));
	}

}
