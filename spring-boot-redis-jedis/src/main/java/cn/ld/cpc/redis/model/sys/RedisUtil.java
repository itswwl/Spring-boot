package cn.ld.cpc.redis.model.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	
	@Autowired
	private RedisClient redisClient;
	
	public boolean exits(String key){
		return true;
	}

}
