package com.sixtybees.bsb.web;

import com.sixtybees.bsb.entity.Resource;

public class ResourceApiRequest {

	private Header header;
	private Resource resource;
	
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
