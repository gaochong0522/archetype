package com.gcgame.oa.model;

import java.io.Serializable;


public class StuUser extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ID ;
	private String LOGINNAME ;
	private String LOGINPASSWORD ;
	private String NAME ;
	private Long AGE ;
	private String PHONE ;
	private Long SCHOOLID ;
	private String SCHOOL ;
	private Long CLASSID ;
	private String CLASS ;
	private String ADDRESS ;
	private String DELETED ;


	public Long getID() {
			return this.ID;
	}
	public void setID(Long ID) {
			this.ID = ID;
	}
	public String getLOGINNAME() {
			return this.LOGINNAME;
	}
	public void setLOGINNAME(String LOGINNAME) {
			this.LOGINNAME = LOGINNAME;
	}
	public String getLOGINPASSWORD() {
			return this.LOGINPASSWORD;
	}
	public void setLOGINPASSWORD(String LOGINPASSWORD) {
			this.LOGINPASSWORD = LOGINPASSWORD;
	}
	public String getNAME() {
			return this.NAME;
	}
	public void setNAME(String NAME) {
			this.NAME = NAME;
	}
	public Long getAGE() {
			return this.AGE;
	}
	public void setAGE(Long AGE) {
			this.AGE = AGE;
	}
	public String getPHONE() {
			return this.PHONE;
	}
	public void setPHONE(String PHONE) {
			this.PHONE = PHONE;
	}
	public Long getSCHOOLID() {
			return this.SCHOOLID;
	}
	public void setSCHOOLID(Long SCHOOLID) {
			this.SCHOOLID = SCHOOLID;
	}
	public String getSCHOOL() {
			return this.SCHOOL;
	}
	public void setSCHOOL(String SCHOOL) {
			this.SCHOOL = SCHOOL;
	}
	public Long getCLASSID() {
			return this.CLASSID;
	}
	public void setCLASSID(Long CLASSID) {
			this.CLASSID = CLASSID;
	}
	public String getCLASS() {
			return this.CLASS;
	}
	public void setCLASS(String CLASS) {
			this.CLASS = CLASS;
	}
	public String getADDRESS() {
			return this.ADDRESS;
	}
	public void setADDRESS(String ADDRESS) {
			this.ADDRESS = ADDRESS;
	}
	public String getDELETED() {
			return this.DELETED;
	}
	public void setDELETED(String DELETED) {
			this.DELETED = DELETED;
	}
}