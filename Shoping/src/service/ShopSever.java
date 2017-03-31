package service;

import java.util.List;

import entiy.DCartItem;
import entiy.DItem;
import entiy.DOrder;
import entiy.DProduct;
import entiy.DReceiveAddress;

public interface ShopSever {
//添加地址
public void addAddress(DReceiveAddress drAddress, int id);
//根据id找地址
public List<DReceiveAddress> byUser(int id) ;
//购物车添加处理 meizuo---------------
public int addshop(int userid,int dproid);
//try
public  DItem seachorder(int userid,int dprid);
//添加order
public void addOrder(int userid ,int status ,Long time);
public int addShop(int dprid,int status,int dpnum,int userid,Long time);
//添加订单
public void addopOrder(int status , DCartItem dcartItem);
//购物车查询
public List<DItem> seachshop(int userid);
//购物车移除
public void removeshop(int userid, int dprid);
//寻找书籍根据id
//public DProduct seachdproduct(int dproid);
//闹着玩 现在不是了--------
public void addplayoder(List<DCartItem> dtlist);
//新篇章
//更新status = 0的order下的item;
public void orderselect(int userid, int num ,int dprid) ;
//下单
public void orderend(int userid ,int addressid);
//试一试 -------无意义   有了
public List<DItem> seachitemonbuy(int userid);
//查询总价
public double totalprice(int userid);
//
public void updateaddress(int userid, Long timelong, int addressid, double totalprice);
//订单查询
public List<DItem> seachorderonbuy(int userid);
public List<DOrder>	seachorderinbuy(int userid);
}
