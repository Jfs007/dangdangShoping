 package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import service.ShopSever;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entiy.DCartItem;
import entiy.DItem;
import entiy.DReceiveAddress;
import entiy.DUser;

public class ShopAction extends ActionSupport implements RequestAware,SessionAware{
private ShopSever shopSever;
@JSON(serialize=false)
public ShopSever getShopSever() {
	return shopSever;
}

public void setShopSever(ShopSever shopSever) {
	this.shopSever = shopSever;
}
Map<String,Object> request;
Map<String,Object> session;
List<DItem> itlist = new ArrayList<DItem>();
public List<DItem> getItlist() {
	return itlist;
}
public void setItlist(List<DItem> itlist) {
	this.itlist = itlist;
}
private List<DReceiveAddress> addresslist;


public List<DReceiveAddress> getAddresslist() {
	return addresslist;
}

public void setAddresslist(List<DReceiveAddress> addresslist) {
	this.addresslist = addresslist;
}
private int addressid;

public int getAddressid() {
	return addressid;
}

public void setAddressid(int addressid) {
	this.addressid = addressid;
}
private int num;

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}
private int userid;
public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}
private int dprid;

public int getDprid() {
	return dprid;
}

public void setDprid(int dprid) {
	this.dprid = dprid;
}
public double totalprice;


public double getTotalprice() {
	return totalprice;
}

public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}
private DCartItem dcartItem;

public DCartItem getDcartItem() {
	return dcartItem;
}

public void setDcartItem(DCartItem dcartItem) {
	this.dcartItem = dcartItem;
}

public DReceiveAddress dreceiveadress;


public DReceiveAddress getDreceiveadress() {
	return dreceiveadress;
}

public void setDreceiveadress(DReceiveAddress dreceiveadress) {
	this.dreceiveadress = dreceiveadress;
}

public String toaddress(){
	return SUCCESS;
}
public String address(){
	DUser duserr=(DUser) session.get("user");
	shopSever.addAddress(dreceiveadress, duserr.getId());
	orderop();
	return SUCCESS;
}

public String shoptrans(){
   // DUser duser =(DUser) session.get("user");
	itlist = shopSever.seachshop(userid);
	return "shoptrans";
}
public String shoptransremove(){
	shopSever.removeshop(dcartItem.getUserId(), dcartItem.getProId());
	shoptrans();
	return "remove";


	
}
public String shoptransadd(){
	//product status num userid time
	//Date nowtime =new Date();
	//DUser duserr=(DUser) session.get("user");
	//System.out.println("看一看-ddadadadadad----------你session的值"+duserr.getId());
	Date nowtime = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String time = dateFormat.format(nowtime);
	//shops.addShop(9, 0 ,1,1,time);
	Long timelong = Long.parseLong(time);
	shopSever.addShop(dcartItem.getProId(), 0, 0, dcartItem.getUserId(), timelong);
	return "add";
	
}
public String itemselect(){
	System.out.println("看一看--------"+userid+num+dprid);
	shopSever.orderselect(userid, num, dprid);
	
     totalprice =shopSever.totalprice(userid);
	return  SUCCESS;
}
public String orderop(){
	itlist=shopSever.seachitemonbuy(userid);
	addresslist= shopSever.byUser(userid);
	return SUCCESS;
	
}
public void addressupdate(){
	shopSever.updateaddress(userid, (long)000000000000, addressid, 0.0);
	
}
public String orderOK(){
	
	shopSever.orderend(userid, addressid);
	return SUCCESS;
}

@Override
public void setSession(Map<String, Object> session) {
	// TODO Auto-generated method stub
	this.session = session;
}

@Override
public void setRequest(Map<String, Object> request) {
	// TODO Auto-generated method stub
	this.request = request;
}


}
