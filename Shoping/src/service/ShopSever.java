package service;

import java.util.List;

import entiy.DCartItem;
import entiy.DItem;
import entiy.DOrder;
import entiy.DProduct;
import entiy.DReceiveAddress;

public interface ShopSever {
//��ӵ�ַ
public void addAddress(DReceiveAddress drAddress, int id);
//����id�ҵ�ַ
public List<DReceiveAddress> byUser(int id) ;
//���ﳵ��Ӵ��� meizuo---------------
public int addshop(int userid,int dproid);
//try
public  DItem seachorder(int userid,int dprid);
//���order
public void addOrder(int userid ,int status ,Long time);
public int addShop(int dprid,int status,int dpnum,int userid,Long time);
//��Ӷ���
public void addopOrder(int status , DCartItem dcartItem);
//���ﳵ��ѯ
public List<DItem> seachshop(int userid);
//���ﳵ�Ƴ�
public void removeshop(int userid, int dprid);
//Ѱ���鼮����id
//public DProduct seachdproduct(int dproid);
//������ ���ڲ�����--------
public void addplayoder(List<DCartItem> dtlist);
//��ƪ��
//����status = 0��order�µ�item;
public void orderselect(int userid, int num ,int dprid) ;
//�µ�
public void orderend(int userid ,int addressid);
//��һ�� -------������   ����
public List<DItem> seachitemonbuy(int userid);
//��ѯ�ܼ�
public double totalprice(int userid);
//
public void updateaddress(int userid, Long timelong, int addressid, double totalprice);
//������ѯ
public List<DItem> seachorderonbuy(int userid);
public List<DOrder>	seachorderinbuy(int userid);
}
