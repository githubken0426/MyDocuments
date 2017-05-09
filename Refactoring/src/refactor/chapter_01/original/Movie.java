package refactor.chapter_01.original;

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
}
