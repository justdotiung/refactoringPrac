package Video.Cuustomer.ExtractMethod.Refactoring;

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
	 * */
	// 계산서 생성 메소드 리팩토링
	public String statement() {
		double totalAmout = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" + getName() + "\n";

		//각 영화에 대한 요금 결정
		while (rentalElements.hasNext()) {
			double thisAmount = 0;
			Rental each = rentalElements.next();

			thisAmount = amountFor(each);

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
	//2.을 이용 추출된 메서드 부분.. (변수명과 파라미터명 을 적절히 변경)
	private double amountFor(Rental aRental) {
		double result = 0;
		switch (aRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (aRental.getDayrented() > 2)
				result += (aRental.getDayrented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += aRental.getDayrented() * 3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if (aRental.getDayrented() > 3)
				result += (aRental.getDayrented() - 3) * 1.5;
			break;
		}
		return result;
	}
}
