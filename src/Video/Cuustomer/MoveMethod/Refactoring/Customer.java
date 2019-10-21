package Video.Cuustomer.MoveMethod.Refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}


	/* 리팩토링 
	 * 1. 수정되지 않는 변수는 파라미터로 넘길 수 있다.
	 * 2. 논리적으로 연관있는 코드를 찾아서 Extract Method(메소드 추출) 한다  
	 * 3. 현재 클래스의 정보를 사용하지 않는 메소드는 적절한 쓰임이있는 클래스로 Move Method(메서드 이동) 한다.
	 * 4. 임시변수 totalAmount와 frequentRenterPoints 를 (query method) 로 변경 
	 * */
	
	public String statement() {
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" + getName() + "\n";

		//각 영화에 대한 요금 결정
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();

			// 요금 계산 결과
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		// 푸터 추가
		result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n"; // 총가격
		result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + 
				  "frequentRenterPoints";// 마일리지

		return result;
	}
	//html용계산서 ... 어떠한 종류의 계산서가와도 빠르고 쉽게 만들수있음
	public String htmlStatement() {
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "<h1>Rental Record for</h1>" + getName() + "<br>\n";

		//각 영화에 대한 요금 결정
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();

			// 요금 계산 결과
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		// 푸터 추가
		result += "<p>Amount owed is" + String.valueOf(getTotalCharge()) + "\n"; // 총가격
		result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + 
				  "frequentRenterPoints</p>";// 마일리지

		return result;
	}
	
	//frequentRenterPoints 를 메소드로 변경
	public int getTotalFrequentRenterPoints() {
		int result = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();
			result += each.getFrequentRenterPoints();
			
		}
		return result;
	}
	//totalAmount 를 메소드로 변경
	public double getTotalCharge() {
		double result = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();
			result += each.getCharge();
			
		}
		return result;
	}


}
