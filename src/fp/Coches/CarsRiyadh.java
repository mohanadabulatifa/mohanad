package fp.Coches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fp.Common.Condition;



//--------------------------------- 	  TIPO CONTENEDOR       ----------------------------------------------//

/*
 * Creamos tipo Contenedor CarsRiyadh para formar una lista del tipo Car para hacer nuestros tratamientos
 * 	secuenciales sobre �l . 
 */

public class CarsRiyadh  {
	private List<Car> Cars;

	
public List<Car> getCars() {
		return new ArrayList<>(Cars);
	}

	
//------------------------------	CONSTRUCTORS Y RESTRICCIONES    ------------------------------//
	
	/* Constructor 1) no lleva propiedades como par�metros 
	 * Constructor 2) lleva como atributo la propiedad lista del tipo Car.
	 */

	public CarsRiyadh() {
		this.Cars = new ArrayList<Car>();

	}

	public CarsRiyadh(List<Car> cars) {
		this.Cars =  cars ;

	}
	
//----------------------------------	PROPIEDADES DERIVADAS   --------------------------------------//	
	
	/*
	 * Propiedades Derivadas :
	 * 1) Obtener el N�mero de Coches en nuestra Lista de Coches.
	 * 2) A�adir un elemento a la lista Cars.
	 * 3) A�adir lista de elementos a la lista Cars.
	 * 4) Eliminar elemento de la lista Cars.
	 * 
	 */


	public Integer getNumeroCars() {
		return Cars.size();
	}

	public void addElement(Car c) {
		Cars.add(c);
	}
	
	public void addListOfElements(List<Car> c) {
		Cars.addAll(c);
	}
	
	public void deleteElement(Car c) {
		Cars.remove(c);
	}
		
	
//----------------------------------	TRATAMIENTOS SECUENCIALES   --------------------------------------//	
	
	/*
	 * Tratamiento Secuencial 1 : 
	 * 
	 * Toma como entrada dos par�metros de tipo String ( f , m ) que referencian al nombre de la marca
	 * 	 del coche y su modelo y devuelve como salida un Booleano de (true � false) si existe un coche
	 * 	 con las caracter�sticas indicadas con la misma marca y el mismo modelo dados como parametros .
	 */

	public Boolean ExisteCocheCompaniaYmodelo(String f, String m) {
		Boolean b = false;
		for (Car c : this.Cars) {
			if (c.company().equals(f) && c.model().equals(m)) {
				b= true;
				break ;
			}
		}
		return b;
	}
	
	
	/*
	 * Tratamiento Secuencial 2 : 
	 * 
	 * No toma como entrada alg�n par�metro y devuelve como salida una Lista del tipo Car para el coche 
	 * que tiene el precio minimo , en otras palabras , devuelve lista con las propiedades del coche que 
	 * tiene el precio m�s bajo .
	 */

	  public Car ElCocheMasBarato(){
		  if(this.Cars.isEmpty())
			  return null;
		 Car l = this.Cars.get(0);
		 for(Car c : this.Cars) {
			 if(c.price() < l.price() ) {
				 l = c ;
			 }	  
	  }
	  return l ;
	  
	  }
	
	/*
	 * Tratamiento Secuencial 3 : 
	 * 
	 * Toma como entrada un par�metro de tipo Boolean ( c ) que referencia al enumerado de la condici�n
	 * 	 del coche que tienen como valores ( Used , New )  y devuelve como salida una lista de los coches
	 *   que cumplen la condici�n indicada y dada como par�metro .
	 */

	public List<Car> getCocheCondicion(Condition c) {
		List<Car> a = new ArrayList<>();
		for (Car f : this.Cars) {
			if (f.condition().equals(c)) {
				a.add(f);
			}
		}
		return a;

	}
	

	/*
	 * Tratamiento Secuencial 4 : 
	 * 
	 * No toma como entrada alg�n par�metro devuelva un Map en el que las claves sean el a�o en el que se
	 * ha fabricado el coche y los valores una lista de coches que corresponden a la clave . 
	 */
	

	public Map<Integer, List<Car>> agrupacionDeCochesPorFecha() {
		Map<Integer, List<Car>> e = new HashMap<>();
		for (Car c : Cars) {
			Integer fechaClave = c.productionDate().getYear();
			if (!e.containsKey(fechaClave)) {
				e.put(fechaClave, new ArrayList<>());
			}

			e.get(fechaClave).add(c);
		}
		return e;

	}
	
	
	/*
	 * Tratamiento Secuencial 5 : 
	 * 
	 * No toma como entrada alg�n par�metro devuelva un Map en el que las claves sean las marcas de todos
	 *  los coches los valores un Integer que hace referencia al n�mero total de coches 
	 *  que hay de cada marca.
	 */	

	public Map<String, Integer> acumulacionDeCochesPorCompania() {
		Map<String, Integer> m = new HashMap<>();
		for (Car c : this.Cars) {
			String clave = c.company();
			if (!m.containsKey(clave)) {
				m.put(clave, 0);
			}
			Integer valor = m.get(clave);
			m.put(clave, valor + 1);
		}
		return m;

	}

//-------------------------------   hashCode , Equals Y toStrig   --------------------------------------- //
	
	
		/*
		 * El m�todo hashCode sirve para obtener un c�digo hash que ser�a como un identificador del objeto.
		 *  Este hash se utiliza en algunas colecciones como (HashSet, HashMap, LinkedHashSet, 
		 *  													LinkedHashMap, ConcurrentHashMap, etc ).
		 *  
		 *  
		 * El m�todo equals sirve comprobar si los objetos son iguales o distintos.
		 * y aqu� dos objetos son si sus listas de coches son iguales.
		 * 
		 * 
		 * El m�todo toString nos permite mostrar la informaci�n completa de un objeto, es decir, 
		 * el valor de sus atributos.
		 * 
		 */	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cars == null) ? 0 : Cars.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarsRiyadh other = (CarsRiyadh) obj;
		if (Cars == null) {
			if (other.Cars != null)
				return false;
		} else if (!Cars.equals(other.Cars))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarsRiyadh [Cars=" + Cars + "]";
	}
}
