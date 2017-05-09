package refactor.chapter_01.after._014;

import java.util.Enumeration;
import java.util.Vector;


/**
 * 1.4
 * 运用多态与价格相关的条件逻辑
 * 
 * @author ken
 * 2016-11-23 下午04:06:26
 */
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
//		double totalAmount=0;
//		int frequentRenterPoints=0;
		Enumeration<Rental> rentals=vector.elements();
		String result="Rental Record for "+getName()+"\n";
		while(rentals.hasMoreElements()){
			Rental rental=(Rental) rentals.nextElement();
			/**
			 * reflator_2
			 */
			//frequentRenterPoints+=rental.getFrequentRenterPoints();
			result+="\t"+rental.getMovie().getTitle()+"\t"+String.valueOf(rental.getCharge())+"\n";
			/**
			 * reflator_1
			 */
			//totalAmount=rental.getCharge();
			
		}
		result+="Amount owed is "+String.valueOf(getTotalCharge())+"\n";
		result+="You earned "+String.valueOf(getTotalFrequentRenterPoints())+" frequent renter points";
		return result;
	}
	
	/**
	 * refactor_1
	 * 
	 * @return
	 * 2016-11-23 下午04:13:23
	 */
	private double getTotalCharge(){
		double result=0;
		Enumeration<Rental> rentals=vector.elements();
		while(rentals.hasMoreElements()){
			Rental rental=(Rental) rentals.nextElement();
			result+=rental.getCharge();
		}
		return result;
	}
	/**
	 * refactor_2
	 * 
	 * @return
	 * 2016-11-23 下午04:21:57
	 */
	private int getTotalFrequentRenterPoints(){
		int result=0;
		Enumeration<Rental> rentals=vector.elements();
		while(rentals.hasMoreElements()){
			Rental rental=(Rental) rentals.nextElement();
			result+=rental.getFrequentRenterPoints();
		}
		return result;
	}
	
	/**
	 * 添加新的功能
	 * html版本
	 * @return
	 * 2016-11-23 下午04:28:47
	 */
	public String htmlStatement(){
		Enumeration<Rental> rentals=vector.elements();
		String result="<H1>Rental Record for <EM>"+getName()+"</EM><H1><p>\n";
		while(rentals.hasMoreElements()){
			Rental rental=(Rental) rentals.nextElement();
			result+="\t"+rental.getMovie().getTitle()+":"+String.valueOf(rental.getCharge())+"<br>\n";
		}
		result+="<p>Amount owed is <em>"+String.valueOf(getTotalCharge())+"</em><p>\n";
		result+="You earned <em>"+String.valueOf(getTotalFrequentRenterPoints())
				+"</em> frequent renter points<p>";
		return result;
	}
	
}	
