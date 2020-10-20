package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class FiltroTest {

	
	
	
//	public boolean filtra_habitacion(int personas, int presupuesto, int dias) {
//		
//		if (this.calcular_precio()*dias > presupuesto)
//			return false;
//		else if( distribucion_camas(personas) == false)
//			return false;
//		return true;	
//	}
//	


	
	@Test
	void test() {//que cojones voy a hacer aqui
		
		Vector<Habitacion> habitaciones= new Vector<Habitacion>();
		



		habitaciones.add( new Habitacion("Standar", 2, 1));
		habitaciones.add(new Habitacion("Doble standar", 4, 2));
		habitaciones.add(new Habitacion("Individual", 1, 0));
		habitaciones.add(new Habitacion("Familia grande", 0, 4));
		habitaciones.add(new Habitacion("Pareja", 0, 1));
		habitaciones.add(new Habitacion("incredible", 1, 1));
		habitaciones.add(new Habitacion("Agua", 2, 2));
		habitaciones.add(new Habitacion("Fuego", 1, 0));
		habitaciones.add(new Habitacion("Aire", 0, 5));
		habitaciones.add(new Habitacion("Tierra", 2, 0));
	
		
		boolean resultFiltro[]= new boolean[10];
		resultFiltro[0]=true;
		resultFiltro[1]=true;
		resultFiltro[2]=false;
		resultFiltro[3]=true;
		resultFiltro[4]=false;
		resultFiltro[5]=true;
		resultFiltro[6]=true;
		resultFiltro[7]=false;
		resultFiltro[8]=true;
		resultFiltro[9]=false;
		
		int i=0;
		for(Habitacion elem: habitaciones) {
		assertEquals(resultFiltro[i++] ,elem.filtra_habitacion( 3,3000, 4));	//3 personas, 3000 euros, 4 dias
		
		
		}
	}

}
