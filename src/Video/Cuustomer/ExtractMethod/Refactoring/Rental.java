package Video.Cuustomer.ExtractMethod.Refactoring;

// 영화를 대여  클래스
public class Rental {
	//영화
	private Movie movie;
	//대여기간
	private int dayrented;

	public Rental(Movie movie, int dayrented) {
		//요금, 비디오제목
		this.movie = movie;
		this.dayrented = dayrented;
	}
	public Movie getMovie() {
		return movie;
	}
	public int getDayrented() {
		return dayrented;
	}
	
	
}
