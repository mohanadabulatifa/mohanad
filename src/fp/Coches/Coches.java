package fp.Coches;

import java.time.LocalDate;
import java.util.Objects;

import fp.Common.Condition;
import fp.Common.PaymentMethod;
import fp.Common.PriceRating;
import fp.utiles.Checkers;


  	/* Crear nuestro record para el tipo Coches con sus atributos (String , LocalDate , Enumerado , Integer , String 
  	 *                                                                  , Enumerado , Integer )
  	 */
public record Coches(String company, String model, 
		LocalDate productionDate , Condition condition, Integer kilometers , String color , PaymentMethod
		paymentMethod , Integer price) implements Comparable<Coches>{
     
	
	/*  CONSTRUCTORS
	 *  Definir tres restricciones diferentes y en distintas propiedades básicas :
	 *  	1)Comprueba que el precio del Coches no es un número negativo .
	 *  	2)Comprueba que los kilómetros circulados del Coches no es un número negativo .
	 *  	3)Comprueba que la fecha de fabricación del Coches no es una fecha a partir del año 2022 .
	 */
	
	public Coches {
		Checkers.check("the price can't be lower than 0 ", price > 0);
		Checkers.check("the kilometers can't be lower than 0 ", kilometers >= 0);
		Checkers.check("the production datee can't be after 2022", productionDate.getYear() <= 2022);
		
			}
	/* Métodos :
	 * Primer método calcula la media de los kilómetros circulados por año
	 * Segundo métedo calcula la clasificación del precio del coche si
	 * Se clasifica como un coche BARATO Ó CARO.
	 */
	
	
	public Double averageKilometersPerYear() {
		int yearscount = LocalDate.now().getYear()- productionDate.getYear() ;
		if (yearscount == 0)
			return Double.valueOf(kilometers) ;
		return ( (double) kilometers/yearscount);
		
	}
	public PriceRating getPriceRating() {
		int yearscount = LocalDate.now().getYear()- productionDate.getYear() ;
		if (yearscount > 3 && price > 55000) 
			return PriceRating.expensive ;
		return PriceRating.cheap ;
	
		
	}
	
	// Crear el hashCode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((kilometers == null) ? 0 : kilometers.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productionDate == null) ? 0 : productionDate.hashCode());
		return result;
	}
	
	// Crear el equals ; El métedo que comprueba si los objetos son iguales o distinto
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coches other = (Coches) obj;
		return Objects.equals(price, other.price) && Objects.equals(kilometers, other.kilometers);
	}
	// Crear el toString
	
	
	@Override
	public String toString() {
		return "Coches [company=" + company + ", model=" + model + ", productionDate=" + productionDate + ", condition="
				+ condition + ", kilometers=" + kilometers + ", color=" + color + ", paymentMethod=" + paymentMethod
				+ ", price=" + price + "]";
	}
	
	// Crear el compareTo ; El métedo responsable de ordenar , primero comprueba 
	@Override
	public int compareTo(Coches o) {
		int res = Integer.compare(price, o.price) ;
		if (res == 0)
			return Integer.compare(kilometers , o.kilometers);
		return res ;
	}
}
