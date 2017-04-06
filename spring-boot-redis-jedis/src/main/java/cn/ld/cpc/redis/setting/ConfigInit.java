package cn.ld.cpc.redis.setting;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.ld.cpc.redis.model.sys.RestClient4Solr;

/**
 * Created by guochunhui on 16/4/24.
 */
@Service
public class ConfigInit {
    private static final Logger log = LoggerFactory.getLogger(ConfigInit.class);
    @Value("${cpc.api.solr.restserver.host:localhost}")
    private String restSolrHost;
    @Value("${cpc.api.solr.restserver.port:9997}")
    private String restSolrPort;
    @PostConstruct
    public void dataInit(){
        log.debug("solr.restserver url:" + "http://" + restSolrHost + (restSolrPort.equals("80")?"":(":" + restSolrPort)));
        RestClient4Solr.setRestServer("http://" + restSolrHost + (restSolrPort.equals("80")?"":(":" + restSolrPort)));
       
    }
}
