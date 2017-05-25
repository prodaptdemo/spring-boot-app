package com.prodapt.app.model;

import java.util.List;

public class AppResponse {

	private String responseMessage;
	
	private String responseCode;

	private List<AppModel> lstresult;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<AppModel> getLstresult() {
		return lstresult;
	}

	public void setLstresult(List<AppModel> lstresult) {
		this.lstresult = lstresult;
	}
	
	
	

	
	
}
