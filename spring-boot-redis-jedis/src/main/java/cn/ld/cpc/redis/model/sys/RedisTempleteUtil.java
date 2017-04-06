package cn.ld.cpc.redis.model.sys;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisTempleteUtil {

	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplete;

	/**
	 * 批量删除对应的value
	 * 
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 * 
	 * @param pattern
	 */
	@SuppressWarnings("unchecked")
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplete.keys(pattern);
		if (keys.size() > 0)
			redisTemplete.delete(keys);
	}

	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	@SuppressWarnings("unchecked")
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplete.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean exists(final String key) {
		return redisTemplete.hasKey(key);
	}

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object get(final String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplete.opsForValue();
		result = operations.get(key);
		return result;
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplete.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean set(Map<String,Object> map){
		boolean result = false;
		try {
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String key = it.next().toString();
				Object object = map.get(key);
				set(key,object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplete.opsForValue();
			operations.set(key, value);
			redisTemplete.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
