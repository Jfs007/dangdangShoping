package dao;

import java.util.List;

import entiy.DCartItem;
import entiy.DItem;
import entiy.DOrder;
import entiy.DProduct;
import entiy.DReceiveAddress;
import entiy.DUser;

public interface ShopDao {
//��ӵ�ַ��Ϣ
public void addAddress(DReceiveAddress drAddress,int id);
public List<DReceiveAddress> byUser(int id);
//����û���order
public void addOrder(int userid,int status,Long time);
public void addOrdererror(int addid ,int proid,DOrder dorder);	
//�����鼮��ѯitem�Ƿ����
//(ֻ���ڼ���ĳ�����û�п���ֱ����ӣ��оͲ�ѯitem��order��stauts����ֵ��������β������ﳵ)
public DItem seachitembyDProduct(DProduct dproduct);
//����Item��id����order���ж����û��Ƿ��봫����û�id���Ƚ� try Ok
public  DItem seachorder(int userid,int dprid);
//���ﳵ��� ���item
public void addShoporOrder(int dprid,int status,int dpnum,int userid);
//��Ӷ��� ͨ�����¶����ķ�ʽ���
public void addOKOrder(int status, int prnum ,int addressid);
//�����Ƿ������ӹ��ﳵ�� ����userid��ѯ��status = 1��
public int seachisExitOrder(int userid);
//���ﳵ��ѯ
public List<DItem> seachshop(int userid);
//���ﳵ�Ƴ�
public void removeshop(int userid , int dprid); 
//�޸Ķ���(����ʵ��������޸ģ���order���޸�)
public void updateorder(DCartItem dcartitem ,double totalprice);
//����proid����
public DProduct seachdproduct(int dproid);
//���Ҷ�����¼
public List<DOrder> seachallorder(int userid);
// ������---------------------------
//��ƪ��
//�޸�
public void orderselect(int userid,int num ,int dprid);
//��ѯ����numΪ���item ����userid = userid status = 0;
public List<DItem> seachitemnobuy(int userid);
//��ѯ����numΪ��Ϊ���item ����userid = userid status = 0;
public List<DItem> seachitemonbuy(int userid);
//�޸ĵ�ַ
public void updateaddress(int userid,Long time,int addressid ,double price);
//
public void updatestatus(int status,int userid, int newstatus);
//������ѯ
public List<DItem> seachorderonbuy(int userid);
public List<DOrder>	seachorderinbuy(int userid);
}
