package Video.Cuustomer.MoveMethod.Refactoring;

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
	//3. 을 이용 이동된 메서드 (메서드 명 적절히 변경)
	double getCharge() {
		double result = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (getDayrented() > 2)
				result += (getDayrented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += getDayrented() * 3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if (getDayrented() > 3)
				result += (getDayrented() - 3) * 1.5;
			break;
		}
		return result;
	}
	
	
}
