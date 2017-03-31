package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.ShopDao;
import entiy.DCartItem;
import entiy.DItem;
import entiy.DOrder;
import entiy.DProduct;
import entiy.DReceiveAddress;

public class ShopSeverImpl implements ShopSever {
     ShopDao shopDao;
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	//添加地址
	@Override
	public void addAddress(DReceiveAddress drAddress, int id) {
		// TODO Auto-generated method stub
		shopDao.addAddress(drAddress, id);
	}
	//根据id查询所有地址信息
	@Override
	public List<DReceiveAddress> byUser(int id) {
		// TODO Auto-generated method stub
		return shopDao.byUser(id);
	}
	//复杂的购物车判断-------------------X
	@Override
	public int addshop(int userid, int dproid) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	//try-----------------------X
	@Override
	public DItem seachorder(int userid, int dprid) {
		// TODO Auto-generated method stub
		return shopDao.seachorder(userid, dprid);
	}
	//添加order
	@Override
	public void addOrder(int userid,int status,Long time) {
		// TODO Auto-generated method stub
		shopDao.addOrder(userid,status, time);
	}
	//kaishi 购物车添加
	@Override
	public int addShop(int dprid, int status ,int dpnum ,int userid,Long time) {
		// TODO Auto-generated method stub
		 int isExit;
		 isExit = shopDao.seachisExitOrder(userid);	
		 DItem ditem;
		 ditem = shopDao.seachorder(userid, dprid);
		 
		 if(isExit ==0){
			 shopDao.addOrder(userid, status, time);
			 shopDao.addShoporOrder(dprid, status, dpnum,userid);
			 return 3;
		 }
		 else{
		 if(ditem==null){
		 shopDao.addShoporOrder(dprid, status,dpnum,userid);
		 return 1;
		 }
		 else
		 {
		 return 0;
		 }
		 }
	}
	//事实上status不需要写传参 添加订单------------?
	@Override
	public void addopOrder( int status, DCartItem dcartitem) {
		// TODO Auto-generated method stub
		//先添加一个ststus为1的order
		//这只是添加单条购物车，多条方法和addshop差不多，可参考
		shopDao.addOrder(dcartitem.getUserId(), 1, dcartitem.getTime());
		//再添加item
		shopDao.addShoporOrder(dcartitem.getProId(), 1,dcartitem.getNum(),dcartitem.getUserId());
		shopDao.updateorder(dcartitem,0.00);
		//shopDao.addOrder(userid,1,time);
		//shopDao.addShoporOrder(dprid, 1 ,dpnum);
		
	}
	//哈哈哈我也不知道随便写着玩 好了现在成为添加订单----------------------X
	public void addplayoder(List<DCartItem> dtlist){
		int userid = 0;
		//int proid = 0;
		int addressId = 0;
		Long time = (long) 0;
		double totalprice = 0.0;
		for(int i = 0;i<dtlist.size();i++)
		{
		 userid = dtlist.get(i).getUserId();
		// proid = dtlist.get(i).getProId();
		 time = dtlist.get(i).getTime();
		 addressId= dtlist.get(i).getAddressId();
		}
		shopDao.addOrder(userid, 1, time);
		for(int i= 0;i<dtlist.size();i++)
		{
			shopDao.addShoporOrder(dtlist.get(i).getProId(), 1, dtlist.get(0).getNum(),userid);
			DProduct dp = shopDao.seachdproduct(dtlist.get(0).getProId());
			double price = dp.getDangPrice();
			int num= dtlist.get(0).getNum();
			totalprice +=(price*num);
			
		}
	       DCartItem dcartItem = new DCartItem();
	       
	       dcartItem.setAddressId(addressId);
	       dcartItem.setTime(time);
	       shopDao.updateorder(dcartItem, totalprice);
	}
	//查询购物车
	@Override
	public List<DItem> seachshop(int userid) {
		// TODO Auto-generated method stub
		return shopDao.seachshop(userid);
	}
	//移除购物车
	@Override
	public void removeshop(int userid, int dprid) {
		// TODO Auto-generated method stub
		shopDao.removeshop(userid, dprid);
	}
    //修改订单
	@Override
	public void orderend(int userid, int addressid) {
		// TODO Auto-generated method stub
		Date nowtime = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = dateFormat.format(nowtime);		
		Long timelong = Long.parseLong(time);
		//查询买了的
		List<DItem> dtlist=shopDao.seachitemonbuy(userid);
		double totalprice = 0.0;
		for(int i= 0;i<dtlist.size();i++)
		{
			//hopDao.addShoporOrder(dtlist.get(i).getProId(), 1, dtlist.get(0).getNum());
			//DProduct dp = shopDao.seachdproduct(dtlist.get(0).getProId());
			double price = dtlist.get(i).getAmount();
			
			totalprice +=(price);
			
		}
		
		shopDao.updateaddress(userid, timelong, addressid, totalprice);
		//添加一个order status为3的order
		shopDao.addOrder(userid, 3, timelong);
		List<DItem> dtnobuylist=shopDao.seachitemnobuy(userid);
		for(int i= 0;i<dtnobuylist.size();i++){
			int dprid = dtnobuylist.get(i).getDProduct().getId();
			shopDao.addShoporOrder(dprid, 3, 0,userid);
		}
		shopDao.updatestatus(0, userid ,2);
		shopDao.updatestatus(3, userid,0);
		//shopDao.addShoporOrder(dprid, status, 0);
		
	}
	@Override
	public void orderselect(int userid, int num, int dprid) {
		// TODO Auto-generated method stub
		shopDao.orderselect(userid, num, dprid);
	}
	//试一试-------无意义
	@Override
	public List<DItem> seachitemonbuy(int userid) {
		// TODO Auto-generated method stub
		return shopDao.seachitemonbuy(userid);
	}
	@Override
	public double totalprice(int userid) {
		// TODO Auto-generated method stub
		List<DItem> dtlist=shopDao.seachitemonbuy(userid);
		double totalprice = 0.0;
		for(int i= 0;i<dtlist.size();i++)
		{
			//hopDao.addShoporOrder(dtlist.get(i).getProId(), 1, dtlist.get(0).getNum());
			//DProduct dp = shopDao.seachdproduct(dtlist.get(0).getProId());
			double price = dtlist.get(i).getAmount();
			
			totalprice +=(price);
			
		}
		return totalprice;
	}
	@Override
	public void updateaddress(int userid, Long timelong, int addressid,
			double totalprice) {
		// TODO Auto-generated method stub
		 shopDao.updateaddress(userid, timelong, addressid, totalprice);
	}
	@Override
	public List<DItem> seachorderonbuy(int userid) {
		// TODO Auto-generated method stub
		return shopDao.seachorderonbuy(userid);
	}
	@Override
	public List<DOrder> seachorderinbuy(int userid) {
		// TODO Auto-generated method stub
		return shopDao.seachorderinbuy(userid);
	}
}
