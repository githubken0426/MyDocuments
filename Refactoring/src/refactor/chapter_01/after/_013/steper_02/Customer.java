package refactor.chapter_01.after._013.steper_02;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	public String getName() {
		return name;
	}

	private Vector<Rental> vector=new Vector<Rental>();
	
	public Customer(String name){
		this.name=name;
	}
	
	public void addRental(Rental rental){
		vector.addElement(rental);
	}
	private double amountFor(Rental rental){
		return rental.getCharge();
	}
	public String statement(){
		double totalAmount=0;
		int frequentRenterPoints=0;
		Enumeration<Rental> rentals=vector.elements();
		String result="Rental Record for "+getName()+"\n";
		while(rentals.hasMoreElements()){
			Rental rental=(Rental) rentals.nextElement();
			/**
			 * refactor:1.3@2
			 */
			frequentRenterPoints+=rental.getFrequentRenterPoints();
			
			result+="\t"+rental.getMovie().getTitle()+"\t"+String.valueOf(rental.getCharge())+"\n";
			totalAmount=rental.getCharge();
			
		}
		result+="Amount owed is "+String.valueOf(totalAmount)+"\n";
		result+="You earned "+String.valueOf(frequentRenterPoints)+" frequent renter points";
		return result;
	}
	
}	
