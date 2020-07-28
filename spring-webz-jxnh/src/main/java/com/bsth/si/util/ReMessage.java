package com.bsth.si.util;

public class ReMessage {
	public boolean isError = false;
	public String message;

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		if(null!=message){
			return message;
		}else{
			return (isError?"操作失败！请联系管理员。":"操作成功！");
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
