package Video.Cuustomer.ExtractMethod.Refactoring;

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
	
	
}
