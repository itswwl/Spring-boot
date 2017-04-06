package cn.ld.cpc.solr.model.sys;

import org.springframework.http.HttpStatus;

/**
 * Created by guochunhui on 16/4/23.
 */
public class ResultHandleImpl <T> implements ResultHandle<T>{
    public RESULTSTATUS getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(RESULTSTATUS msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private HttpStatus httpStatus;
    private RESULTSTATUS msgCode;
    private String msgText;
    private T responseBody;


}
