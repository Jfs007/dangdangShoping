package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entiy.DCartItem;
import entiy.DCategoryProduct;
import entiy.DItem;
import entiy.DOrder;
import entiy.DProduct;
import entiy.DReceiveAddress;
import entiy.DUser;

public class ShopDaoImpl extends HibernateDaoSupport implements ShopDao {
//添加地址
	@Override
	public void addAddress(DReceiveAddress drAddress, int id) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		DUser duser;
		duser = (DUser)session.get(DUser.class,new Integer(id));
		Transaction tran = session.beginTransaction();
		drAddress.setDUser(duser);
		session.save(drAddress);
	    tran.commit();
	    session.close();
	}

	
//添加订单  wei  wan cheng 未完成， 不可使用的方法
	@Override
	public void addOrdererror(int addid, int proid, DOrder dorder) {
		// TODO Auto-generated method stub
		DProduct dproduct;
		DReceiveAddress drAddress;
		Session session = super.getSession();
		dproduct = (DProduct)session.get(DProduct.class, new Integer(addid));
		drAddress =(DReceiveAddress) session.get(DReceiveAddress.class, new Integer(addid));
		//dorder.setDUser(DUser);
		
	}
//读取地址根据用户id
	@Override
	public List<DReceiveAddress> byUser(int id) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		DUser duser = (DUser) session.get(DUser.class,new Integer(id));
        //List<DReceiveAddress> drAdress =new ArrayList<DReceiveAddress>();
		Criteria criter =session.createCriteria(DReceiveAddress.class);
		criter.add(Restrictions.eq("DUser",duser));
		List<DReceiveAddress> adresslist;
		adresslist =criter.list();
		session.close();
		return adresslist;
	}

//添加order
public void addOrder(int userid ,int status ,Long time){
	
	Session session = super.getSession();
	//DProduct dproduct =(DProduct) session.get(DProduct.class, new Integer(dprid));
	DUser duser = (DUser)session.get(DUser.class,new Integer(userid));
	Transaction tran = session.beginTransaction();
	//DItem dItem = new DItem();
	DOrder dorder = new DOrder();
	//暂时扔个时间
	//time = 20150308;
	dorder.setOrderTime(time);
	//暂时扔个stauts
	dorder.setStatus(status);
	dorder.setTotalPrice(0.0);
	dorder.setDUser(duser);
	session.save(dorder);
	//设置ditem
//	DItem ditem = new DItem();
//	
//	ditem.setDProduct(dproduct);
//	ditem.setDangPrice(dproduct.getDangPrice());
//	ditem.setProductName(dproduct.getProductName());
//	ditem.setProductNum(1);
//	ditem.setAmount(dproduct.getDangPrice()*1);
	
//	ditem.setDOrder(dorder);
	//dorder.getDItems().add(ditem);
	//session.update(ditem);
    tran.commit();
    session.close();
}

//查询item根据书籍
@Override
public DItem seachitembyDProduct(DProduct dproduct) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.eq("DCategory",dproduct));	
	DItem ditem;
	ditem = (DItem) criter.uniqueResult();
	session.close();
	return ditem;
}

//复杂的查询 try Ok 用于查询购物车是否可以添加 貌似没用了 好了 突然有用了，
@Override
public DItem seachorder(int userid, int dprid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	DProduct dproduct = (DProduct) session.get(DProduct.class,new Integer(dprid) );
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	//Criteria dordercri = session.createCriteria(DOrder.class);
	//dordercri.add(Restrictions.eq("DOrder", dorder));
	//String hql = "select i from DItem i ,DOrder o where i.DOrder= o where ";
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.eq("DProduct",dproduct));
	Criteria ordercri = criter.createCriteria("DOrder");
	ordercri.add(Restrictions.eq("DUser", duser));
	ordercri.add(Restrictions.eq("status", 0));
	//criter.add(Restrictions.eq("DOrder", dorder));
	DItem ditem;
	ditem = (DItem) criter.uniqueResult();
	session.close();
	return ditem;
}

//保存购物车或者订单详情 
@Override
public void addShoporOrder(int dprid,int status,int dpnum,int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
    //DItem ditem;
	Transaction tran = session.beginTransaction();
    //session.beginTransaction();
	DUser duser = (DUser) session.get(DUser.class,new Integer(userid));
    Criteria criter = session.createCriteria(DOrder.class);
    criter.add(Restrictions.eq("DUser", duser));
    DOrder dorder =(DOrder) criter.add(Restrictions.eq("status", status)).uniqueResult();
    DItem ditem = new DItem();
    ditem.setDOrder(dorder);
    DProduct dproduct = (DProduct)session.get(DProduct.class,  new Integer(dprid));
    ditem.setDProduct(dproduct);
    ditem.setDangPrice(dproduct.getDangPrice());
	ditem.setProductName(dproduct.getProductName());
	ditem.setProductNum(dpnum);
	ditem.setAmount(dproduct.getDangPrice()*dpnum);
	session.save(ditem);
	tran.commit();
	session.close();

}

