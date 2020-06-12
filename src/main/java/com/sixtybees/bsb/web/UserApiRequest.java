package com.sixtybees.bsb.web;

import javax.xml.bind.annotation.XmlRootElement;

import com.sixtybees.bsb.entity.User;

@XmlRootElement
public class UserApiRequest {

	private Header header;
	private User user;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
