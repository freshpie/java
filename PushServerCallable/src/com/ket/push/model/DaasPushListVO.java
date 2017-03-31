package com.ket.push.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DaasPushListVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class DaasPushListVO {
	
	private String _state_;
	private String Code;
	private String Message;	
	@XmlElementWrapper(name="PUSHLIST")
	@XmlElement(name = "DaasPushVO")
	private List<DaasPushVO> PUSHLIST;
	
	
	public String get_state_() {
		return _state_;
	}
	public void set_state_(String _state_) {
		this._state_ = _state_;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public List<DaasPushVO> getPUSHLIST() {
		return PUSHLIST;
	}
	public void setPUSHLIST(List<DaasPushVO> pUSHLIST) {
		PUSHLIST = pUSHLIST;
	}
	
	
}
