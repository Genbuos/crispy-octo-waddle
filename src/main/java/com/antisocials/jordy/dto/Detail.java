package com.antisocials.jordy.dto;



import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Detail {
    private int code;
    private String message;
    private Object data;

    public Detail() {
    }

    public Detail(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Detail( int code, String message) {
        this.message = message;

        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}