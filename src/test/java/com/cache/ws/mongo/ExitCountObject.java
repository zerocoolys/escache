package com.cache.ws.mongo;

public class ExitCountObject {

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** 用户访问ID */
	private String tt;
	/** 当前访问路径 */
	private String loc;
	/** 来源路径 */
	private String rf;
	/** 来源类型 */
	private String rfType;
	/** 搜素引擎名字 */
	private String se;
	/** 新老访客 */
	private String isNew;

	public ExitCountObject() {
		super();

	}

	public ExitCountObject(String type, String tt, String loc, String rf,
			String rfType, String se, String isNew) {
		super();
		this.type = type;
		this.tt = tt;
		this.loc = loc;
		this.rf = rf;
		this.rfType = rfType;
		this.se = se;
		this.isNew = isNew;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getRf() {
		return rf;
	}

	public void setRf(String rf) {
		this.rf = rf;
	}

	public String getRfType() {
		return rfType;
	}

	public void setRfType(String rfType) {
		this.rfType = rfType;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

}
