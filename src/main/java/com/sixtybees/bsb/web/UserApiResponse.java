package com.sixtybees.bsb.web;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sixtybees.bsb.entity.User;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class UserApiResponse {

	private final static String SUCCESS_CODE = "00000";
	private final static String SUCCESS_MESSAGE = "Success!";

	private final static String ERROR_CODE_USER_NOT_FOUND = "00001";
	private final static String ERROR_MESSAGE_USER_NOT_FOUND = "Incorrect User.";
	
	private Header header;
	private ArrayList<User> users;

	public UserApiResponse() {
	}

	public UserApiResponse(String code, String message) {
		this.setHeader(new Header(code, message));
	}

	public UserApiResponse(String code, String message, ArrayList<User> users) {
		this.setHeader(new Header(code, message));
		this.users = users;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public static UserApiResponse SUCCESS() {
		return new UserApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE);		
	}

	public static UserApiResponse SUCCESS(ArrayList<User> users) {
		return new UserApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE, users);		
	}
	
	public static UserApiResponse ERROR_USER_NOT_FOUND() {
		return new UserApiResponse(ERROR_CODE_USER_NOT_FOUND, ERROR_MESSAGE_USER_NOT_FOUND);
	}
	
}
