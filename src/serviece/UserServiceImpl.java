package serviece;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();

	@Override
	public int loginchk(String user_id, String user_pw){//로그인
		int result=0;
		try {
			result = ud.loginchk(user_id, user_pw);
			if(result == 1 ) {
				System.out.println("로그인 성공");
				return result;
			}else
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
