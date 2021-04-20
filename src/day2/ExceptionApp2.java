package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp2 {
	
	public static void test1() throws HTACheckedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/day2/sample1.txt"));
			String text = reader.readLine();
			System.out.println("파일내용: " + text);
			reader.close();
		} catch (FileNotFoundException cause) {
			// FileNotFoundException 을 가로채고 대신 HTACheckedException을 발생시킴
			throw new HTACheckedException("파일 경로가 올바르지 않음", cause);
		} catch (IOException cause) {
			throw new HTACheckedException("파일 읽기 오류", cause);
		}
	}
	
	public static Date strToDate(String dateString) throws HTACheckedException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(dateString);
		} catch (ParseException cause) {
			throw new HTACheckedException("올바른 날짜 형식이 아닙니다.", cause);
		}
	}	
	public static void main(String[] args) {
		try {
			test1();
			Date day = strToDate("2021-12-25");
			System.out.println(day);
		} catch (HTACheckedException e) {
			e.printStackTrace();
		}

	}

}
