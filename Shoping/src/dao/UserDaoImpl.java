package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entiy.DOrder;
import entiy.DUser;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
    
	public DUser Validate(DUser dUser) {
		DUser duser = null;
		Session session =  super.getSession();
		// TODO Auto-generated method stub
		Criteria cri=session.createCriteria(DUser.class);
		cri.add(Example.create(dUser));
		cri.add(Restrictions.eq("isEmailVerify", "Y"));
		duser=(DUser)cri.uniqueResult();
		session.close();
		return duser;
		
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
	Session session = super.getSession();
	Transaction tran = session.beginTransaction();
	session.save(dUser);
	tran.commit();
	session.close();
		
		
		
	}

	@Override
	public int regValidate(String valicode ,int id) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		Criteria criter = session.createCriteria(DUser.class);
		criter.add(Restrictions.eq("id", id));
		criter.add(Restrictions.eq("emailVerifyCode", valicode));
		DUser duser = (DUser) criter.uniqueResult();
		session.close();
		if(duser==null)
		{
		return 0;
		}
		else
		{
		return 1;	
		}
	}

	@Override
	public void uservalidateOk(int userid) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		Transaction tran = session.beginTransaction();
		DUser duser = (DUser) session.get(DUser.class,new Integer(userid));
		duser.setIsEmailVerify("Y");
		session.update(duser);
		tran.commit();
		session.close();
		
	}

	public DUser seachduser(){
		//DUser duser = new DUser();
		Session session = super.getSession();
		Criteria criter = session.createCriteria(DUser.class);
		//criter.add(Restrictions.eq("id", userid));
		criter.add(Restrictions.eq("isEmailVerify", "N"));
		DUser duser = (DUser) criter.uniqueResult();
		return duser;
	}
	
}
