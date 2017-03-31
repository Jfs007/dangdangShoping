package action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import service.ShopSever;
import service.UserSever;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entiy.DItem;
import entiy.DOrder;
import entiy.DUser;

public class LoginAction extends ActionSupport implements RequestAware,SessionAware{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	Map<String,Object> request;
	Map<String,Object> session;
	private String validat;
    public String getValidat() {
		return validat;
	}

	public void setValidat(String validat) {
		this.validat = validat;
	}
    private ShopSever shopSever;
    @JSON(serialize=false)
	public ShopSever getShopSever() {
		return shopSever;
	}

	public void setShopSever(ShopSever shopSever) {
		this.shopSever = shopSever;
	}
	private DUser duser;
    private UserSever userSever;
    @JSON(serialize=false)
	public UserSever getUserSever() {
		return userSever;
	}
    
	public void setUserSever(UserSever userSever) {
		this.userSever = userSever;
	}
	public DUser getDuser() {
		return duser;
	}

	public void setDuser(DUser duser) {
		this.duser = duser;
	}
	private String regvalide;
	private int userid;
	

	public String getRegvalide() {
		return regvalide;
	}

	public void setRegvalide(String regvalide) {
		this.regvalide = regvalide;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<DOrder> drlist = new ArrayList<DOrder>();
    public List<DOrder> getDrlist() {
		return drlist;
	}

	public void setDrlist(List<DOrder> drlist) {
		this.drlist = drlist;
	}
	public List<DItem> dtlist = new ArrayList<DItem>();
	public List<DItem> getDtlist() {
		return dtlist;
	}

	public void setDtlist(List<DItem> dtlist) {
		this.dtlist = dtlist;
	}

	//登录
	public String login(){
		session.clear();
		DUser user=userSever.Validate(duser);
		if(user!=null)
		{
		
		session.put("user", user);
		return SUCCESS;
		}
		else{
			
		return ERROR;
		}
	
	}

	
//登出
	public void loginOut(){
		System.out.println("dsd");
		if(session!=null)
		{ 
			session.put("user", null);
//			session.remove("user");
		}
		//return "json";
		
	}
//验证码
	public String validat(){
	    int vali = (int)(Math.random()*9000+1000);
	    System.out.println(vali);
		setValidat(Integer.toString(vali));
		System.out.println(getValidat());
		return "json";
	}
//注册
	public String reg(){
		 userSever.reg(duser);
		//request.put("reguserid", reguserid);
		return SUCCESS;
	}
	
//注册邮箱验证
	public String regvalide(){
		int num = userSever.regValidate(regvalide);
		if(num==0){
			//request.put("reguserid", userid);
			return ERROR;
		}
		else{
			return SUCCESS;
			
		}
	}
//去后台
	public String toBackstage(){
		 duser = (DUser) session.get("user");
		 dtlist = shopSever.seachorderonbuy(userid);
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
