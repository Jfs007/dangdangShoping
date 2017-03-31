package dao;

import java.util.List;

import entiy.DBook;
import entiy.DCategory;
import entiy.DCategoryProduct;
import entiy.DProduct;

public interface BookDetialDao {
//废弃的方法
public List<DCategory> getCPbyId();
//根据书类的id查找书籍以及其详细信息
public List<DCategoryProduct> getPrbyCp(int CatId,int PageNum);
public DProduct getDproductbyId(int id);
//根据书类找到dp的数量，为分页做准备
public List<DCategoryProduct> getCPbyCid(int CatId);
//查找根据书类id来查有多少本书并返回可以加载几页，该方法已废弃
public int getPageCountbyid(int id);
//主编推荐
public List<DProduct> recommend();
//最新上架
public List<DProduct> newbook();
}
