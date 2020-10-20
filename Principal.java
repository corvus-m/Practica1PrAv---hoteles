package triLazy;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import java.util.Scanner;
import java.util.Vector;

public class Principal {








	static int diasEstancia(String fecha1, String fecha2) {   //pues calcular los dias

		LocalDate inicio = LocalDate.parse(fecha1);
		LocalDate fin = LocalDate.parse(fecha2);

		return (int)ChronoUnit.DAYS.between(inicio, fin);
	}




	static int conAntelacion( String fecha) {   //pues calcular los dias

		LocalDate inicio = LocalDate.now();
		LocalDate fin = LocalDate.parse(fecha);

		return (int)ChronoUnit.DAYS.between(inicio, fin);
	}





	static int hayOferta(int personas, int estancia, int antelacion, Scanner sc) {		//comprueba si entra en oferta de familia, por reserva con antelacion y por dias de estancia

		int descuento=0;
		char c;



		if (personas>4) {
			System.out.print("Son familia numerosa?s/n");
			do {
				c = sc.next().charAt(0);
			}while(c!='s'&& c!='n');

			if (c=='s') 
				descuento += 11;	
		}

		if(estancia>=15) 
			descuento += 5;

		if(antelacion>180)
			descuento += 5;

		return descuento;


	}





	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char opcion;
		int personas, oferta, presupuesto;
		Vector<Hotel> hoteles= new Vector<Hotel>();
		
		//Hoteles para ejemplificar
		Hotel ejemplo1 = new Hotel("Ritas palace", 4, "Barcelona, calle del cordero");
		Hotel ejemplo2 = new Hotel("Paco palace", 2, "Barcelona, calle no se");
		Hotel ejemplo3 = new Hotel("El royal", 4, "Avila, calle: Me he perdido");
		Hotel ejemplo4 = new Hotel("Mi casa", 1, "Madrid, calle de todos");

		ejemplo1.anade_hab("Standar", 2, 1);
		ejemplo1.anade_hab("Doble standar", 4, 2);
		ejemplo1.anade_hab("Individual", 1, 0);
		ejemplo1.anade_hab("Familia grande", 0, 4);
		ejemplo1.anade_hab("Pareja", 0, 1);

		
		ejemplo2.anade_hab("Stndr", 2, 1);
		ejemplo2.anade_hab("Doble stndr", 4, 2);
		ejemplo2.anade_hab("Individul", 1, 0);
		ejemplo2.anade_hab("Fmili grnde", 0, 4);
		ejemplo2.anade_hab("Prej", 0, 1);

		ejemplo3.anade_hab("incredible", 1, 1);
		ejemplo3.anade_hab("Agua", 2, 2);
		ejemplo3.anade_hab("Fuego", 1, 0);
		ejemplo3.anade_hab("Aire", 0, 5);
		ejemplo3.anade_hab("Tierra", 2, 0);

		
		ejemplo4.anade_hab("Otra", 4, 1);
		ejemplo4.anade_hab("Otra mas", 4, 2);
		ejemplo4.anade_hab("Individual", 1, 0);
		ejemplo4.anade_hab("Familia numerosa", 0, 4);
		ejemplo4.anade_hab("Another one", 0, 1);

		hoteles.add(ejemplo1);
		hoteles.add(ejemplo2);
		hoteles.add(ejemplo3);
		hoteles.add(ejemplo4);
		
	

		String fecha1;
		String fecha2;


		System.out.print("Bienvenido usuario, dinos lo que buscas y encontraremos para ti el hotel ideal\n\n¿Que fechas tienes pensado quedarte?"
				+ " aaaa-mm-dd\nDesde:");	//cambiar formato de entrada a dd-mm-aaaa

		fecha1 = sc.nextLine();

		System.out.print("Hasta:");

		fecha2 = sc.nextLine();




		int estancia = diasEstancia(fecha1, fecha2);
		System.out.print("Estancia:" + estancia + "\n");

		int antelacion = conAntelacion(fecha1);
		System.out.print("Antelacion:" + antelacion + "\n");
		System.out.print("¿Para cuantas personas es la reserva?");

		do {
			personas = sc.nextInt();
		}while( personas<=0);


		int descuento = hayOferta( personas,  estancia,  antelacion, sc);




		//Empiezan filtros

		System.out.println("¿Quieres mirar Todos los Hoteles disponibles o con maximo de Precio?t/p:");

		char car;	
do {
		 car = sc.next().charAt(0);
	}while(car!='t'&& car!='p');
	


System.out.print("Descuento: " + descuento);


		if(car=='p'){
			System.out.print("\n¿Con que presupuesto quieres buscar? introduce el valor a continuacion:");

				presupuesto = sc.nextInt();
				System.out.println("\nPresupuesto: " + presupuesto);


			if (descuento!=0) {	//caso con descuento
			//	System.out.println("entra en desc");
				for(Hotel elem: hoteles) {	System.out.println("Algo");
					elem.filtra_Hotel(personas, presupuesto, estancia, descuento);  //mirara dentro de cada hotel habitaciones que cumplan x condiciones
				}
				
			}
			
			else { //caso sin descuento
				for(Hotel elem: hoteles){
					elem.filtra_Hotel(personas, presupuesto, estancia);
					}
				}
				

		}	 //END IF

		
		
		else {

			for(Hotel elem: hoteles)
				elem.muestra_Hotel(estancia);

			
		}





		sc.close();

	}

}





//antiguo codigo de re

//System.out.println("Bienvenido usuario, dinos lo que buscas y encontraremos para ti el hotel ideal\n\n¿Que fechas tienes pensado quedarte? Desde, Día:");
//do {
//	dia = sc.nextInt();
//}while( dia<=0||dia>31);
//
//System.out.println("Del mes:");
//do {
//	mes = sc.nextInt();
//}while( mes<=0||mes>12);
//
//System.out.println("Anio:");
//do {
//	anio = sc.nextInt();
//}while( anio<=2020);
//
//System.out.println("Hasta el Día:");
//do {
//	dia2 = sc.nextInt();
//}while( dia2<=0||dia2>31);
//
//System.out.println("Del mes:");
//do {
//	mes2 = sc.nextInt();
//}while( mes2<=0||mes2>12);
//
//System.out.println("Anio:");
//do {
//	anio2 = sc.nextInt();
//}while( anio2<=2020);


//
//while (sc.hasNext()) {
//    int i = 0;
//    fecha1[i] = sc.next();

//
//
//
//
//
//int diasEstancia(String[] fecha1, String[] fecha2) {   //pues calcular el dia
//	
//	//set(f, value) changes calendar field f to value.
//	
//	Calendar cal1= Calendar.getInstance(); //se pone a la fecha actual como inicializacion
//	Calendar cal2= Calendar.getInstance();
//	cal1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha1[0]));
//	cal1.set(Calendar.MONTH, Integer.parseInt(fecha1[1]));
//	cal1.set(Calendar.YEAR, Integer.parseInt(fecha1[2]));
//
//	cal2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha2[0]));
//	cal2.set(Calendar.MONTH, Integer.parseInt(fecha2[1]));
//	cal2.set(Calendar.YEAR, Integer.parseInt(fecha2[2]));
//	
//}

//    if (!sc.hasNext()) {	//es verdadero mientras sc tenga otro token
//        sc.close();
//        break;
//    }
//    i++;
//}