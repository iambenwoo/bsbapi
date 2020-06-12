package com.sixtybees.bsb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@DynamicUpdate
@Table(name = "user")
@XmlRootElement
public class User {

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	@JsonBackReference
//	private Set<ShopUser> shopUsers = new HashSet<ShopUser>();
//	
//	public void setShopUsers(Set<ShopUser> shopUsers) {
//		this.shopUsers = shopUsers;
//	}
//	
//	public void addUser(ShopUser shopUser) {
//		this.shopUsers.add(shopUser);
//	}
//	
//	public Set<ShopUser> getShopUsers() {
//		return shopUsers;
//	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "login_alias")
	private String loginAlias;
	
	@Column(name = "status")
	private String status;

	@Column(name = "name")
	private String name;
	
	private String email;
	
	@Column(name = "login_fail_count")
	private Integer loginFailCount = 0;

	@Column(name = "pwd")
	private String password;

	@Column(name = "salt")
	private String salt;

	@CreationTimestamp
	@Column(name = "create_on", updatable = false)
	private Timestamp createOn;

	@UpdateTimestamp
	@Column(name = "last_upd_on")
	private Timestamp lastUpdateOn;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}

	public Timestamp getLastUpdateOn() {
		return lastUpdateOn;
	}

	public void setLastUpdateOn(Timestamp lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}

	public String getLoginAlias() {
		return loginAlias;
	}

	public void setLoginAlias(String loginAlias) {
		this.loginAlias = loginAlias;
	}

	public Integer getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(Integer loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
