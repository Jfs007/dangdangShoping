package service;

import java.util.List;

import entiy.DCategoryProduct;
import entiy.DProduct;

public interface BookDetialSever {
	//查询 书 根据类别
	public List<DCategoryProduct> getPrbyCp(int CatId,int pageNum);
	//查询书并且得到详细信息
	public List<DProduct> getDpbyid(int id,int PageNum);
	//查找根据书类id来查有多少本书并返回可以加载几页
	public int getPageCountbyid(int id);
	//主编推荐
	public List<DProduct> recommend();
	//新书
	public List<DProduct> newbook();
	//根据id找书
	public DProduct searchbookbyid(int dprid);
}
