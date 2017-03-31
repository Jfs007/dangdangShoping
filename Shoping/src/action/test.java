package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CatDao;
import dao.CatDaoImpl;

import entiy.DCartItem;
import entiy.DCategoryProduct;
import entiy.DItem;
import entiy.DProduct;
import entiy.DReceiveAddress;
import entiy.DUser;

import service.BookDetialSever;
import service.CatSever;
import service.ShopSever;
import service.UserSever;

//import Biz.TopicBiz;
import entiy.DCategory;
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap=new ClassPathXmlApplicationContext("applicationContext.xml");
		//AdminBiz adminBiz=(AdminBiz)ap.getBean("adminBiz");
		
		//DUser dUser = new DUser();
		//dUser.setEmail("d");
		//dUser.setPassword("dd");
		BookDetialSever catsever=(BookDetialSever)ap.getBean("bookDetialSever");
		//int num=usersever.Validate(dUser);
		//System.out.println(num);
		ShopSever shops=(ShopSever)ap.getBean("shopSever");
		//List<DReceiveAddress> Clist = new ArrayList<DReceiveAddress>();
	   // Clist = catsever.getDpbyid(3);
		//Clist = shops.byUser(1);
	DItem ditem = shops.seachorder(1, 0);
	//shops.addOrder(1);
	//shops.orderselect(1, 0, 13);
	List<DItem> dtlist = new ArrayList<DItem>();
	dtlist = shops.seachorderonbuy(1);
	for(int i= 0;i<dtlist.size();i++){
	int	dprid = dtlist.get(i).getDProduct().getId();
	int num = dtlist.get(i).getProductNum();
	    
		System.out.println(dprid+"数量为"+num);
		
	}
	//shops.orderend(1, 2);
	//int dprid,int status,int dpnum,int userid,int time
	//
	//shops.removeshop(1, 6);
	Date nowtime = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String time = dateFormat.format(nowtime);
	
	Long timelong = Long.parseLong(time);
	
	
//	if(ditem != null){
//	String en =ditem.getDOrder().getDUser().getNickname();
//	
//	System.out.println(en);}
//	else{
//		System.out.println("没有这个");
//		
//	}
//	List<DItem> ditems = shops.seachshop(1);
//	for(int i=0;i<ditems.size();i++){
//		String a= ditems.get(i).getProductName();
//		String ab=ditems.get(i).getDProduct().getDescription();
//		System.out.println(a+ab);
//	}
		//System.out.println(pagecount);
	   /// System.out.println(Clist);
	    //for(int i=0;i<Blist.size();i++){
	   //String en= Blist.get(i).getDOrder().getDUser().getNickname();
	  // String em= Clist.get(i).getReceiveName();	
		//DReceiveAddress drAddress= new DReceiveAddress();
		//drAddress.setReceiveName("马大吉");
		//drAddress.setFullAddress("杭州");
		//drAddress.setPostalCode("312000");
		//shops.addAddress(drAddress, 1);
	    	
	   // }
		
		
	}

}
