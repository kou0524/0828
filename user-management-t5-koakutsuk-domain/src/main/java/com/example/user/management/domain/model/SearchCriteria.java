package com.example.user.management.domain.model;
import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SearchCriteria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int page = 0;
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public void clear() {
		page = 0;
	}
}
