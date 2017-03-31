package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entiy.DCategory;
import entiy.DCategoryProduct;

public class CatDaoImpl extends HibernateDaoSupport implements CatDao  {

	@SuppressWarnings("unchecked")
	@Override
	//查询子类
	public List<DCategory> getCatChcbyId() {
		
		Session session =super.getSession();
		//HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
		List<DCategory> list=new ArrayList<DCategory>();
		//String hqlStr="";
	
		Criteria criter =session.createCriteria(DCategory.class);
		criter.addOrder(Order.asc("parentId"));	
		criter.add(Restrictions.gt("parentId",1));
		
	    list =criter.list();
		
		session.close();
		return list;
	}
	//查询父类
	public List<DCategory> getCatPrcbyId() {
		
		Session session =super.getSession();
		//HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
		List<DCategory> list=new ArrayList<DCategory>();
		//String hqlStr="";
	   // DCategory  cat = (DCategory) session.get(DCategory.class, 2);
	    
		Criteria criter =session.createCriteria(DCategory.class);
		criter.addOrder(Order.asc("parentId"));	
		criter.add(Restrictions.eq("parentId",1));
		
	    list =criter.list();
		
		session.close();
		return list;
		}

	}
