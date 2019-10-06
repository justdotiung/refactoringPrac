package Video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// 대여점 고객 클래스
public class Customer {
	//고객이름
	private String name;
	//private Vector<Rental> rentals = new Vector<>();
	//대여리스트
	private List<Rental> rentals =new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}
	
	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}
	
	//계산서 생성 메소드
	public String statement() {
		//총 금액
		double totalAmout = 0;
		//최신인지 여부에 따라 달라지는 포인트
		int frequentRenterPoints = 0;
		//컬렉션프레임 워크에서 어떤것이라도 동일하게 접근 가져오고 할수있게 만든다. 다형성.
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" +getName() +"\n";
		//랜탈 한 데이터 반복
		while (rentalElements.hasNext()) {
			double thisAmount = 0;
			//각각의 비디오 영화와 
			Rental each = rentalElements.next();
			
			//각 영화에 대한 요금 결정
			switch (each.getMovie().getPriceCode()) {
			//일반영화	
			case Movie.REGULAR:
					thisAmount += 2;
					//2일보다 오래 렌탈
					if (each.getDayrented() > 2)
						thisAmount += (each.getDayrented() -2) * 1.5;
					break;
			//최신영화
			case Movie.NEW_RELEASE:
				//일수 상관없이
				thisAmount += each.getDayrented() *3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if(each.getDayrented() > 3)
					thisAmount += (each.getDayrented() - 3) * 1.5;
				break;
			}
			
			//마일리지 추가
			frequentRenterPoints ++;
			//최신영화 2일이상 대여시 추가 마일리지
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayrented() > 1)
				frequentRenterPoints++;
			
			//요금 계산 결과 
			result += "\t"+ each.getMovie().geTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmout += thisAmount;
		}
		//푸터 추가
		result += "Amount owed is" + String.valueOf(totalAmout) + "\n"; //총가격
		result += "You earned" + String.valueOf(frequentRenterPoints) + "frequentRenterPoints";//마일리지
		
		return result;
				
	
	}
	
}
