package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp1 {
	
	public static void test1() throws FileNotFoundException, IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("src/day2/sample1.txt"));
		String text = reader.readLine();
		System.out.println("파일내용: " + text);
		reader.close();
	}
	
	public static Date strToDate(String dateString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(dateString);
	}
	public static void main(String[] args) {
		//메인 메소드에서 실행하는 모든 메소드가 다양한 메소드에 대한 예외처리를
		//메인 메소드에게 예외처리를 위힘하고 있음
		//사용하는 메소드의 종류가 늘어날 수록 예외처리하는 코드의 양도 늘어난다.
		try {
			System.out.println("파일내용 읽기");
			ExceptionApp1.test1();
		
			System.out.println("날짜형식의 문자열을 Date로 변환하기");
			Date day = ExceptionApp1.strToDate("2020-12-25");
			System.out.println(day);
		
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다.");
			} catch (IOException e) {
				System.out.println("파일을 읽어오는 중 오류가 발생하였습니다.");
			} catch (ParseException e) {
				System.out.println("올바른 형식의 날짜 표현식이 아닙니다.");
			}
	
	}

}
