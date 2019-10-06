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


	/* �����丵 
	 * 1. �������� �ʴ� ������ �Ķ���ͷ� �ѱ� �� �ִ�.
	 * 2. �������� �����ִ� �ڵ带 ã�Ƽ� Extract Method(�޼ҵ� ����) �Ѵ�  
	 * */
	// ��꼭 ���� �޼ҵ� �����丵
	public String statement() {
		double totalAmout = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" + getName() + "\n";

		//�� ��ȭ�� ���� ��� ����
		while (rentalElements.hasNext()) {
			double thisAmount = 0;
			Rental each = rentalElements.next();

			thisAmount = amountFor(each);

			// ���ϸ��� �߰�
			frequentRenterPoints++;
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayrented() > 1)
				frequentRenterPoints++;

			// ��� ��� ���
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmout += thisAmount;
		}
		// Ǫ�� �߰�
		result += "Amount owed is" + String.valueOf(totalAmout) + "\n"; // �Ѱ���
		result += "You earned" + String.valueOf(frequentRenterPoints) + "frequentRenterPoints";// ���ϸ���

		return result;

	}
	//2.�� �̿� ����� �޼��� �κ�.. (������� �Ķ���͸� �� ������ ����)
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
