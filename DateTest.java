package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class DateTest {


	@Test
	void testdiasEstancia() {
		assertEquals(15 , Principal.diasEstancia("2020-11-16", "2020-12-01"));
	}
	
	


	
	@Test
	void testAntelacionReserva() {		//he modificado la funcion para que pueda comparar bien
		Calendar c = Calendar.getInstance();
		int aux;
		if(c.get(Calendar.MONTH) == 9)	//anteriormente el test estaba incorrectamente implementado puesto que el mes de octubre es 9 no 10 (meses de 0 a 11)
			aux = 22 - (c.get(Calendar.DATE)-19);//a dia 19 de octubre tenia 22 dias hasta la fecha reservada
		else if(c.get(Calendar.MONTH) == 10) 
			aux = 22 -12 -(c.get(Calendar.DATE)) ;
		else if(c.get(Calendar.MONTH) == 11)
			aux = 22 - 12 - 30 - (c.get(Calendar.DATE));
		else return;//si es otro año, habra que cambiar cosas del test para que funcione correctamente la comparacion
		
		assertEquals(aux , Principal.conAntelacion("2020-11-10"));
	}

}
