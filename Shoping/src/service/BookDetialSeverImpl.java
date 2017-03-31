package service;

import java.util.ArrayList;
import java.util.List;

import dao.BookDetialDao;

import entiy.DBook;
import entiy.DCategoryProduct;
import entiy.DProduct;

public class BookDetialSeverImpl implements BookDetialSever {
   private BookDetialDao bookDetialDao;
	public BookDetialDao getBookDetialDao() {
	return bookDetialDao;
}
public void setBookDetialDao(BookDetialDao bookDetialDao) {
	this.bookDetialDao = bookDetialDao;
}
	@Override
	public List<DCategoryProduct> getPrbyCp(int CatId,int PageNum) {
		// TODO Auto-generated method stub
		return bookDetialDao.getPrbyCp(CatId, PageNum);
	}
	//public List<DBook> getDbookbyId(int id) 查询书籍以及详细根据类别
	public List<DProduct> getDpbyid(int id,int PageNum){
		
		List<DCategoryProduct> DPlist = new ArrayList<DCategoryProduct>();
		List<DProduct>  plist = new ArrayList<DProduct>();
	    DPlist= bookDetialDao.getPrbyCp(id,PageNum);
		for(int i=0;i<DPlist.size();i++){
		DProduct dproduct = new DProduct();
		int Dpid =DPlist.get(i).getDProduct().getId();
		dproduct = bookDetialDao.getDproductbyId(Dpid);
		plist.add(dproduct);
		}
		return plist;
	}
	@Override
	public int getPageCountbyid(int id) {
		// TODO Auto-generated method stub
		
	List<DCategoryProduct> list= new ArrayList<DCategoryProduct>();
	list= bookDetialDao.getCPbyCid(id);	
	int PageCount;
    int bookNum = list.size();
    int Stype =bookNum%3;
    if(Stype==0){
    PageCount = bookNum/3;	
    return PageCount;	
    }
    else{
    PageCount =bookNum/3 +1;
    return PageCount;
    }
	}
	@Override
	public List<DProduct> recommend() {
		// TODO Auto-generated method stub
		return bookDetialDao.recommend();
	}
	@Override
	public List<DProduct> newbook() {
		// TODO Auto-generated method stub
		return bookDetialDao.newbook();
	}
	@Override
	public DProduct searchbookbyid(int dprid) {
		// TODO Auto-generated method stub
		return bookDetialDao.getDproductbyId(dprid);
	}
	
}
