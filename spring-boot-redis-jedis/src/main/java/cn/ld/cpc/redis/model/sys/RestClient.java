package cn.ld.cpc.redis.model.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;


/**
 * Created by guochunhui on 16/4/21.
 */
@Component
public class RestClient  {
    //@Qualifier("org.springframework.web.client.RestTemplate")
    private static final Logger log = LoggerFactory.getLogger(RestClient.class);

    private static String restServer;
//    @Bean
//    private RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//    @Autowired
    private RestTemplate restTemplate=new RestTemplate();



    @SuppressWarnings("unchecked")
	public <T> ResultHandle<T> getObject(String subPath,
                                      Object...uriVariables)
    {
        ResultHandle<T> resultHandle;
        log.debug("restserver:" + this.getRestServer());
        log.debug("restTemplate:" + this.restTemplate == null ? "null" : "not null");
        log.debug("subpath:" +subPath);

        try {

            resultHandle= restTemplate.getForObject(this.getRestServer() + subPath, ResultHandleImpl.class, uriVariables);
            System.out.println(this.getRestServer() + subPath);
            resultHandle.setHttpStatus(HttpStatus.OK);
        }
        catch (Exception err)
        {
            //处理异常
            resultHandle = new ResultHandleImpl<T>();
            resultHandle.setResponseBody(null);
            resultHandle.setMsgCode(ResultHandle.RESULTSTATUS.FAILED);
            resultHandle.setMsgText("操作失败!"+err.toString());
            resultHandle.setHttpStatus(HttpStatus.BAD_REQUEST);
        }
        return resultHandle;
    }
    
    public <T> ResultHandle<T> postObject(String subPath,
                                          T model,
                                          Object... uriVariables) {

        HttpEntity<T> httpEntity=new HttpEntity<>(model);

        return  this.submitObject(subPath,httpEntity,uriVariables);
    }
    @SuppressWarnings("unchecked")
	private <T> ResultHandle<T> submitObject(String subPath,
                            Object request,
                            Object... uriVariables)
    {

        ResultHandle<T> resultHandle;
        try {
            resultHandle=restTemplate.postForObject(this.getRestServer() + subPath, request, ResultHandleImpl.class, uriVariables);
            resultHandle.setHttpStatus(HttpStatus.OK);

        }catch (Exception err)
        {
            //处理异常
            resultHandle=new ResultHandleImpl<T>();
            resultHandle.setResponseBody(null);
            resultHandle.setMsgCode(ResultHandle.RESULTSTATUS.FAILED);
            resultHandle.setMsgText("操作失败!"+err.toString());
            resultHandle.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return resultHandle;
    }



    @SuppressWarnings("unchecked")
	public ResultHandle<String>  delete(String subPath,
                        Object...uriVariables)
    {
        ResultHandle<String> resultHandle;
        try {
            resultHandle=restTemplate.postForObject(this.getRestServer() + subPath, null, ResultHandleImpl.class, uriVariables);
            resultHandle.setHttpStatus(HttpStatus.OK);

        }catch (Exception err)
        {
            //处理异常
            resultHandle=new ResultHandleImpl<String>();
            resultHandle.setResponseBody(null);
            resultHandle.setMsgCode(ResultHandle.RESULTSTATUS.FAILED);
            resultHandle.setMsgText("操作失败!"+err.toString());
            resultHandle.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return resultHandle;

    }



    public String getRestServer() {
        System.out.println("restServer:" + restServer);
        return restServer;
    }

    public static void setRestServer(String rstServer) {
        restServer = rstServer;
    }

}
