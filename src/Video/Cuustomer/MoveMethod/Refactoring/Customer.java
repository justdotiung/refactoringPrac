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
	 * 4. �ӽú��� totalAmount�� frequentRenterPoints �� (query method) �� ���� 
	 * */
	
	public String statement() {
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" + getName() + "\n";

		//�� ��ȭ�� ���� ��� ����
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();

			// ��� ��� ���
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		// Ǫ�� �߰�
		result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n"; // �Ѱ���
		result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + 
				  "frequentRenterPoints";// ���ϸ���

		return result;
	}
	//html���꼭 ... ��� ������ ��꼭���͵� ������ ���� ���������
	public String htmlStatement() {
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "<h1>Rental Record for</h1>" + getName() + "<br>\n";

		//�� ��ȭ�� ���� ��� ����
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();

			// ��� ��� ���
			result += "\t" + each.getMovie().geTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		// Ǫ�� �߰�
		result += "<p>Amount owed is" + String.valueOf(getTotalCharge()) + "\n"; // �Ѱ���
		result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + 
				  "frequentRenterPoints</p>";// ���ϸ���

		return result;
	}
	
	//frequentRenterPoints �� �޼ҵ�� ����
	public int getTotalFrequentRenterPoints() {
		int result = 0;
		Iterator<Rental> rentalElements = rentals.iterator();
		while (rentalElements.hasNext()) {
			Rental each = rentalElements.next();
			result += each.getFrequentRenterPoints();
			
		}
		return result;
	}
	//totalAmount �� �޼ҵ�� ����
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
