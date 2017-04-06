package cn.ld.cpc.solr.model.sys;

import org.springframework.http.HttpStatus;

/**
 * Created by guochunhui on 16/4/23.
 */
public interface ResultHandle<T>  {
    public enum RESULTSTATUS
    {
        SUCCESSED,FAILED
    }

    public RESULTSTATUS getMsgCode() ;

    public void setMsgCode(RESULTSTATUS msgCode);
    public String getMsgText();

    public void setMsgText(String msgText);

    public T getResponseBody();

    public void setResponseBody(T responseBody);

    public HttpStatus getHttpStatus();

    public void setHttpStatus(HttpStatus httpStatus);
}
