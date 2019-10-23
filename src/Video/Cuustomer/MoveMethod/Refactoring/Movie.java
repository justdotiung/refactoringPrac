package Video.Cuustomer.MoveMethod.Refactoring;

import Video.Cuustomer.polymorphism.Refactoring.ChildrenPrice;
import Video.Cuustomer.polymorphism.Refactoring.NewReleasePrice;
import Video.Cuustomer.polymorphism.Refactoring.Price;
import Video.Cuustomer.polymorphism.Refactoring.RegularPrice;

/*
 *  다형성 을 통한 리팩토링  
 *  1.새로운 분류 방법
 *  2.요금과 포인트 변경
 *  방안
 *  1. switch문 , 마일리지 Movie class로 이동.
 *  2. Movie를 상속받는 3개의 class를 만든다
 *  3. 디자인패턴을 이용한 리팩토링 (스테이트 패턴 이용)
 *  4. getCharge() switch 문을 없앤다.
 *  5. 각각의 요금 클래스에 코드와 요금 또한 마일리지가 필요한부분에 사용한다.
 * */
//비디오 이름 과 요금 클래스
public class Movie {
	//요금
	public static final int CHILDREN = 2; //어린이용
	public static final int REGULAR = 0; //보통
	public static final int NEW_RELEASE = 1; //최신	
	
	private String _title;
	private Price price;
	
	public Movie(String title, int priceCode) {
		this._title = title;
		setPriceCode(priceCode);
	}

	public String geTitle() {
		return _title;
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDREN:
			price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrenct Price Code");
		}
	}
	
	double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
		
}
