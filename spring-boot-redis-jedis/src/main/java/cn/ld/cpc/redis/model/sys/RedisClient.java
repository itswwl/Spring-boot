package cn.ld.cpc.redis.model.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Component
public class RedisClient<T> {

	private Jedis jedis;// 非切片额客户端连接
	private JedisPool jedisPool;// 非切片连接池
	private ShardedJedis shardedJedis;// 切片额客户端连接
	private ShardedJedisPool shardedJedisPool;// 切片连接池

	public <T> RedisClient() {
		initialPool();
		initialShardedPool();
		shardedJedis = shardedJedisPool.getResource();
		jedis = jedisPool.getResource();

	}

	/**
	 * 初始化非切片池
	 */
	private void initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	}

	/**
	 * 初始化切片池
	 */
	private void initialShardedPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));

		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}
	
	public boolean exits(String key){
		return jedis.exists(key);
	}
	
	public void delete(String key){
		if(exits(key)){
			jedis.del(key);
		}
	}
	
	public T get(String key,Class<T> c){
		String json = jedis.get(key);
		if(exits(key)){
			return (T) ObjectMapperUtil.jsonToEntity(json, c);
		}
		return null;
	}
	
	public String set(String key,T t){
		String value = ObjectMapperUtil.entityToJson(t);
		return jedis.set(key, value);
	}
	
	public Long sadd(String key,T t){
		String value = ObjectMapperUtil.entityToJson(t);
		return jedis.sadd(key, value);
	}

}
