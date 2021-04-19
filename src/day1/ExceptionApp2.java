package day1;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp2 {

	public static void main(String[] args) {
		try {
			System.out.println("샘플1.txt 파일에 내용 기록하기");

			//오류가 발생했기 때문에 실행안됨
			//여기서 day1을 다른이름으로 오타를 내보고 런시켜서 확인하고 오류메세지 읽어봐
			FileWriter writer = new FileWriter("src/day1/샘플1.txt");
			System.out.println("샘플1.txt 파일에 내용을 기록하는 FileWriter객체 생성하기");
			
			writer.write("파일 쓰기 연습");
			System.out.println("샘플1.txt 파일에 텍스트 기록");
			
			writer.close();
			System.out.println("컴퓨터의 입출력 장치와의 연결 해제");
			//이 안에것들 실행안됨
		} catch (IOException e) {
			//변수 e에는 try블록에서 발생한 예외객체 중에서 
			//IOException 타입의 객체 혹은 그 하위 타입의 객체가 들어있다.
			//예외객체는 예외가 발생한 원인 및 예외가 발생한 코드에 대한 정보를 가지고 있다.
			//주요 메소드
			//		String e.getMessage()
			//			발생한 예외에 대한 상세한 정보(에러메세지, 발생원인)를 반환한다.
			//		void printStackTrace()
			//			예외클래스명과 에러메세지 및 
			//			예외가 발생한 실행문을 실행순서대로 화면에 출력한다.
			System.out.println("try블록엥서 발생한 예외객체");
			System.out.println(e);
			System.out.println("에러 메세지: " + e.getMessage());
			System.out.println("printStackTrace() 메소드 실행결과");
			e.printStackTrace();
			System.out.println("샘플1.txt파일 내용 기록하기 도중 오류가 발생하였습니다.");
		}

	}

}
