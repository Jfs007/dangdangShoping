package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.BookDetialSever;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entiy.DProduct;

public class BookDetialAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private BookDetialSever bookDetialSever;
	
	 @JSON(serialize=false)
	public BookDetialSever getBookDetialSever() {
		return bookDetialSever;
	}


	public void setBookDetialSever(BookDetialSever bookDetialSever) {
		this.bookDetialSever = bookDetialSever;
	}
	List<DProduct> newplist = new ArrayList<DProduct>();
	public List<DProduct> getNewplist() {
		return newplist;
	}


	public void setNewplist(List<DProduct> newplist) {
		this.newplist = newplist;
	}
	List<DProduct> plist = new ArrayList<DProduct>();
    public List<DProduct> getPlist() {
		return plist;
	}


	public void setPlist(List<DProduct> plist) {
		this.plist = plist;
	}
	private int pagenum =1;
	private int pagecount;
	
	public int getPagenum() {
		return pagenum;
	}


	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}


	public int getPagecount() {
		return pagecount;
	}


	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getOp() {
		return op;
	}


	public void setOp(int op) {
		this.op = op;
	}
	private int id;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	private int op;
	private DProduct dproduct;
public DProduct getDproduct() {
		return dproduct;
	}


	public void setDproduct(DProduct dproduct) {
		this.dproduct = dproduct;
	}


	//书籍详情
	public String bookDetial(){
		
		plist = bookDetialSever.getDpbyid(id,pagenum);
		//ActionContext ct=ActionContext.getContext();
		//ct.put("Prolist", plist);
		pagecount =bookDetialSever.getPageCountbyid(id);
		System.out.println(pagecount+"--------");
		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("id", id);
		request.put("pageCount", pagecount);
		request.put("Prolist", plist);
		request.put("pageNum", pagenum);
		request.put("op", op);
		if(plist==null){
			request.remove("Prolist");
			request.clear();
		}
		return "json";		
	}
//主编推荐
	public String recommend(){
		plist = bookDetialSever.recommend();
		
		return "recommend";
		
	}
//新书
    public String newbook(){
    	newplist = bookDetialSever.newbook();
    	return "book";
    }
//书详细
    public String  bookone(){
    	dproduct = bookDetialSever.searchbookbyid(id);
    	Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
    	request.put("dproduct", dproduct);
    	return "bookone";
    }
}
