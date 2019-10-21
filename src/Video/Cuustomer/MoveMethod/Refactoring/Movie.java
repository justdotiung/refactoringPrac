package Video.Cuustomer.MoveMethod.Refactoring;
/*
 *  다형성 을 통한 리팩토링  
 *  1.새로운 분류 방법
 *  2.요금과 포인트 변경
 *  방안
 *  1. switch문 , 마일리지 Movie class로 이동.
 *  2. Movie를 상속받는 3개의 class를 만든다
 *  3. 
 * */
//비디오 이름 과 요금 클래스
public class Movie {
	//요금
	public static final int CHILDREN = 2; //어린이용
	public static final int REGULAR = 0; //보통
	public static final int NEW_RELEASE = 1; //최신	
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) {
		this._title = title;
		this._priceCode = priceCode;
	}

	public String geTitle() {
		return _title;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		this._priceCode = arg;
	}
	
	//switch 문은 자신의 데이터를 사용하는것이 바람직하다. 
		double getCharge(int daysRented) {
			double result = 0;
			switch (getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += daysRented * 3;
				break;
			case Movie.CHILDREN:
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
			}
			return result;
		}
		
		public int getFrequentRenterPoints(int daysRented) {
			// 마일리지 추가
			if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
				return 2;
			else {
				return 1;
			}
		}
		
}
