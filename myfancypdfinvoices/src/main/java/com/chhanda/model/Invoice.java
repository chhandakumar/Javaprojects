package com.chhanda.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
	
	public Invoice() {
		
	}

	public Invoice( String userId, Integer amount,String pdfUrl) {
		super();
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.pdfUrl = pdfUrl;
		this.amount = amount;
	}

	private String id;
	
	@JsonProperty("user_id")	
	private String userId;
	
	@JsonProperty("pdf_url")
	private String pdfUrl;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the pdfUrl
	 */
	public String getPdfUrl() {
		return pdfUrl;
	}

	/**
	 * @param pdfUrl the pdfUrl to set
	 */
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	private Integer amount;
	
	
	
	
}
