package dao;

import java.util.List;

import entiy.DBook;
import entiy.DCategory;
import entiy.DCategoryProduct;
import entiy.DProduct;

public interface BookDetialDao {
//�����ķ���
public List<DCategory> getCPbyId();
//���������id�����鼮�Լ�����ϸ��Ϣ
public List<DCategoryProduct> getPrbyCp(int CatId,int PageNum);
public DProduct getDproductbyId(int id);
//���������ҵ�dp��������Ϊ��ҳ��׼��
public List<DCategoryProduct> getCPbyCid(int CatId);
//���Ҹ�������id�����ж��ٱ��鲢���ؿ��Լ��ؼ�ҳ���÷����ѷ���
public int getPageCountbyid(int id);
//�����Ƽ�
public List<DProduct> recommend();
//�����ϼ�
public List<DProduct> newbook();
}
