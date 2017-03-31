package entiy;

import java.util.HashSet;
import java.util.Set;

/**
 * DOrder entity. @author MyEclipse Persistence Tools
 */

public class DOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private DUser DUser;
	private Integer status;
	private Long orderTime;
	private String orderDesc;
	private Double totalPrice;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;
	private Set<DItem> DItems = new HashSet<DItem>(0);

	// Constructors

	/** default constructor */
	public DOrder() {
	}

	/** minimal constructor */
	public DOrder(DUser DUser, Integer status, Long orderTime, Double totalPrice) {
		this.DUser = DUser;
		this.status = status;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
	}

	/** full constructor */
	public DOrder(DUser DUser, Integer status, Long orderTime,
			String orderDesc, Double totalPrice, String receiveName,
			String fullAddress, String postalCode, String mobile, String phone,
			Set DItems) {
		this.DUser = DUser;
		this.status = status;
		this.orderTime = orderTime;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
		this.DItems = DItems;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DUser getDUser() {
		return this.DUser;
	}

	public void setDUser(DUser DUser) {
		this.DUser = DUser;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderDesc() {
		return this.orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getReceiveName() {
		return this.receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return this.fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getDItems() {
		return this.DItems;
	}

	public void setDItems(Set DItems) {
		this.DItems = DItems;
	}

}