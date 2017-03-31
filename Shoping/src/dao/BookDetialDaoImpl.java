package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entiy.DBook;
import entiy.DCategory;
import entiy.DCategoryProduct;
import entiy.DProduct;

public class BookDetialDaoImpl extends HibernateDaoSupport implements BookDetialDao  {

	@Override
	
	////根据书类找到dp的数量，为分页做准备
	public List<DCategoryProduct> getCPbyCid(int CatId){
		Session session =super.getSession();
		//HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
		List<DCategoryProduct> list=new ArrayList<DCategoryProduct>();
		//String hqlStr="";
	    DCategory  cat = (DCategory) session.get(DCategory.class, CatId);
	    System.out.println(cat.getId()+"以上查到的是cat的id根据id为"+CatId);
		Criteria criter =session.createCriteria(DCategoryProduct.class);
		criter.add(Restrictions.eq("DCategory",cat));		
	    list =criter.list();
		
		session.close();
		return list;
		
	}
//根据cat的id查询DcategoryProduct
	public List<DCategoryProduct> getPrbyCp(int CatId,int PageNum){
		Session session =super.getSession();
		//HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
		List<DCategoryProduct> list=new ArrayList<DCategoryProduct>();
		//String hqlStr="";
	    DCategory  cat = (DCategory) session.get(DCategory.class, CatId);
	    System.out.println(cat.getId()+"以上查到的是cat的id根据id为"+CatId);
		Criteria criter =session.createCriteria(DCategoryProduct.class);
		criter.setFirstResult((PageNum-1)*3);
		criter.setMaxResults(3);
		criter.add(Restrictions.eq("DCategory",cat));
		
	    list =criter.list();
		
		session.close();
		return list;
		
	}
//根据Dproduct的id查询该书详细；
	public DProduct getDproductbyId(int id){
		Session session =super.getSession();
		//List<DProduct> dplist = new ArrayList<DProduct>();
		DProduct dproduct = new DProduct();
		Criteria criter =session.createCriteria(DProduct.class);
		criter.add(Restrictions.eq("id",id));
		dproduct = (DProduct)criter.uniqueResult();
		session.close();
		return  dproduct;
		
	}
	//查找根据书类id来查有多少本书并返回可以加载几页
	@Override
	public int getPageCountbyid(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	//废弃的方法
	public List<DCategory> getCPbyId() {
		// TODO Auto-generated method stub
		return null;
	}
	//主便推荐
	@Override
	public List<DProduct> recommend() {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		Criteria criter = session.createCriteria(DProduct.class);
		criter.add(Expression.sql("1=1 order by rand() limit 3"));
		List<DProduct> dplist;
		dplist = (criter.list());
		session.close();
		return dplist;
	}
	//新书
	@Override
	public List<DProduct> newbook() {
		// TODO Auto-generated method stub
		Session session =super.getSession();
		Criteria criter =session.createCriteria(DProduct.class);
		criter.addOrder(Order.desc("addTime"));
		criter.setFirstResult(0);
		criter.setMaxResults(3);
		List<DProduct> newdplist;
		newdplist = criter.list();
		session.close();
		return newdplist;
	}
	
	
}
