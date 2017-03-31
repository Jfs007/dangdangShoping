package dao;

import java.util.List;

import entiy.DCartItem;
import entiy.DItem;
import entiy.DOrder;
import entiy.DProduct;
import entiy.DReceiveAddress;
import entiy.DUser;

public interface ShopDao {
//添加地址信息
public void addAddress(DReceiveAddress drAddress,int id);
public List<DReceiveAddress> byUser(int id);
//添加用户给order
public void addOrder(int userid,int status,Long time);
public void addOrdererror(int addid ,int proid,DOrder dorder);	
//根据书籍查询item是否存在
//(只用于检验的初步，没有可以直接添加，有就查询item的order的stauts的数值来决定如何操作购物车)
public DItem seachitembyDProduct(DProduct dproduct);
//根据Item的id查找order来判定其用户是否与传入的用户id作比较 try Ok
public  DItem seachorder(int userid,int dprid);
//购物车添加 添加item
public void addShoporOrder(int dprid,int status,int dpnum,int userid);
//添加订单 通过更新订单的方式添加
public void addOKOrder(int status, int prnum ,int addressid);
//检验是否可以添加购物车， 根据userid查询（status = 1）
public int seachisExitOrder(int userid);
//购物车查询
public List<DItem> seachshop(int userid);
//购物车移除
public void removeshop(int userid , int dprid); 
//修改订单(不是实际意义得修改，是order的修改)
public void updateorder(DCartItem dcartitem ,double totalprice);
//根据proid找书
public DProduct seachdproduct(int dproid);
//查找订单记录
public List<DOrder> seachallorder(int userid);
// 方案二---------------------------
//新篇章
//修改
public void orderselect(int userid,int num ,int dprid);
//查询所有num为零的item 且在userid = userid status = 0;
public List<DItem> seachitemnobuy(int userid);
//查询所有num为不为零的item 且在userid = userid status = 0;
public List<DItem> seachitemonbuy(int userid);
//修改地址
public void updateaddress(int userid,Long time,int addressid ,double price);
//
public void updatestatus(int status,int userid, int newstatus);
//订单查询
public List<DItem> seachorderonbuy(int userid);
public List<DOrder>	seachorderinbuy(int userid);
}
