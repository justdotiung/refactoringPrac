package Video.Cuustomer.polymorphism.Refactoring;

/*
 *  다형성 을 통한 리팩토링  
 *  1.새로운 분류 방법
 *  2.요금과 포인트 변경
 *  방안
 *  1. switch문 , 마일리지 Movie class로 이동.
 * */
// 영화를 대여  클래스
public class Rental {
	//영화
	private Movie movie;
	//대여기간
	private int daysRented;

	public Rental(Movie movie, int dayrented) {
		//요금, 비디오제목
		this.movie = movie;
		this.daysRented = dayrented;
	}
	public Movie getMovie() {
		return movie;
	}
	public int getDayrented() {
		return daysRented;
	}
	
	public double getCharge() {
		return movie.getCharge(daysRented);
		
	}
	
	//마일리지 
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
	
}
