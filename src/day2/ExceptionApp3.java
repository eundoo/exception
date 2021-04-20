package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp3 {

	//뒤에 throws를 안적어도 된다고 근데 그냥 명시적으로 적어줌
	public static void test1() throws HTAUncheckedException{
		try {
			//파일을 한 줄씩 읽어오는게 BufferedReader
			BufferedReader reader = new BufferedReader(new FileReader("src/day2/sample1.txt"));
			String text = reader.readLine();
			System.out.println("파일내용: " + text);
			reader.close();
		} catch(FileNotFoundException e) {
			throw new HTAUncheckedException("파일경로가 올바르지 않습니다.", e); 
		} catch (IOException e) {
			throw new HTAUncheckedException("파일읽기 오류가 발생하였습니다.", e);
		}
	}
	
	//강제 발생시킨 HTAUncheckedException 예외는 컴파일러가 예외처리 여부를 체크하지 않는 예외다.
	//따라서, strToDate() 메소드 내부에서 HTAUncheckedException예외를 강제 발생시켜도
	//throws 키워드를 사용하는 예외 떠넘기기를 생략할 수 있다.
	public static Date strToDate(String dateString) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(dateString);	
	} catch (ParseException e) {
		throw new HTAUncheckedException("올바른 날짜 형식이 아닙니다.", e);
	}
}	
	public static void main(String[] args) {
		//test1()과 strToDate()메소드를 예외처리를 강제하지 않는
		//Unchecked예외를 발생시키는 메소드다.
		//test1()과 strToDate()메소드를 사용하는 측에서는 예외처리를 하지 않아도 된다.
		test1();
		
		Date day = strToDate("2010-01-01");
		System.out.println(day);

		try {
			test1();
			Date day2 = strToDate("2010-01-01");
			System.out.println(day2);
		} catch (HTAUncheckedException e) {
			e.printStackTrace();
		}
	}

}
