package Video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// �뿩�� �� Ŭ����
public class Customer {
	//���̸�
	private String name;
	//private Vector<Rental> rentals = new Vector<>();
	//�뿩����Ʈ
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
	
	//��꼭 ���� �޼ҵ�
	public String statement() {
		//�� �ݾ�
		double totalAmout = 0;
		//�ֽ����� ���ο� ���� �޶����� ����Ʈ
		int frequentRenterPoints = 0;
		//�÷��������� ��ũ���� ����̶� �����ϰ� ���� �������� �Ҽ��ְ� �����. ������.
		Iterator<Rental> rentalElements = rentals.iterator();
		String result = "Rental Record for" +getName() +"\n";
		//��Ż �� ������ �ݺ�
		while (rentalElements.hasNext()) {
			double thisAmount = 0;
			//������ ���� ��ȭ�� 
			Rental each = rentalElements.next();
			
			//�� ��ȭ�� ���� ��� ����
			switch (each.getMovie().getPriceCode()) {
			//�Ϲݿ�ȭ	
			case Movie.REGULAR:
					thisAmount += 2;
					//2�Ϻ��� ���� ��Ż
					if (each.getDayrented() > 2)
						thisAmount += (each.getDayrented() -2) * 1.5;
					break;
			//�ֽſ�ȭ
			case Movie.NEW_RELEASE:
				//�ϼ� �������
				thisAmount += each.getDayrented() *3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if(each.getDayrented() > 3)
					thisAmount += (each.getDayrented() - 3) * 1.5;
				break;
			}
			
			//���ϸ��� �߰�
			frequentRenterPoints ++;
			//�ֽſ�ȭ 2���̻� �뿩�� �߰� ���ϸ���
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayrented() > 1)
				frequentRenterPoints++;
			
			//��� ��� ��� 
			result += "\t"+ each.getMovie().geTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmout += thisAmount;
		}
		//Ǫ�� �߰�
		result += "Amount owed is" + String.valueOf(totalAmout) + "\n"; //�Ѱ���
		result += "You earned" + String.valueOf(frequentRenterPoints) + "frequentRenterPoints";//���ϸ���
		
		return result;
				
	
	}
	
}
