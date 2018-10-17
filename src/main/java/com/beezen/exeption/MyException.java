package com.beezen.exeption;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[] paras;
	
	public MyException(){
		super();
	}
	
	public MyException(Exception e){
		super(e);
	}
	
	public MyException(String message){
		super(message);
	}
	
	public MyException(String message,Object ... paras){
		super(message);
	}

	public Object[] getParas() {
		return paras;
	}

	public void setParas(Object[] paras) {
		this.paras = paras;
	}
}
