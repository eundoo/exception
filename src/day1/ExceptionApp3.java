package day1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionApp3 {
	
	//예외가 발생되는 메소드 사용
	//try~catch 구문을 사용해서 예외처리를 직접수행함.
	//첫번째 방법 
	public static void writeText1(String path, String text) {
		try {
			PrintWriter writer = new PrintWriter(path); //예외발생이 예상되는 메소드 사용
			writer.write(text);
			writer.close();
		} catch(FileNotFoundException e) {
			System.out.println("파일경로가 올바르지 않습니다.");
		}
	}

	//예외가 발생되는 메소드 사용
	//throw키워드를 사용해서 메소드를 호출하는 측에게 예외처리를 위임(떠넘기기)함
	//두번째 방법 (계속 떠넘겨서 한 군데서 해결하게 하는 이 방법이 선호됨)
	public static void writeText2(String path, String text) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(path);
		writer.write(text);
		writer.close();
	}
			
	public static void main(String[] args) {
		//예외를 직접처리하는 메소드를 사용하는 경우
		//예외처리 부담이 없다.
		writeText1("src/day1/샘플2.txt", "try~catch구문으로 직접 예외처리하는 메소드");
		
		//예외를 직접처리하지 않고 떠넘기는 메소드를 사용하는 경우
		//그 메소드를 호출(사용, 실행)하는 곳에서 예외를 대신 처리해야 한다.
		try {
		writeText2("src/day1/샘플3.txt","throws키워드로 예외처리를 떠넘기는 메소드");
		} catch(FileNotFoundException e) {
			System.out.println("경로가 올바르지 않습니다.");
			e.printStackTrace();
		}
	}

}
