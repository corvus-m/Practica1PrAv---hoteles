package triLazy;

import java.io.IOException;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import java.util.Scanner;
import java.util.Vector;


public class Principal {

//funciones 
	
	static int diasEstancia(String fecha1, String fecha2) {   //pues calcular los dias

		LocalDate inicio = LocalDate.parse(fecha1);
		LocalDate fin = LocalDate.parse(fecha2);

		return (int)ChronoUnit.DAYS.between(inicio, fin);
	}

	static Boolean premioAleatorio(int personas) {
		double num;
		for(int i=0; i<personas; i++) {
			num = Math.random();
			//System.out.print(num); solo para comprobaciones
			if (num <= 1/1000000) return true;
		}
		return false;
	}


	static int conAntelacion( String fecha) {   //pues calcular los dias

		LocalDate inicio = LocalDate.now();
		LocalDate fin = LocalDate.parse(fecha);

		return (int)ChronoUnit.DAYS.between(inicio, fin);
	}





	static int hayOferta(String idioma, int personas, int estancia, int antelacion, Scanner sc) throws IOException {		//comprueba si entra en oferta de familia, por reserva con antelacion y por dias de estancia

		int descuento=0;
		char c;


		if (personas>4) {
			
			if(idioma.equals("es")){
				
				System.out.print("Son familia numerosa? y (si) / n (no): ");

				do {
					c = sc.next().charAt(0);
				}while(c!='y'&& c!='n');

				
			}
			
			else {
			
			
			String texto = "Son familia numerosa? y (si) / n (no): ";
			System.out.print(Translator.translate("es", idioma, texto));
			do {
				c = sc.next().charAt(0);
			}while(c!='y'&& c!='n');

				
		}
			if (c=='y') 
				descuento += 11;
		}

		
		
		if(estancia>=15) 
			descuento += 5;

		if(antelacion>180)
			descuento += 5;

		return descuento;


	}



	//programa principal

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		

		String idioma; //0 = cliente, 1 = empresa/hotel (agrega hoteles), 2 = moderador; 
		int personas, presupuesto;
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


		
		
