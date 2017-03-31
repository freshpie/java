package com.ket.push.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DaasPushVO {
	
	private int UID;
	private String ID;
	private String MAC;
	private String DEVICE_TYPE;
	private String DEVICE_ID;
	private String TOKEN;
	private String PUSH_MODE;

	private String APPNAME;
	private String CLASS1;
	private String CLASS2;
	private String TITLE;
	private String MESSAGE;

	private String FROMID;
	private int STATUS;
	private String INSERT_DT;
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getDEVICE_TYPE() {
		return DEVICE_TYPE;
	}
	public void setDEVICE_TYPE(String dEVICE_TYPE) {
		DEVICE_TYPE = dEVICE_TYPE;
	}
	public String getDEVICE_ID() {
		return DEVICE_ID;
	}
	public void setDEVICE_ID(String dEVICE_ID) {
		DEVICE_ID = dEVICE_ID;
	}
	public String getTOKEN() {
		return TOKEN;
	}
	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}
	public String getPUSH_MODE() {
		return PUSH_MODE;
	}
	public void setPUSH_MODE(String pUSH_MODE) {
		PUSH_MODE = pUSH_MODE;
	}
	public String getAPPNAME() {
		return APPNAME;
	}
	public void setAPPNAME(String aPPNAME) {
		APPNAME = aPPNAME;
	}
	public String getCLASS1() {
		return CLASS1;
	}
	public void setCLASS1(String cLASS1) {
		CLASS1 = cLASS1;
	}
	public String getCLASS2() {
		return CLASS2;
	}
	public void setCLASS2(String cLASS2) {
		CLASS2 = cLASS2;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getMESSAGE() {
		return MESSAGE;
	}
	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}
	public String getFROMID() {
		return FROMID;
	}
	public void setFROMID(String fROMID) {
		FROMID = fROMID;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public String getINSERT_DT() {
		return INSERT_DT;
	}
	public void setINSERT_DT(String iNSERT_DT) {
		INSERT_DT = iNSERT_DT;
	}
	
	

}
