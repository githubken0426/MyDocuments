package refactor.chapter_01.original;

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
	
	public String statement(){
		double totalAmount=0;
		int frequentRenterPoints=0;
		Enumeration<Rental> rentals=vector.elements();
		String result="Rental Record for "+getName()+"\n";
		while(rentals.hasMoreElements()){
			double thisAmount=0;
			Rental rental=(Rental) rentals.nextElement();
			switch(rental.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount+=2;
				if(rental.getDayRented()>2)
					thisAmount+=(rental.getDayRented()-2)*1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount+=rental.getDayRented()*3;
				break;
			case Movie.CHILDRENS:
				thisAmount+=1.5;
				if(rental.getDayRented()>3)
					thisAmount+=(rental.getDayRented()-3)*1.5;
				break;
			}
			frequentRenterPoints++;
			if(rental.getMovie().getPriceCode()==Movie.NEW_RELEASE && rental.getDayRented()>1)
				frequentRenterPoints++;
			result+="\t"+rental.getMovie().getTitle()+"\t"+String.valueOf(thisAmount)+"\n";
			totalAmount=thisAmount;
		}
		result+="Amount owed is "+String.valueOf(totalAmount)+"\n";
		result+="You earned "+String.valueOf(frequentRenterPoints)+" frequent renter points";
		return result;
	}
}	
