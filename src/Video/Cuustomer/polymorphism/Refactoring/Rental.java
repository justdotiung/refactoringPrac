package Video.Cuustomer.polymorphism.Refactoring;

/*
 *  ������ �� ���� �����丵  
 *  1.���ο� �з� ���
 *  2.��ݰ� ����Ʈ ����
 *  ���
 *  1. switch�� , ���ϸ��� Movie class�� �̵�.
 * */
// ��ȭ�� �뿩  Ŭ����
public class Rental {
	//��ȭ
	private Movie movie;
	//�뿩�Ⱓ
	private int daysRented;

	public Rental(Movie movie, int dayrented) {
		//���, ��������
		this.movie = movie;
		this.daysRented = dayrented;
	}
	public Movie getMovie() {
		return movie;
	}
	public int getDayrented() {
		return daysRented;
	}
	
	public double getCharge() {
		return movie.getCharge(daysRented);
		
	}
	
	//���ϸ��� 
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
	
}
