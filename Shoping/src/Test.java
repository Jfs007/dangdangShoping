import javamail.SendEmailUtil;


public class Test {
	public static void main(String[] args) {
		SendEmailUtil send=new SendEmailUtil();
		for(int i=0;i<1;i++){
		send.sendEmail("������������Ϣ", "ҹ���˾����㷢��10���ʼ�", "987095492@qq.com");
		}
	}
}
