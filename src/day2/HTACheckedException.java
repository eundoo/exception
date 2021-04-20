package day2;

//사용자 정의 예외 클래스 작성하기
public class HTACheckedException extends Exception{

	public HTACheckedException(String msg) {
		super(msg);
	}
	
	public HTACheckedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
