package refactor.chapter_01.after._013.steper_01;

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
			double thisAmoun=0;
			Rental rental=(Rental) rentals.nextElement();
			thisAmoun=amountFor(rental);
			
			frequentRenterPoints++;
			if(rental.getMovie().getPriceCode()==Movie.NEW_RELEASE && rental.getDayRented()>1)
				frequentRenterPoints++;
			result+="\t"+rental.getMovie().getTitle()+"\t"+String.valueOf(thisAmoun)+"\n";
			totalAmount=thisAmoun;
			
		}
		result+="Amount owed is "+String.valueOf(totalAmount)+"\n";
		result+="You earned "+String.valueOf(frequentRenterPoints)+" frequent renter points";
		return result;
	}
	
	/**
	 * refactor:1.3@1
	 * amountFor只引用了Rental的信息
	 * 却没有Customer的任何信息
	 * 重构:放入Rental
	 * @return
	 * 2016-11-23 下午03:38:57
	 */
	public double amountFor(Rental rental ){
		double result=0;
		switch(rental.getMovie().getPriceCode()){
		case Movie.REGULAR:
			result+=2;
			if(rental.getDayRented()>2)
				result+=(rental.getDayRented()-2)*1.5;
			break;
		case Movie.NEW_RELEASE:
			result+=rental.getDayRented()*3;
			break;
		case Movie.CHILDRENS:
			result+=1.5;
			if(rental.getDayRented()>3)
				result+=(rental.getDayRented()-3)*1.5;
			break;
		}
		return result;
	}
}	
