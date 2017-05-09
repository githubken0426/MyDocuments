package refactor.chapter_01.after._013.steper_03;

import refactor.chapter_01.original.Movie;

public class Rental {
	private Movie movie;
	private int dayRented;
	private int frequentRenterPoints;
	
	public Rental(Movie movie,int dayRented){
		this.movie=movie;
		this.dayRented=dayRented;
	}
	public Movie getMovie() {
		return movie;
	}
	public int getDayRented() {
		return dayRented;
	}
	
	public double getCharge(){
		double result=0;
		switch(getMovie().getPriceCode()){
		case Movie.REGULAR:
			result+=2;
			if(getDayRented()>2)
				result+=(getDayRented()-2)*1.5;
			break;
		case Movie.NEW_RELEASE:
			result+=getDayRented()*3;
			break;
		case Movie.CHILDRENS:
			result+=1.5;
			if(getDayRented()>3)
				result+=(getDayRented()-3)*1.5;
			break;
		}
		return result;
	}
	/**
	 * 1
	 * 
	 * 提炼Customer statement()方法
	 * @return
	 * 2016-11-23 下午03:55:38
	 */
	public int getFrequentRenterPoints() {
		frequentRenterPoints++;
		if(movie.getPriceCode()==Movie.NEW_RELEASE && getDayRented()>1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
	
}
