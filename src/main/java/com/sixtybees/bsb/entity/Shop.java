package com.sixtybees.bsb.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@XmlRootElement
public class Shop {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	@JsonBackReference
	private Set<ShopUser> shopUsers = new HashSet<ShopUser>();

	public void setShopUsers(Set<ShopUser> shopUsers) {
		this.shopUsers = shopUsers;
	}
	
	public void addShopUser(ShopUser shopUser) {
		this.shopUsers.add(shopUser);
	}

	public Set<ShopUser> getShopUsers() {
		return shopUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	@JsonBackReference
	private Set<ShopResource> shopResources = new HashSet<ShopResource>();

	public void setShopResources(Set<ShopResource> shopResources) {
		this.shopResources = shopResources;
	}
	
	public void addResource(ShopResource shopResource) {
		this.shopResources.add(shopResource);
	}

	public Set<ShopResource> getShopResources() {
		return shopResources;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_id")
	private Integer shopId;

	@Column(name = "status")
	private String status;

	@Column(name = "name")
	private String name;

	@Column(name = "details")
	private String details;

	@ManyToOne
	@JoinColumn(name = "create_by", referencedColumnName = "user_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
	@JsonIdentityReference(alwaysAsId = true)
	private User createBy;

	@CreationTimestamp
	@Column(name = "create_on")
	private Timestamp createOn;
	
	@ManyToOne
	@JoinColumn(name = "last_upd_by", referencedColumnName = "user_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
	@JsonIdentityReference(alwaysAsId = true)
	private User lastUpdateBy;

	@UpdateTimestamp
	@Column(name = "last_upd_on")
	private Timestamp lastUpdateOn;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}

	public User getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(User lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Timestamp getLastUpdateOn() {
		return lastUpdateOn;
	}

	public void setLastUpdateOn(Timestamp lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}

}
