package entiy;

import java.util.HashSet;
import java.util.Set;

/**
 * DUser entity. @author MyEclipse Persistence Tools
 */

public class DUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private Integer userIntegral;
	private String isEmailVerify;
	private String emailVerifyCode;
	private Long lastLoginTime;
	private String lastLoginIp;
	private Set DReceiveAddresses = new HashSet(0);
	private Set DOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public DUser() {
	}

	public DUser(Integer id, String email, String nickname, String password,
			Integer userIntegral, String isEmailVerify, String emailVerifyCode,
			Long lastLoginTime, String lastLoginIp, Set dReceiveAddresses,
			Set dOrders) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		DReceiveAddresses = dReceiveAddresses;
		DOrders = dOrders;
	}

	/** minimal constructor */
	public DUser(String email, String password, Integer userIntegral) {
		this.email = email;
		this.password = password;
		this.userIntegral = userIntegral;
	}

	/** full constructor */
	public DUser(String email, String nickname, String password,
			Integer userIntegral, String isEmailVerify, String emailVerifyCode,
			Long lastLoginTime, String lastLoginIp, Set DReceiveAddresses,
			Set DOrders) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.DReceiveAddresses = DReceiveAddresses;
		this.DOrders = DOrders;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserIntegral() {
		return this.userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public String getIsEmailVerify() {
		return this.isEmailVerify;
	}

	public void setIsEmailVerify(String isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	public String getEmailVerifyCode() {
		return this.emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public Long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Set getDReceiveAddresses() {
		return this.DReceiveAddresses;
	}

	public void setDReceiveAddresses(Set DReceiveAddresses) {
		this.DReceiveAddresses = DReceiveAddresses;
	}

	public Set getDOrders() {
		return this.DOrders;
	}

	public void setDOrders(Set DOrders) {
		this.DOrders = DOrders;
	}

}