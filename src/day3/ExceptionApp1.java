package day3;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp1 {

	public static void main(String[] args) {
		
		FileWriter writer = null;
		
		try {
			//원래 여기 안에 FileWriter writer = new FileWriter(); 있었는데 try밖에서도 
			//사용해야 되기 때문에 변수선언문을 밖으로 빼고 변수에 저장하는부분만 이 안으로 넣는다. 중요 ******
			writer = new FileWriter("src.day3.sample1.txt");	//컴퓨터의 입출력 자원 점유
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			writer.write("finally 블록연습\n");	//컴퓨터의 입출력 자원 사용 -파일에기록
			
			//아래의 코드는 try블록 내의 모든 수행문이 오류없이 실행된 후에 실행되는 수행문이다.
			//try블록내의 수행문 실행 중 오류가 발생하면 실행되지 않는 수행문이다.
			// * 점유했던 자원을 해제시키는 수행문의 위치로 적절하지 않다.
			writer.close();		//프로그램이 점유했던 컴퓨터의 자원을 해제하는 수행문
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			//FileWriter 객체 생성 후 점유했던 컴퓨터의 자원을 해제하는 수행문
			try {
				if(writer != null) {
					writer.close();
				}
			} catch(IOException e) {
				//수행할 작없 없음
			}
			
			//근데 일일이 finally를 써줄수도 있고 그러면 코드가 안멋짐..
			//그래서 7버전부터 AutoClosed를 해줘야함 그것은 App2로 
		}

	}

}
