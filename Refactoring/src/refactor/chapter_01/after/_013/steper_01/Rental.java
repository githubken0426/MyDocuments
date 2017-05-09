package refactor.chapter_01.after._013.steper_01;

public class Rental {
	private Movie movie;
	private int dayRented;
	
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
}
