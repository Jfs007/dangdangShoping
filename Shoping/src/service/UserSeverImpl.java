package service;

import javamail.SendEmailUtil;
import dao.UserDao;
import entiy.DUser;

public class UserSeverImpl implements UserSever{
   private UserDao userDao;
	public UserDao getUserDao() {
	return userDao;
}
	public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}
	//DUser dUser =null;
	//验证用户是否存在
	public DUser Validate(DUser dUser) {
		// TODO Auto-generated method stub
		
		dUser=userDao.Validate(dUser);
		if(dUser==null)
		{
			System.out.println("d");
		return null;
		}
		else
		{
			System.out.println(dUser.getId()+"有吗");
		return dUser;
		}
	}
	@Override
	public void reg(DUser dUser) {
		// TODO Auto-generated method stub
		/*private Integer id;
		private String email;
		private String nickname;
		private String password;
		private Integer userIntegral;
		private String isEmailVerify;
		private String emailVerifyCode;
		private Long lastLoginTime;
		private String lastLoginIp;*/
		int num = (int) (Math.random()*100000+99999);
		String emailVerifyCode =String.valueOf(num);
		SendEmailUtil send = new SendEmailUtil();
		send.sendEmail("来自当当网的验证码", emailVerifyCode, dUser.getEmail());
		dUser.setEmailVerifyCode(emailVerifyCode);
		dUser.setIsEmailVerify("N");
		dUser.setUserIntegral(0);
		userDao.reg(dUser);
		
	}
	@Override
	public int regValidate(String valicode) {
		// TODO Auto-generated method stub
		DUser duser =userDao.seachduser();
		int userid =duser.getId(); 
		int num =userDao.regValidate(valicode, userid);
		if(num==0){
			
			return 0;
		}
		else{
			
			userDao.uservalidateOk(userid);
			return 1;
		}
		
		
	}

}
