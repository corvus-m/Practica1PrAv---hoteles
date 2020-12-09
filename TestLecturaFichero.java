package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestLecturaFichero {

	@Test
	void testLecturaFicheros() throws FileNotFoundException {
		
		String fichero = "usuariosHoteles.txt"; 

		File ficheroAlmacen = new File (fichero);
		
		assertTrue(ficheroAlmacen.exists());
		
		if (ficheroAlmacen.exists()) {
			System.out.println("entra al fichero");
			Scanner scFichero = new Scanner(ficheroAlmacen);
			while (scFichero.hasNext()) {
				String linea = scFichero.nextLine();
				String [] usuario = linea.split(":");

				System.out.println("User: " + usuario[0] + "\tPrefered Language: " + usuario[1]);	//de momento imprimo pero tengo que guardar

			}
			scFichero.close();
		}

		else
			System.out.println("¡El fichero no existe, el programa funcionara sin memoria");
		
		
		
		
		
	}

}

