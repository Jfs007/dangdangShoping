import javamail.SendEmailUtil;


public class Test {
	public static void main(String[] args) {
		SendEmailUtil send=new SendEmailUtil();
		for(int i=0;i<1;i++){
		send.sendEmail("当当网发来消息", "夜深人静给你发了10封邮件", "987095492@qq.com");
		}
	}
}
