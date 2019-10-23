package Video.Cuustomer.MoveMethod.Refactoring;

import Video.Cuustomer.polymorphism.Refactoring.ChildrenPrice;
import Video.Cuustomer.polymorphism.Refactoring.NewReleasePrice;
import Video.Cuustomer.polymorphism.Refactoring.Price;
import Video.Cuustomer.polymorphism.Refactoring.RegularPrice;

/*
 *  ������ �� ���� �����丵  
 *  1.���ο� �з� ���
 *  2.��ݰ� ����Ʈ ����
 *  ���
 *  1. switch�� , ���ϸ��� Movie class�� �̵�.
 *  2. Movie�� ��ӹ޴� 3���� class�� �����
 *  3. ������������ �̿��� �����丵 (������Ʈ ���� �̿�)
 *  4. getCharge() switch ���� ���ش�.
 *  5. ������ ��� Ŭ������ �ڵ�� ��� ���� ���ϸ����� �ʿ��Ѻκп� ����Ѵ�.
 * */
//���� �̸� �� ��� Ŭ����
public class Movie {
	//���
	public static final int CHILDREN = 2; //��̿�
	public static final int REGULAR = 0; //����
	public static final int NEW_RELEASE = 1; //�ֽ�	
	
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
