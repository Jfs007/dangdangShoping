package service;

import java.util.List;

import entiy.DCategoryProduct;
import entiy.DProduct;

public interface BookDetialSever {
	//��ѯ �� �������
	public List<DCategoryProduct> getPrbyCp(int CatId,int pageNum);
	//��ѯ�鲢�ҵõ���ϸ��Ϣ
	public List<DProduct> getDpbyid(int id,int PageNum);
	//���Ҹ�������id�����ж��ٱ��鲢���ؿ��Լ��ؼ�ҳ
	public int getPageCountbyid(int id);
	//�����Ƽ�
	public List<DProduct> recommend();
	//����
	public List<DProduct> newbook();
	//����id����
	public DProduct searchbookbyid(int dprid);
}
