package com.sixtybees.bsb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="shop_resource")
@XmlRootElement
public class ShopResource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shop_resource_pk")
	private Integer Id;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shop_id")
	@JsonManagedReference
	private Shop shop;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resource_id")
	@JsonManagedReference
	private Resource resource;

}
