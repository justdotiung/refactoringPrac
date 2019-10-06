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
	 * */
	
	public String statement() {
		double totalAmout = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" + getName() + "\n";

		//각 영화에 대한 요금 결정
		while (rentalElements.hasNext()) {
			double thisAmount = 0;
			Rental each = rentalElements.next();
			//3. 이용
			thisAmount = each.getCharge();

			// 마일리지 추가
			frequentRenterPoints++;
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayrented() > 1)
				frequentRenterPoints++;

			// 요금 계산 결과
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmout += thisAmount;
		}
		// 푸터 추가
		result += "Amount owed is" + String.valueOf(totalAmout) + "\n"; // 총가격
		result += "You earned" + String.valueOf(frequentRenterPoints) + "frequentRenterPoints";// 마일리지

		return result;

	}
}
