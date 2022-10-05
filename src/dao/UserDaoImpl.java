package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import actionController.DBAction;
import dto.User;

public class UserDaoImpl implements UserDao{

	@Override
	public int loginchk(String user_id, String user_pw) throws Exception {//로그
		Connection conn =DBAction.getinstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		int result = 0;
		String sql = "select * from user where user_id=? and user_pw=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "user_id");
			pstmt.setString(2, "user_pw");
			rs = pstmt.executeQuery();
			System.out.println("UserDaoImpl loginchk rs->"+rs);
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
			
		} catch (Exception e) {
			System.out.println("UserDaoImpl loginchk exception->");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println("UserDaoImpl loginchk finally exception->");
				e.printStackTrace();
			}
		}
		
		
		return result;
	}//end of loginchk

}//end of class
