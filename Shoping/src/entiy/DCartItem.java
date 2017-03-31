package entiy;

public class DCartItem {
private int UserId;
private int ProId;
private int addressId;
private int num;
private Long time;
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public int getProId() {
	return ProId;
}
public void setProId(int proId) {
	ProId = proId;
}
public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public Long getTime() {
	return time;
}
public void setTime(Long time) {
	this.time = time;
}

}
