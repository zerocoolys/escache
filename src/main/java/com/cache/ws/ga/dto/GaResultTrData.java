package com.cache.ws.ga.dto;

import java.util.List;

public class GaResultTrData {

	private String code;

	private String userNumber;

	private String title;

	private String data;

	private List<GaResultTdData> gaResultTdDatas;

	private String Message;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public List<GaResultTdData> getGaResultTdDatas() {
		return gaResultTdDatas;
	}

	public void setGaResultTdDatas(List<GaResultTdData> gaResultTdDatas) {
		this.gaResultTdDatas = gaResultTdDatas;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

}
