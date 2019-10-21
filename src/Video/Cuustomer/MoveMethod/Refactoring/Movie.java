package Video.Cuustomer.MoveMethod.Refactoring;
/*
 *  ������ �� ���� �����丵  
 *  1.���ο� �з� ���
 *  2.��ݰ� ����Ʈ ����
 *  ���
 *  1. switch�� , ���ϸ��� Movie class�� �̵�.
 *  2. Movie�� ��ӹ޴� 3���� class�� �����
 *  3. 
 * */
//���� �̸� �� ��� Ŭ����
public class Movie {
	//���
	public static final int CHILDREN = 2; //��̿�
	public static final int REGULAR = 0; //����
	public static final int NEW_RELEASE = 1; //�ֽ�	
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) {
		this._title = title;
		this._priceCode = priceCode;
	}

	public String geTitle() {
		return _title;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		this._priceCode = arg;
	}
	
	//switch ���� �ڽ��� �����͸� ����ϴ°��� �ٶ����ϴ�. 
		double getCharge(int daysRented) {
			double result = 0;
			switch (getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += daysRented * 3;
				break;
			case Movie.CHILDREN:
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
			}
			return result;
		}
		
		public int getFrequentRenterPoints(int daysRented) {
			// ���ϸ��� �߰�
			if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
				return 2;
			else {
				return 1;
			}
		}
		
}
