package fp.Coches;

import java.time.LocalDate;

import fp.Common.Condition;
import fp.Common.PaymentMethod;
import fp.Common.PriceRating;
import fp.utiles.Checkers;


//--------------------------------- 	  Atributos       ----------------------------------------------//
/* 						
 * 	Crear nuestro record para el tipo Car con sus atributos :
 *  	(String , LocalDate , Enumerado , Integer , String  , Enumerado , Integer )                                                                
 */

public record Car(String company, String model, LocalDate productionDate, Condition condition, Integer kilometers,
		String color, PaymentMethod paymentMethod, Integer price) implements Comparable<Car> {

	
//------------------------------	CONSTRUCTORS Y RESTRICCIONES    ------------------------------//

	
	/* 
	 * 	Definir tres restricciones diferentes y usando distintas propiedades básicas :
	 * 
	 * 1) Comprueba que el precio del Coches no es un número negativo .
	 * 2) Comprueba que los kilómetros circulados del Coches no es un número negativo
	 * 3) Comprueba que la fecha de fabricación del Coches no es una fecha a partir del año 2022 .
	 */
	
	public  Car{
		
		
		Checkers.check("the price can't be lower than 0 ", price > 0);
		Checkers.check("the kilometers can't be lower than 0 ", kilometers >= 0);
		Checkers.check("the production datee can't be after 2022", productionDate.getYear() <= 2022);
		
	}
	
	
//------------------------------ 	 Métodos 	----------------------------------------------//
					
	/*
	 * 1) Calcula la media de los kilómetros circulados por año devuelve un numero double
	 * 	  con los kilometros divididos por la suma de los años de circulacion .  
	 */

	public Double averageKilometersPerYear() {
		int yearscount = LocalDate.now().getYear() - productionDate.getYear();
		if (yearscount == 0)
			return Double.valueOf(kilometers);
		return ((double) kilometers / yearscount);

	}
	
	/*
	 * 2) calcula la clasificación del coche en base a su precio y el año de su fabricación
	 *  si se clasifica como un coche Caro entonces su precio es mayor de 55000 Euros y se ha fabricado
	 *  hace más de 3 años.
	 */
	
	public PriceRating getPriceRating() {
		int yearscount = LocalDate.now().getYear() - productionDate.getYear();
		if (yearscount > 3 && price > 55000)
			return PriceRating.expensive;
		return PriceRating.cheap;

	}
	
	
//------------------------------   hashCode Y Equals   ------------------------------------ //
	
	
	/*
	 * El método hashCode sirve para obtener un código hash que sería como un identificador del objeto.
	 *  Este hash se utiliza en algunas colecciones como (HashSet, HashMap, LinkedHashSet, 
	 *  													LinkedHashMap, ConcurrentHashMap, etc ).
	 *  
	 * El método equals sirve comprobar si los objetos son iguales o distintos.
	 * y aquí dos objetos son iguales si tienen el mismo precio y el mismo numero de kilometros
	 *  circulados.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kilometers == null) ? 0 : kilometers.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Car other = (Car) obj;
		if (kilometers == null) {
			if (other.kilometers != null)
				return false;
		} else if (!kilometers.equals(other.kilometers))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	
//------------------------------  compareTo   ------------------------------------ //
	// El método responsable del mecanismo de la ordenación, ordena primero
	//dependiendo a sus precios y si el precio de dos coches es igual lo comprueba por los kilometros circulados.
	
	public int compareTo(Car o) {
		int res = Integer.compare(price, o.price);
		if (res == 0)
			return Integer.compare(kilometers, o.kilometers);
		return res;
	}

}
