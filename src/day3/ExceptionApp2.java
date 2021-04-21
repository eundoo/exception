package day3;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp2 {
	
	public static void main(String[] args) {
		
		//프로그램이 점유했던 컴퓨터의 자원으로 자동으로 해제하기
		/*
		 * try (자원을 점유하는 객체를 생성하는 수행문) {
		 * 		점유한 자원을 사용하는 수행문;
		 * 		점유한 자원을 사용하는 수행문;
		 * 		점유한 자원을 사용하는 수행문;
		 * } catch(예외 e) {
		 * 		예외 발생시 실행할 수행문;
		 * }
		 * 위와 같이 작성한 프로그램은 객체가 사용했던 컴퓨터 자원을 안전하게 해제시켜준다.
		 * AutoCloseable인터페이스를 구현한 하위 클래스만 자동 자원해제가 지원된다.
		 * 자바7버전부터 지원된다.
		 */
		
		//Autocloseable은 이렇게 try()안에 괄호에 close될것을 넣는것 그러면
		//자동으로 닫힌다.
		try (FileWriter writer = new FileWriter("src/day3/sample1.txt")) {
			writer.write("자동 자원해제");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
