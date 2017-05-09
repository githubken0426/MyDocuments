package refactor.chapter_01.after._014;


public class Movie {
	public final static int CHILDRENS=2;
	public final static int REGULAR=0;
	public final static int NEW_RELEASE=1;
	private String title;
	private int priceCode;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
	
	/**
	 * refactor:1.4@1
	 * 
	 * @param daysRentend
	 * @return
	 * 2016-11-23 下午04:39:01
	 */
	public double getCharge(int daysRented){
		double result=0;
		switch(priceCode){
		case Movie.REGULAR:
			result+=2;
			if(daysRented>2)
				result+=(daysRented-2)*1.5;
			break;
		case Movie.NEW_RELEASE:
			result+=daysRented*3;
			break;
		case Movie.CHILDRENS:
			result+=1.5;
			if(daysRented>3)
				result+=(daysRented-3)*1.5;
			break;
		}
		return result;
	}
}
