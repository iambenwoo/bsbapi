package com.sixtybees.bsb.web;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sixtybees.bsb.entity.Resource;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class ResourceApiResponse {

	private final static String SUCCESS_CODE = "00000";
	private final static String SUCCESS_MESSAGE = "Success!";

	private final static String ERROR_CODE_RESOURCE_NOT_FOUND = "00001";
	private final static String ERROR_MESSAGE_RESOURCE_NOT_FOUND = "Incorrect Shop.";

	private Header header;
	private ArrayList<Resource> resources;

	public ResourceApiResponse() {
	}

	public ResourceApiResponse(String code, String message) {
		this.setHeader(new Header(code, message));
	}

	public ResourceApiResponse(String code, String message, ArrayList<Resource> resources) {
		this.setHeader(new Header(code, message));
		this.resources = resources;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public void setShops(ArrayList<Resource> resources) {
		this.resources = resources;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public static ResourceApiResponse SUCCESS() {
		return new ResourceApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE);
	}

	public static ResourceApiResponse SUCCESS(ArrayList<Resource> resources) {
		return new ResourceApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE, resources);
	}

	public static ResourceApiResponse ERROR_RESOURCE_NOT_FOUND() {
		return new ResourceApiResponse(ERROR_CODE_RESOURCE_NOT_FOUND, ERROR_MESSAGE_RESOURCE_NOT_FOUND);
	}

}
