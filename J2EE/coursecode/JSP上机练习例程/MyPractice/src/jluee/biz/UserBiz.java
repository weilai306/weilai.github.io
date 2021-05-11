package jluee.biz;

import jluee.dao.UserDao;
import jluee.entity.User;
import jluee.util.Log;

public class UserBiz {
	
	public User login(String uname,String pwd) throws Exception{
		
		User user = null;
		
		//���У��-����Ϊ��ָ��Ҳ����Ϊ���ַ���
		if(uname != null && !uname.equals("") && pwd != null && !pwd.equals("")){
			
			UserDao dao = new UserDao();
			try {
				user = dao.login(uname, pwd);
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
				throw e;
			}finally{
				dao.closeResource();
			}			
		}		
		
		return user;
	}	

	
	public void register(User user) throws Exception{
		UserDao dao = new UserDao();
		try {
			dao.registerUser(user);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeResource();
		}
		
	}

}
