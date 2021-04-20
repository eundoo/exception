package day2.user;

import java.util.ArrayList;
import java.util.Iterator;

public class UserService {

	ArrayList<User> users = new ArrayList<User>();
	
	public UserService() {
		users.add(new User("hong", "홍당당", "1234"));
		users.add(new User("kim", "김당당", "1234"));
		users.add(new User("oh", "오당당", "1234"));
		users.add(new User("lee", "이당당", "1234"));
		users.add(new User("yu", "유당당", "1234"));
		}
	
	//새 사용자 등록기능 (아이디, 이름, 비밀번호 포함)등록기능
	//동일한 아이디로 가입된 사용자가 존재하면 UserAlreadyExistException을 던진다.
	public void insertUser(User user) {
		User savedUser = getUserById(user.getId());
		if(savedUser != null) {		//이미 동일한 아이디의 사용자가 등록되어 있다면 
			throw new UserAlreadyExistsException(user.getId());
		}
		
		users.add(user);
	}
	//아이디를 전달받아서 해당 아이디로 가입한 사용자를 반환하는 기능
	//아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던진다.
	public User getUserById(String userId) {
		for(User user : users) {
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		throw new UserNotFoundException(userId);
	}
	
	//아이디, 이전비밀번호, 새 비밀번호를 전달받아서 비밀번호를 변경하는 기능
	//아이디에 해당하는 사용자가 존재하지 않으면 UserNotfoundException을 던진다.
	//비밀번호가 일치하지 않으면 PasswordMismatchException을 던진다.
	public void changeUserPassword(String userId, String oldPassword, String newPassword) {
		User savedUser = getUserById(userId);
		if(savedUser == null) {	//아이디에 해당하는 사용자의 정보가 존재하지 않다면
			throw new UserNotFoundException(userId);	//예외던지고 메소드 종료
		}
		if(!savedUser.getPassword().equals(oldPassword)) {	//비밀번호가 일치하지 않는다면
			throw new PasswordMismatchException(userId);	//예외던지고 메소드 종료
		}
		
		savedUser.setPassword(newPassword);
	}
	
	//아이디를 전달받아서 해당 아이디로 가입한 사용자를 삭제하는 기능
	//아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던진다.
	public void deleteUserById(String userId, String password) {
		User savedUser = getUserById(userId);
		if(savedUser == null) {
			throw new UserNotFoundException(userId);
		}
		if (!savedUser.getPassword().equals(password)) {	//비밀번호가 일치하지 않는다면
			throw new PasswordMismatchException(userId);	//예외던지고 메소드 종료
			
		}
		
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {		//Iterator에서 다음번 반복할 데이터가 있는지 확인
			User user = iterator.next();	//Iterator에서 데이터를 조회한다.
			if(user.getId().equals(userId)) {
				iterator.remove();			//지금 조회한 데이터를 삭제한다.
				break;				
			}
		}
	}
	
	/*
	public User findUserById(String id) {
		User foundUser = null;
		
		for(User user : users) {
			if(user.getId().equals(id)) {
				foundUser = user;
				break;
			}
		}
		return null;
		
	//for 보다 위에있으면 지금 무조건 null이니까 여기에 적어야함.
	if (foundUser == null) {
		throw new UserNotFoundException(id);
	}
	
	return foundUser;
	
	//1번처럼코딩
	public void changePassword(String id, String oldPwd, String newPwd) {
		User user findUserById(id);
		if(User i = null ) {
			if(user.getPassword().equals(oldPwd)) {
				user.getPassword(newPwd);
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		} else {
			System.out.println("아이디와 일치하는 사용자가 존재하지 않습니다.");
		}
		
		}
	}	
	//2번 코딩
	public void changeWord2(String id ,String old oldPwd, String newPwd) {
		User user = findUserById2(id) 	//예외발생, 메소드 종료
	}
	*
	*/
	

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