//订单完成 未完成
@Override
public void addOKOrder(int status, int prnum, int addressid ) {
	// TODO Auto-generated method stub
	Session session =super.getSession();
	Transaction tran = session.beginTransaction();
	//DUser duser = (DUser)session.get(Duser, arg1)
	
}

//查询order是否存在
@Override
public int seachisExitOrder(int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	DUser duser =(DUser) session.get(DUser.class, new Integer(userid));
	Criteria criter = session.createCriteria(DOrder.class);
	criter.add(Restrictions.eq("DUser", duser));
	criter.add(Restrictions.eq("status", 0));
	DOrder dorder;
	dorder = (DOrder) criter.uniqueResult();
	session.close();
	if(dorder ==null){		
		return 0;
	}
	else{
		return 1;
	}
}

//查询购物车
@Override
public List<DItem> seachshop(int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	DUser duser =(DUser) session.get(DUser.class, new Integer(userid));
	Criteria criter = session.createCriteria(DOrder.class);
	criter.add(Restrictions.eq("DUser", duser));
	criter.add(Restrictions.eq("status", 0));
	DOrder dorder = (DOrder) criter.uniqueResult();
	//shijiafengshishabi=get(DOrder)citer.unqueResult();
	Criteria cri = session.createCriteria(DItem.class);
	cri.add(Restrictions.eq("DOrder", dorder));
	List<DItem> dilist = new ArrayList<DItem>();
    dilist = cri.list();
	session.close();
	return dilist;
}

//购物车移除
@Override
public void removeshop(int userid, int dprid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	Transaction tran = session.beginTransaction();
	DProduct dproduct = (DProduct) session.get(DProduct.class,new Integer(dprid) );
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	//Criteria dordercri = session.createCriteria(DOrder.class);
	//dordercri.add(Restrictions.eq("DOrder", dorder));
	//String hql = "select i from DItem i ,DOrder o where i.DOrder= o where ";
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.eq("DProduct",dproduct));
	Criteria ordercri = criter.createCriteria("DOrder");
	ordercri.add(Restrictions.eq("DUser", duser));
	ordercri.add(Restrictions.eq("status", 0));
	//criter.add(Restrictions.eq("DOrder", dorder));
	DItem ditem;
	ditem = (DItem) criter.uniqueResult();
	session.delete(ditem);
	tran.commit();
	session.close();
}

//订单修改------------X
@Override
public void updateorder(DCartItem dcartitem ,double totalprice) {
	// TODO Auto-generated method stub
    Session session = super.getSession();
    Transaction tran = session.beginTransaction();
    DReceiveAddress dradress = (DReceiveAddress) session.get(DReceiveAddress.class, new Integer(dcartitem.getAddressId()));
    Criteria criter = session.createCriteria(DOrder.class);
    DUser duser = (DUser) session.get(DUser.class, new Integer(dcartitem.getUserId()));
    criter.add(Restrictions.eq("DUser",duser));
	DOrder dorder =(DOrder) criter.add(Restrictions.eq("status",1)).uniqueResult();
    dorder.setOrderTime(dcartitem.getTime());
    //暂时的
    dorder.setTotalPrice(totalprice);
    dorder.setFullAddress(dradress.getFullAddress());
    dorder.setMobile(dradress.getMobile());
    dorder.setPhone(dradress.getPhone());
    dorder.setPostalCode(dradress.getPostalCode());
    dorder.setReceiveName(dradress.getReceiveName());
    dorder.setStatus(2);
    session.update(dorder);
    tran.commit();
    session.close();

}

//根据id找书
@Override
public DProduct seachdproduct(int dproid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	DProduct dproduct = (DProduct) session.get(DProduct.class, new Integer(dproid));
    session.close();
	return dproduct;
	//return null;
}

//查找订单
@Override
public List<DOrder> seachallorder(int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	Criteria criter = session.createCriteria(DOrder.class);
	DUser duser = (DUser) session.get(DUser.class, new Integer(userid));
	criter.add(Restrictions.eq("DUser",duser));
	List<DOrder> dolist;
	dolist = criter.add(Restrictions.eq("status",2)).list();
	session.close();
	return dolist;
}

//方案二
//订单选择修改 要多次执行
@Override
public void orderselect(int userid, int num ,int dprid) {
	// TODO Auto-generated method stub
	System.out.println("jin qv le ma 111---------");
	Session session = super.getSession();
	Transaction tran = session.beginTransaction();
	DProduct dproduct = (DProduct) session.get(DProduct.class,new Integer(dprid) );
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.eq("DProduct",dproduct));
	Criteria ordercri = criter.createCriteria("DOrder");
	ordercri.add(Restrictions.eq("DUser", duser));
	ordercri.add(Restrictions.eq("status", 0));
	
	System.out.println("jin qv le ma");
	DItem ditem;
	ditem = (DItem) criter.uniqueResult();
	ditem.setProductNum(num);
	ditem.setAmount(ditem.getDangPrice()*num);
	session.save(ditem);
	System.out.println("jin qv le ma 222---------");
	tran.commit();
	System.out.println("jin qv le ma 3333333333");
	session.close();
}


