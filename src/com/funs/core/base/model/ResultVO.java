package com.funs.core.base.model;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2013-1-6 Xingling build
 */
public class ResultVO extends BaseVO {
	private boolean result;
	private String message;
	
	public ResultVO(boolean r,String m){
		result=r;
		message=m;
	}
	
	public ResultVO(){
		result = true;
		message = "success";
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
