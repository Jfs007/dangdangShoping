package action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import service.CatSever;

import com.opensymphony.xwork2.ActionSupport;

import entiy.DCategory;

public class CatAction extends ActionSupport {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private CatSever catSever;
private List<DCategory> Plist;
public List<DCategory> getPlist() {
	return Plist;
}

public void setPlist(List<DCategory> plist) {
	Plist = plist;
}

private List<DCategory> Clist;
public List<DCategory> getClist() {
	return Clist;
}

public void setClist(List<DCategory> clist) {
	Clist = clist;
}
@JSON(serialize=false)
public CatSever getCatSever() {
	return catSever;
}

public void setCatSever(CatSever catSever) {
	this.catSever = catSever;
}

public String catLoad(){
	
	Plist = catSever.getcatPrbyId();
	Clist = catSever.getcatChbyId();
	return SUCCESS;
	
}
}
