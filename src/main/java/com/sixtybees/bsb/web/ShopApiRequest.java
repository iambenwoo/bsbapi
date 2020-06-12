package com.sixtybees.bsb.web;

import javax.xml.bind.annotation.XmlRootElement;

import com.sixtybees.bsb.entity.Shop;

@XmlRootElement
public class ShopApiRequest {

	private Header header;
	private Shop shop;
		
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Shop getShop() {
		return this.shop;
	}
}
