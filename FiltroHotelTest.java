package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FiltroHotelTest {


	
	Hotel hot = new Hotel("Ritas palace", 4, "Barcelona, calle del cordero");


//este test es el desarrollo del HotelTest (anteriormente no implementado) en una clase hija, de forma que comprueba el filtro del hotel como el de Hotel
	
	@Test
	void test() {
		

		hot.anade_hab("Standar", 2, 1);
		hot.anade_hab("Individual", 1, 0);
		hot.anade_hab_suite("Individual", 1, 0, 4);
		hot.anade_hab("Doble standar", 4, 4);
		hot.anade_hab_suite("Familia grande", 0, 4, 3);
		hot.anade_hab("Magnifica", 2, 2);

		int dias=4;
		System.out.println("\n\n\n" + hot.habitaciones.get(0).calcular_precio()*dias);	//imprimo los precios para luego comprobar si el filtro funciona bien
		System.out.println(hot.habitaciones.get(1).calcular_precio()*dias);
		System.out.println(hot.habitaciones.get(2).calcular_precio()*dias);
		System.out.println(hot.habitaciones.get(3).calcular_precio()*dias);
		System.out.println(hot.habitaciones.get(4).calcular_precio()*dias);
		System.out.println(hot.habitaciones.get(5).calcular_precio()*dias + "\n\n");
		
		//sabiendo que los precios son 116.0, 80.0, 104.8, 208.0, 180.39999999999998, 136.0

		assertEquals(3, hot.filtra_Hotel(1, 125, dias) );
		


		System.out.println("\n\n\n" + hot.habitaciones.get(0).calcular_precio()*dias*0.9);	//imprimo los precios para luego comprobar si el filtro funciona bien
		System.out.println(hot.habitaciones.get(1).calcular_precio()*dias*0.9);
		System.out.println(hot.habitaciones.get(2).calcular_precio()*dias*0.9);
		System.out.println(hot.habitaciones.get(3).calcular_precio()*dias*0.9);
		System.out.println(hot.habitaciones.get(4).calcular_precio()*dias*0.9);
		System.out.println(hot.habitaciones.get(5).calcular_precio()*dias*0.9 +"\n\n");
		
		//sabiendo que los precios son 104.4, 72.0, 94.32, 187.20000000000002, 162.35999999999999, 122.4
		assertEquals(4, hot.filtra_Hotel(1, 125, dias, 10));
	}
}
