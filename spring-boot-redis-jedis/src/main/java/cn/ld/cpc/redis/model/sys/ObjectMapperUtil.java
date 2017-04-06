package cn.ld.cpc.redis.model.sys;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* 
 * 将json对象转换成实体
 * */
public class ObjectMapperUtil<T> {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 
	 * 将json转化成实体
	 * 
	 * @param json
	 * @param c
	 * @return
	 */
	public static <T> T jsonToEntity(String json,Class<T> c){
		T t = null;
		try {
			t = objectMapper.readValue(json, c);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 
	 * 将实体转化成json
	 * 
	 * @param t
	 * @return
	 */
	public static <T> String entityToJson(T t){
//		Class<? extends Object> c = t.getClass();
		String json = null;
		try {
//			Object o = c.newInstance();
//			json = objectMapper.writeValueAsString(o);
			json = objectMapper.writeValueAsString(t);
		} catch ( JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}
