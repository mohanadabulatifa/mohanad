package fp.Coches.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fp.Coches.Car;
import fp.Common.Condition;
import fp.Common.PaymentMethod;





	//La clase TestCoches : Responsable de testear los métedos creados en el tipo fp.Coches.

public class TestCar {

	public static void main(String[] args) {
		testPriceRestricciones();
		testKilometersRestricciones();
		testProductionDateRestricciones();
		testEquals();
		testAverageandRating();
		testsortingCoches();

	}
	
	
	
	/* testPriceRestricciones() : testea la restriccion uno , para que de 
	 * 									excepción si el precio es negativo .
	 */
	private static void testPriceRestricciones() {
		try {
			Car c1 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, 2000000, "Black",
					PaymentMethod.Cash, -2000);

		} catch (IllegalArgumentException e) {
			System.out.println("exception thrown " + e.getMessage());
		}
	}
	
	
	
	
	/* testKilometersRestricciones() : testea la restriccion dos , para que de 
	 * 										excepción si los kilometros están en negativo .
	 */
	private static void testKilometersRestricciones() {
		try {
			Car c2 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, -202700, "Black",
					PaymentMethod.Cash, 231000);

		} catch (IllegalArgumentException e) {
			System.out.println("exception thrown " + e.getMessage());
		}
	}
	
	
	
	
	/* testProductionDateRestricciones() : testea la restriccion numero tres , para que de 
	 * 												excepción si la fecha de fabricación es 
	 * 														mayor que la fecha actual .
	 */	
	private static void testProductionDateRestricciones() {
		try {
			Car c3 = new Car("BMW", "740", LocalDate.of(2023, 02, 21), Condition.Used, 202700, "Black",
					PaymentMethod.Cash, 231000);

		} catch (IllegalArgumentException e) {
			System.out.println("exception thrown" + e.getMessage());
		}
	}
	
	
	
	
		/*testEquals() : devuelve true si los coches son iguales , y false si son distintos
		 */
	private static void testEquals() {
		Car c1 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, 2000000, "Black",
				PaymentMethod.Cash, 200000);
		Car c2 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, 2000000, "Black",
				PaymentMethod.Cash, 200000);
		Car c3 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, 2000000, "Black",
				PaymentMethod.Cash, 800000);
		System.out.println("does c1 equals c2 ? : " + c1.equals(c2));
		System.out.println("does c1 equals c3 ? : " + c1.equals(c3));

	}
	
	
		/* testAverageandRating() : testea los dos metedos ( averageKilometersPerYear(), getPriceRating() ),
		 * 									 devuelve la media de los kilometros circulado por año del coche
		 *     											y si el coche es caro o barato dependiendo de su precio.
		 */
	private static void testAverageandRating() {
		Car c1 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, 2000000, "Black",
				PaymentMethod.Cash, 200000);
		System.out.println(c1.averageKilometersPerYear());
		System.out.println(c1.getPriceRating());

	}
	
	
	
	
	
	/*testsortingCoches() : creo una lista (cochesLista) añado tres coches distintos y los ordeno y compruebo
	 * 								el métedo compareTo ; que ordena los objetos primero dependiendo de su precio
	 * 											si el precio de objeto1=objeto2 los ordena dependiendo de los kilometros
	 * 												circulados de cada coche.
	 */
	
	private static void testsortingCoches() {
		List<Car> cochesLista = new ArrayList();
		Car c1 = new Car("BMW", "740", LocalDate.of(2001, 02, 21), Condition.Used, 2000000, "Black",
				PaymentMethod.Cash, 1305);
		Car c2 = new Car("TOYOTA", "B1", LocalDate.of(2001, 02, 21), Condition.Used, 3000, "Black",
				PaymentMethod.Cash, 200000);
		Car c3 = new Car("NISSAN", "FM2", LocalDate.of(2001, 02, 21), Condition.Used, 140500, "Black",
				PaymentMethod.Cash, 200000);
		cochesLista.add(c1);
		cochesLista.add(c2);
		cochesLista.add(c3);
		
		Collections.sort(cochesLista);
		System.out.println(cochesLista);		
	}

}
