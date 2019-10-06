package Video.Cuustomer.MoveMethod.Refactoring;

// ��ȭ�� �뿩  Ŭ����
public class Rental {
	//��ȭ
	private Movie movie;
	//�뿩�Ⱓ
	private int dayrented;

	public Rental(Movie movie, int dayrented) {
		//���, ��������
		this.movie = movie;
		this.dayrented = dayrented;
	}
	public Movie getMovie() {
		return movie;
	}
	public int getDayrented() {
		return dayrented;
	}
	//3. �� �̿� �̵��� �޼��� (�޼��� �� ������ ����)
	double getCharge() {
		double result = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (getDayrented() > 2)
				result += (getDayrented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += getDayrented() * 3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if (getDayrented() > 3)
				result += (getDayrented() - 3) * 1.5;
			break;
		}
		return result;
	}
	
	
}
