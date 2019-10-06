package Video.Cuustomer.ExtractMethod.Refactoring;

//비디오 이름 과 요금 클래스
public class Movie {
	//요금
	public static final int CHILDREN = 2; //어린이용
	public static final int REGULAR = 0; //보통
	public static final int NEW_RELEASE = 1; //최신	
	
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
}
