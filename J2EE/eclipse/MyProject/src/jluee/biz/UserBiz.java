package jluee.biz;

import jluee.dao.UserDao;
import jluee.entity.User;

public class UserBiz {
	public User logincheck(String userName, String passWord) {
		UserDao dao = new UserDao();
		dao.connectToDb();
		User user = dao.userSelect(userName);

		if (user.getIdendity().equals("admin")) {
			user.setIdendity("admin");
		} else {
			user.setIdendity("normal");
		}

		if (passWord.equals(user.getPassWord())) {
			user.setStatus("��¼�ɹ�");
		} else {
			user.setStatus("�û������������");
		}
		return user;
	}
}