@Override
public List<DItem> seachitemnobuy(int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	//Transaction tran = session.beginTransaction();
	//DProduct dproduct = (DProduct) session.get(DProduct.class,new Integer(dprid) );
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	//Criteria dordercri = session.createCriteria(DOrder.class);
	//dordercri.add(Restrictions.eq("DOrder", dorder));
	//String hql = "select i from DItem i ,DOrder o where i.DOrder= o where ";
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.eq("productNum",0));
	Criteria ordercri = criter.createCriteria("DOrder");
	ordercri.add(Restrictions.eq("DUser", duser));
	ordercri.add(Restrictions.eq("status", 0));
	//criter.add(Restrictions.eq("DOrder", dorder));
	List<DItem> dtlist;
	dtlist =  criter.list();
	session.close();
	return dtlist;
}


@Override
public void updateaddress(int userid,Long time,int addressid,double price) {
	// TODO Auto-generated method stub
	 Session session = super.getSession();
	    Transaction tran = session.beginTransaction();
	    DReceiveAddress dradress = (DReceiveAddress) session.get(DReceiveAddress.class, new Integer(addressid));
	    Criteria criter = session.createCriteria(DOrder.class);
	    DUser duser = (DUser) session.get(DUser.class, new Integer(userid));
	    criter.add(Restrictions.eq("DUser",duser));
		DOrder dorder =(DOrder) criter.add(Restrictions.eq("status",0)).uniqueResult();
	    dorder.setOrderTime(time);
	    //暂时的
	    dorder.setTotalPrice(price);
	    dorder.setFullAddress(dradress.getFullAddress());
	    dorder.setMobile(dradress.getMobile());
	    dorder.setPhone(dradress.getPhone());
	    dorder.setPostalCode(dradress.getPostalCode());
	    dorder.setReceiveName(dradress.getReceiveName());
	   // dorder.setStatus(2);
	    session.update(dorder);
	    tran.commit();
	    session.close();
}


@Override
public List<DItem> seachitemonbuy(int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	//Transaction tran = session.beginTransaction();
	//DProduct dproduct = (DProduct) session.get(DProduct.class,new Integer(dprid) );
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	//Criteria dordercri = session.createCriteria(DOrder.class);
	//dordercri.add(Restrictions.eq("DOrder", dorder));
	//String hql = "select i from DItem i ,DOrder o where i.DOrder= o where ";
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.gt("productNum",0));
	Criteria ordercri = criter.createCriteria("DOrder");
	ordercri.add(Restrictions.eq("DUser", duser));
	ordercri.add(Restrictions.eq("status", 0));
	//criter.add(Restrictions.eq("DOrder", dorder));
	List<DItem> dtlist;
	dtlist =  criter.list();
	session.close();
	return dtlist;

}

//修改status
@Override
public void updatestatus(int status ,int userid ,int newstatus) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	Transaction tran = session.beginTransaction();
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	Criteria criter = session.createCriteria(DOrder.class);
	criter.add(Restrictions.eq("DUser", duser));
	criter.add(Restrictions.eq("status", status));
    DOrder dorder = new DOrder();
    dorder = (DOrder)criter.uniqueResult();
    dorder.setStatus(newstatus);
    session.update(dorder);
    tran.commit();
    session.close();
}


@Override
public List<DItem> seachorderonbuy(int userid) {
	// TODO Auto-generated method stub
	Session session = super.getSession();
	//Transaction tran = session.beginTransaction();
	//DProduct dproduct = (DProduct) session.get(DProduct.class,new Integer(dprid) );
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	//Criteria dordercri = session.createCriteria(DOrder.class);
	//dordercri.add(Restrictions.eq("DOrder", dorder));
	//String hql = "select i from DItem i ,DOrder o where i.DOrder= o where ";
	Criteria criter = session.createCriteria(DItem.class);
	criter.add(Restrictions.gt("productNum",0));
	Criteria ordercri = criter.createCriteria("DOrder");
	ordercri.add(Restrictions.eq("DUser", duser));
	ordercri.add(Restrictions.eq("status", 2));
	//criter.add(Restrictions.eq("DOrder", dorder));
	List<DItem> dtlist;
	dtlist =  criter.list();
	session.close();
	return dtlist;
}
public List<DOrder>	seachorderinbuy(int userid){
	
	Session session = super.getSession();
	DUser duser= (DUser) session.get(DUser.class, new Integer(userid));
	Criteria criter = session.createCriteria(DItem.class);
    criter.add(Restrictions.eq("DUser", duser));
	criter.add(Restrictions.eq("status", 2));
	List<DOrder> drlist;
	drlist = criter.list();
	session.close();
	return drlist;
}
}