		System.out.println("Welcome user, select your prefered language. example: 'en' for english"
				+ "\n\nSupported languages:\r\n\n"
				+ "�auto�:��Automatic�, \r\n"
				+ "�af�:�Afrikaans�, \r\n"
				+ "�sq�:�Albanian�, \r\n"
				+ "�ar�:�Arabic�, \r\n"
				+ "�hy�:�Armenian�, \r\n"
				+ "�az�:�Azerbaijani�, \r\n"
				+ "�eu�:�Basque�, \r\n"
				+ "�be�:�Belarusian�, \r\n"
				+ "�bn�:�Bengali�, \r\n"
				+ "�bs�:�Bosnian�, \r\n"
				+ "�bg�:�Bulgarian�, \r\n"
				+ "�ca�:�Catalan�, \r\n"
				+ "�ceb�:�Cebuano�, \r\n"
				+ "�ny�:�Chichewa�, \r\n"
				+ "�zh-cn�:�Chinese Simplified�, \r\n"
				+ "�zh-tw�:�Chinese Traditional�, \r\n"
				+ "�co�:�Corsican�, \r\n"
				+ "�hr�:�Croatian�, \r\n"
				+ "�cs�:�Czech�, \r\n"
				+ "�da�:�Danish�, \r\n"
				+ "�nl�:�Dutch�, \r\n"
				+ "�en�:�English�, \r\n"
				+ "�eo�:�Esperanto�, \r\n"
				+ "�et�:�Estonian�, \r\n"
				+ "�tl�:�Filipino�, \r\n"
				+ "�fi�:�Finnish�, \r\n"
				+ "�fr�:�French�, \r\n"
				+ "�fy�:�Frisian�, \r\n"
				+ "�gl�:�Galician�, \r\n"
				+ "�ka�:�Georgian�, \r\n"
				+ "�de�:�German�, \r\n"
				+ "�el�:�Greek�, \r\n"
				+ "�gu�:�Gujarati�, \r\n"
				+ "�ht�:�Haitian Creole�, \r\n"
				+ "�ha�:�Hausa�, \r\n"
				+ "�haw�:�Hawaiian�, \r\n"
				+ "�iw�:�Hebrew�, \r\n"
				+ "�hi�:�Hindi�, \r\n"
				+ "�hmn�:�Hmong�, \r\n"
				+ "�hu�:�Hungarian�, \r\n"
				+ "�is�:�Icelandic�, \r\n"
				+ "�ig�:�Igbo�, \r\n"
				+ "�id�:�Indonesian�, \r\n"
				+ "�ga�:�Irish�, \r\n"
				+ "�it�:�Italian�, \r\n"
				+ "�ja�:�Japanese�, \r\n"
				+ "�jw�:�Javanese�, \r\n"
				+ "�kn�:�Kannada�, \r\n"
				+ "�kk�:�Kazakh�, \r\n"
				+ "�km�:�Khmer�, \r\n"
				+ "�ko�:�Korean�, \r\n"
				+ "�ku�:�Kurdish (Kurmanji)�, \r\n"
				+ "�ky�:�Kyrgyz�, \r\n"
				+ "�lo�:�Lao�, \r\n"
				+ "�la�:�Latin�, \r\n"
				+ "�lv�:�Latvian�, \r\n"
				+ "�lt�:�Lithuanian�, \r\n"
				+ "�lb�:�Luxembourgish�, \r\n"
				+ "�mk�:�Macedonian�, \r\n"
				+ "�mg�:�Malagasy�, \r\n"
				+ "�ms�:�Malay�, \r\n"
				+ "�ml�:�Malayalam�, \r\n"
				+ "�mt�:�Maltese�, \r\n"
				+ "�mi�:�Maori�, \r\n"
				+ "�mr�:�Marathi�, \r\n"
				+ "�mn�:�Mongolian�, \r\n"
				+ "�my�:�Myanmar (Burmese)�, \r\n"
				+ "�ne�:�Nepali�, \r\n"
				+ "�no�:�Norwegian�, \r\n"
				+ "�ps�:�Pashto�, \r\n"
				+ "�fa�:�Persian�, \r\n"
				+ "�pl�:�Polish�, \r\n"
				+ "�pt�:�Portuguese�, \r\n"
				+ "�ma�:�Punjabi�, \r\n"
				+ "�ro�:�Romanian�, \r\n"
				+ "�ru�:�Russian�, \r\n"
				+ "�sm�:�Samoan�, \r\n"
				+ "�gd�:�Scots Gaelic�, \r\n"
				+ "�sr�:�Serbian�, \r\n"
				+ "�st�:�Sesotho�, \r\n"
				+ "�sn�:�Shona�, \r\n"
				+ "�sd�:�Sindhi�, \r\n"
				+ "�si�:�Sinhala�, \r\n"
				+ "�sk�:�Slovak�, \r\n"
				+ "�sl�:�Slovenian�, \r\n"
				+ "�so�:�Somali�, \r\n"
				+ "�es�:�Spanish�, \r\n"
				+ "�su�:�Sudanese�, \r\n"
				+ "�sw�:�Swahili�, \r\n"
				+ "�sv�:�Swedish�, \r\n"
				+ "�tg�:�Tajik�, \r\n"
				+ "�ta�:�Tamil�, \r\n"
				+ "�te�:�Telugu�, \r\n"
				+ "�th�:�Thai�, \r\n"
				+ "�tr�:�Turkish�, \r\n"
				+ "�uk�:�Ukrainian�, \r\n"
				+ "�ur�:�Urdu�, \r\n"
				+ "�uz�:�Uzbek�, \r\n"
				+ "�vi�:�Vietnamese�, \r\n"
				+ "�cy�:�Welsh�, \r\n"
				+ "�xh�:�Xhosa�, \r\n"
				+ "�yi�:�Yiddish�, \r\n"
				+ "�yo�:�Yoruba�, \r\n"
				+ "�zu�:�Zulu� "
				+ "\n\nOption:");
		
		
		idioma = sc.next();

		
		//CASO ESPANOL
		if (idioma.equals("es")) {


	        System.out.print("Dinos lo que buscas y encontraremos para ti el hotel ideal\n\n�Que fechas tienes pensado quedarte? aaaa-mm-dd\nDesde:"); //cambiar formato de entrada a dd-mm-aaaa
	        sc.nextLine();
		fecha1 = sc.nextLine();

		System.out.print("Hasta:");

		
		fecha2 = sc.nextLine();




		int estancia = diasEstancia(fecha1, fecha2);
		System.out.print("Estancia:" + estancia + "\n");

		int antelacion = conAntelacion(fecha1);
		System.out.print("Antelacion:" + antelacion + "\n");
		System.out.print("�Para cuantas personas es la reserva?");

		do {
			personas = sc.nextInt();
		}while( personas<=0);
		
		
		// AQUIIIIIIIIIIIII
		
		Boolean ganador= premioAleatorio(personas);
		if(ganador==false) {
		

		int descuento = hayOferta(idioma, personas,  estancia,  antelacion, sc);

		


		//Empiezan filtros

		System.out.println("�Quieres mirar Todos los Hoteles disponibles o con maximo de Precio?t/p:");

		char car;	
do {
		 car = sc.next().charAt(0);
	}while(car!='t'&& car!='p');
	


System.out.print("Descuento: " );
	if(descuento > 10) System.out.println(descuento-1);
	else System.out.println(descuento);

		if(car=='p'){
			System.out.print("\n�Con que presupuesto quieres buscar? introduce el valor a continuacion:");

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

		}
		else {
			
			System.out.println("Felicidades! eres uno entre un millon, literalmente, has ganado nuesto concurso y ahora tienes disponible un viaje de una semana a donde mas te guste!\n"
					+ " Tienes todos estos Hoteles a tu disposicion para elegir:");
			
			for(Hotel elem: hoteles)
				elem.muestra_Hotel(estancia);
			
			
		}//end caso ganador
		
		
		
		}//end caso de espanol
		
		
		
		
		
		
		
		
		
		
		
		
		
		//DEMAS IDIOMAS
		
		else {
			
		       String texto = "Dinos lo que buscas y encontraremos para ti el hotel ideal";
		       
		        System.out.println(Translator.translate("es", idioma, texto));
		        
		        texto = "�Que fechas tienes pensado quedarte? aaaa-mm-dd";
		        System.out.println(Translator.translate("es", idioma, texto));
		        
		        texto ="Desde:";
		        System.out.print(Translator.translate("es", idioma, texto));

		        
		        
		        
			fecha1 = sc.next();
			 System.out.println();
			texto ="Hasta:";
			System.out.print(Translator.translate("es", idioma, texto));
			sc.nextLine();
			fecha2 = sc.nextLine();




			int estancia = diasEstancia(fecha1, fecha2);
			texto = "Dias estancia:" ;
			System.out.print(Translator.translate("es", idioma, texto));
			System.out.print(estancia + "\n");

			int antelacion = conAntelacion(fecha1);
			texto = "Dias antelacion:" ;
			System.out.print(Translator.translate("es", idioma, texto));
			
			System.out.print(antelacion + "\n");
			
			texto = "�Para cuantas personas es la reserva?";
			System.out.println(Translator.translate("es", idioma, texto));

			do {
				personas = sc.nextInt();
			}while( personas<=0);
			
			Boolean ganador= premioAleatorio(personas);
			if(ganador==false) {

			int descuento = hayOferta( idioma, personas,  estancia,  antelacion, sc);




			//Empiezan filtros (con idiomas)

			texto = "�Quieres mirar Todos los Hoteles disponibles o con maximo de Precio? t (todos) / p (precio) :";
			System.out.println(Translator.translate("es", idioma, texto));
			char car;	
	do {
			 car = sc.next().charAt(0);
		}while(car!='t'&& car!='p');
		

	texto = "Descuento: ";
	System.out.print(Translator.translate("es", idioma, texto));	
	if(descuento > 10) System.out.println(descuento-1);
	else System.out.println(descuento);



			if(car=='p'){
				texto = "�Con que presupuesto quieres buscar? introduce el valor a continuacion:";
				System.out.println(Translator.translate("es", idioma, texto));
				
					presupuesto = sc.nextInt();
				
				texto = "Presupuesto:";
				System.out.println(Translator.translate("es", idioma, texto));
					System.out.println( presupuesto);


				if (descuento!=0) {	//caso con descuento
				//	System.out.println("entra en desc");
					for(Hotel elem: hoteles) {	System.out.println("Algo");
						elem.filtra_Hotel(personas, presupuesto, estancia, descuento, idioma);  //mirara dentro de cada hotel habitaciones que cumplan x condiciones
					}
					
				}
				
				else { //caso sin descuento
					for(Hotel elem: hoteles){
						elem.filtra_Hotel(personas, presupuesto, estancia, 0, idioma);
						}
					}
					

			}	 //END IF

			
			
			else {

				for(Hotel elem: hoteles)
					elem.muestra_Hotel(estancia);
		
			}
			
			}
			
			else {
				texto ="Felicidades! eres uno entre un millon, literalmente, has ganado nuesto concurso y ahora tienes disponible un viaje de una semana a donde mas te guste!";
				System.out.println(Translator.translate("es", idioma, texto));
				
				texto ="Tienes todos estos Hoteles a tu disposicion para elegir:";
				System.out.println(Translator.translate("es", idioma, texto));	
				
				
				for(Hotel elem: hoteles)
					elem.muestra_Hotel(estancia);
			}
			
			
			

			
		}
		
	
		sc.close();

	}

}



