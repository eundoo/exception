package day2.user;

import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService service = new UserService();

		while(true) {
			try {
				System.out.println("------------------------------------");
				System.out.println("1.가입하기 2.비밀번호변경 3.회원탈퇴 4.조회 0.종료");
				System.out.println("------------------------------------");
				
				System.out.println("메뉴선택 > ");
				int menuNo = sc.nextInt();
				System.out.println();
				System.out.println();
				
				if(menuNo == 1) {
					System.out.println("[회원가입]");
					System.out.println("아이디 입력> ");
					String id = sc.next();
					System.out.println("이름 입력> ");
					String name = sc.next();
					System.out.println("비밀번호 입력> ");
					String password = sc.next();
					
					User user = new User(id, name, password);
					service.insertUser(user);
					System.out.println("[안내] 회원가입이 완료되었습니다.");
					
				} else if(menuNo == 2) {
					System.out.println("[비밀번호 변경]");
					System.out.println("아이디 입력 > ");
					String id = sc.next();
					System.out.println("기존 비밀번호 입력 > ");
					String oldPassword = sc.next();
					System.out.println("새 비밀번호 입력 > ");
					String newPassword = sc.next();
					
					service.changeUserPassword(id, oldPassword, newPassword); //해당 메소드가 던진 예외를 받으면 catch블록으로 점프
					System.out.println("[안내] 비밀번호가 변경되었습니다.");
					
				} else if(menuNo == 3) {
					System.out.println("[회원탈퇴]");
					System.out.println("아이디 입력 > ");
					String id = sc.next();
					System.out.println("비밀번호 입력 > ");
					String password = sc.next();
					
					service.deleteUserById(id, password); //해당 메소드가 던진 예외를 받으면 catch블록으로 점프
					System.out.println("[안내] 회원탈퇴가 완료되었습니다.");

				} else if (menuNo == 4) { 
					System.out.println("[회원조회]");
					System.out.println("아이디 입력> ");
					String userId = sc.next();
					User user = service.getUserById(userId);
					
					if(user == null) {
						throw new UserNotFoundException(userId);
					}
					
					System.out.println("회원정보");
					System.out.println("아이디: " + user.getId());
					System.out.println("비밀번호: " + user.getPassword());
					System.out.println("이름: " + user.getName());
	
				} else if(menuNo == 0) {
					System.out.println("[프로그램 종료]");
				}

				} catch(UserException e) {
					System.out.println("[오류]" + e);

				}
			System.out.println();
			System.out.println();
			System.out.println();
			}
		}
}
