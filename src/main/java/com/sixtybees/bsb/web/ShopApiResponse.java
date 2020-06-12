package com.sixtybees.bsb.web;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sixtybees.bsb.entity.Shop;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class ShopApiResponse {
	
	private final static String SUCCESS_CODE = "00000";
	private final static String SUCCESS_MESSAGE = "Success!";

	private final static String ERROR_CODE_SHOP_NOT_FOUND = "00001";
	private final static String ERROR_MESSAGE_SHOP_NOT_FOUND = "Incorrect Shop.";
	
	private Header header;
	private ArrayList<Shop> shops;

	public ShopApiResponse() {
	}

	public ShopApiResponse(String code, String message) {
		this.setHeader(new Header(code, message));
	}

	public ShopApiResponse(String code, String message, ArrayList<Shop> shops) {
		this.setHeader(new Header(code, message));
		this.shops = shops;
	}
	
	public ArrayList<Shop> getShops() {
		return shops;
	}

	public void setShops(ArrayList<Shop> shops) {
		this.shops = shops;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public static ShopApiResponse SUCCESS() {
		return new ShopApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE);		
	}

	public static ShopApiResponse SUCCESS(ArrayList<Shop> shops) {
		return new ShopApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE, shops);		
	}
	
	public static ShopApiResponse ERROR_SHOP_NOT_FOUND() {
		return new ShopApiResponse(ERROR_CODE_SHOP_NOT_FOUND, ERROR_MESSAGE_SHOP_NOT_FOUND);
	}
}
