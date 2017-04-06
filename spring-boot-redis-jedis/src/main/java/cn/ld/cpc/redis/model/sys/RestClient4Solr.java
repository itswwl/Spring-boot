package cn.ld.cpc.redis.model.sys;

/**
 * Created by Administrator on 2016/7/13.
 */
public class RestClient4Solr extends RestClient {
//    private static final Logger log = LoggerFactory.getLogger(RestClient4Solr.class);

    private  static String restSolrServer;

    public String getRestServer() {
        return restSolrServer;
    }

    public static void  setRestServer(String rstServer) {
        restSolrServer = rstServer;
    }

}
