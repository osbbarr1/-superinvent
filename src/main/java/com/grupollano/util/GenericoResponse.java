package com.grupollano.util;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericoResponse<T> {

	private T data;
    private String message;
    private Integer code;
    
    /**
     * Contructor 1 : message and data response
     *
     * @param data    Information or main object
     * @param message Message for alerts and toast
     */
    public GenericoResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public GenericoResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
    
    

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
    
    
    
}
