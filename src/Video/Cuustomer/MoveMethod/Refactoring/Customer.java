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


	/* �����丵 
	 * 1. �������� �ʴ� ������ �Ķ���ͷ� �ѱ� �� �ִ�.
	 * 2. �������� �����ִ� �ڵ带 ã�Ƽ� Extract Method(�޼ҵ� ����) �Ѵ�  
	 * 3. ���� Ŭ������ ������ ������� �ʴ� �޼ҵ�� ������ �������ִ� Ŭ������ Move Method(�޼��� �̵�) �Ѵ�.
	 * */
	
	public String statement() {
		double totalAmout = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" + getName() + "\n";

		//�� ��ȭ�� ���� ��� ����
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();

			frequentRenterPoints += each.getFrequentRenterPoints();

			// ��� ��� ���
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			totalAmout += each.getCharge();
		}
		// Ǫ�� �߰�
		result += "Amount owed is" + String.valueOf(totalAmout) + "\n"; // �Ѱ���
		result += "You earned" + String.valueOf(frequentRenterPoints) + 
				  "frequentRenterPoints";// ���ϸ���

		return result;

	}


}
