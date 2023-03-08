package com.rest.example.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2167350124483880654L;
	private Long userId;
	private Long id;
	private String title;
	private String body;
	
	public PostModel() {
		
	}
	public PostModel(Long userId, String title, String body) {
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
