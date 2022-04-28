package fp.Coches.test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import fp.Coches.Car;
import fp.Coches.CarsRiyadh;
import fp.Coches.Factoria;
import fp.Common.Condition;


public class TestCarsRiyadh {
	

	public static void main(String[] args) {
		
		List<Car> datos =Factoria.leeDeFichero("./data/carsclean.csv");
		
		// Leer los datos y mostrar el número total de elementos existen en los datos .
		
		CarsRiyadh listaDeCoches = new CarsRiyadh(datos);
		System.out.println(datos.subList(0, 5));
		System.out.println(listaDeCoches.getNumeroCars());
		
		
		// Testear los primeros tres tratamientos secuenciales .
		
		System.out.println(listaDeCoches.ExisteCocheCompaniaYmodelo("Toyota", "Rush"));
		System.out.println(listaDeCoches.ElCocheMasBarato());
		System.out.println(listaDeCoches.getCocheCondicion(Condition.Used));
		
		
		// Testear los Maps hechos en clase CarsRiyadh .
		
		mostrarDiccionarioAgrupciones(listaDeCoches.agrupacionDeCochesPorFecha());
		mostrarDiccionarioTotal(listaDeCoches.acumulacionDeCochesPorCompania()); 
		
		}
	
		private static void mostrarDiccionarioAgrupciones(Map<Integer, List<Car>> map) {
			Set<Entry<Integer, List<Car>>> aux = map.entrySet();
			for(Entry<Integer, List<Car>> par: aux) {
				System.out.println(par.getKey() + "-->" + par.getValue());
			}
		}
		
		private static void mostrarDiccionarioTotal(Map<String, Integer> map) {
			Set<Entry<String, Integer>> aux = map.entrySet();
			for(Entry<String, Integer> par: aux) {
				System.out.println(par.getKey() + "-->" + par.getValue());
			}
		
	}

}
