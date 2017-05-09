package refactor.chapter_01.after._014;


public class Rental {
	private Movie movie;
	private int daysRented;
	private int frequentRenterPoints;
	
	public Rental(Movie movie,int daysRented){
		this.movie=movie;
		this.daysRented=daysRented;
	}
	public Movie getMovie() {
		return movie;
	}
	public int getDaysRented() {
		return daysRented;
	}
	/**
	 * 最好不要在一个对象的属性基础上运用switch
	 * 如果不得不使用，也应该在对象自己的数据上使用
	 * 
	 * refactor:1.4@1
	 * 
	 * @return
	 * 2016-11-23 下午04:36:24
	 */
	/*public double getCharge(){
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
	}*/
	public double getCharge(){
		return movie.getCharge(daysRented);
	}
	public int getFrequentRenterPoints() {
		if(movie.getPriceCode()==Movie.NEW_RELEASE && getDaysRented()>1)
			return 2;
		return 1;
	}
	
}
