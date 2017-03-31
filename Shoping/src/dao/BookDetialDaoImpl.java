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
	
	////���������ҵ�dp��������Ϊ��ҳ��׼��
	public List<DCategoryProduct> getCPbyCid(int CatId){
		Session session =super.getSession();
		//HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
		List<DCategoryProduct> list=new ArrayList<DCategoryProduct>();
		//String hqlStr="";
	    DCategory  cat = (DCategory) session.get(DCategory.class, CatId);
	    System.out.println(cat.getId()+"���ϲ鵽����cat��id����idΪ"+CatId);
		Criteria criter =session.createCriteria(DCategoryProduct.class);
		criter.add(Restrictions.eq("DCategory",cat));		
	    list =criter.list();
		
		session.close();
		return list;
		
	}
//����cat��id��ѯDcategoryProduct
	public List<DCategoryProduct> getPrbyCp(int CatId,int PageNum){
		Session session =super.getSession();
		//HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
		List<DCategoryProduct> list=new ArrayList<DCategoryProduct>();
		//String hqlStr="";
	    DCategory  cat = (DCategory) session.get(DCategory.class, CatId);
	    System.out.println(cat.getId()+"���ϲ鵽����cat��id����idΪ"+CatId);
		Criteria criter =session.createCriteria(DCategoryProduct.class);
		criter.setFirstResult((PageNum-1)*3);
		criter.setMaxResults(3);
		criter.add(Restrictions.eq("DCategory",cat));
		
	    list =criter.list();
		
		session.close();
		return list;
		
	}
//����Dproduct��id��ѯ������ϸ��
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
	//���Ҹ�������id�����ж��ٱ��鲢���ؿ��Լ��ؼ�ҳ
	@Override
	public int getPageCountbyid(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	//�����ķ���
	public List<DCategory> getCPbyId() {
		// TODO Auto-generated method stub
		return null;
	}
	//�����Ƽ�
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
	//����
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
