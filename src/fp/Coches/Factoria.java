package fp.Coches;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.Common.Condition;
import fp.Common.PaymentMethod;
import fp.utiles.Checkers;
import fp.utiles.Ficheros;


public class Factoria {	
	
	
//--------------------------------- 	  Factoria       ----------------------------------------------//
		
		
		

	/* Primero creamos el metodo parse que recibe como parámetro una cadena con el formato de las 
	 * líneas del fichero carsclean.csv ,Con este método, convertimos una cadena de caracteres, un String,
	 * a cada tipo de datos que tenemos (String , LocalDate , enum , Integer , String, enum , Integer )  
	 
	 * String[] splits = s.split(";") se usa para dividir un string en substrings mediante una expresión
	 * y así nuestro String se divide cada vez que que sale (;) y se crean 8 Strings que son nuestras
	 * propiedades y
	 
	 *  usamos trim()  para la manipulación de cadenas (String), el cual sirve para
	 *  quitar los espacios a la cadena, Y devolvemos un objeto del tipo Car .
	 * 
	 */	
			
		
		public static Car parse(String s) {
			
			String[] splits = s.split(";") ;
			
			Checkers.check("error por agregar cantidad de datos erronea", splits.length == 8 );
			String company = splits[0].trim();
			String model = splits[1].trim();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate productionDate = LocalDate.parse(splits[2].trim(), formato);
			Condition condition = Condition.valueOf(splits[3].trim());
			Integer kilometers = Integer.valueOf(splits[4].trim());
			String color = splits[5].trim();
			PaymentMethod paymentMethod = PaymentMethod.valueOf(splits[6].trim());
			Integer price = Integer.valueOf(splits[7].trim());

			Car c = new Car( company,  model,  productionDate,  condition,  kilometers,
					color,  paymentMethod,  price);
				return c;
			
			
		}

		
	
//--------------------------------- 	  LEER FICHERO       ----------------------------------------------//	
	
	/* Toma como entrada el parámetros de tipo String ( ruta ) que referencia a la ruta del csv de nuestro 
	 * proyecto y creamos una lista vacia para almacenar los datos dentro de ella luego hacemos uso del 
	 * fichero (Ficheros) , quitamos la cabecera , leemos el csv corriendo todas las líneas haciendo uso
	 * al métedo parse y al final devolvemos la lista de objetos para hacer sobre ella nuestros tratamientos.
	 */
		
	public static List<Car> leeDeFichero(String ruta){	
		List<Car>res=new ArrayList<>();
		List<String>lineas=Ficheros.leeFichero("Error de lectura", ruta);
		lineas.remove(0); //eliminamos la primera linea porque son los nombres de las columnas

		for(String linea:lineas) {
			Car c=parse(linea);
			res.add(c);

		}
		
	
				
		return res;
	}


}






