package cn.ld.cpc.solr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ld.cpc.solr.model.sys.ResultHandle;
import cn.ld.cpc.solr.model.sys.ResultHandleImpl;

@RequestMapping("/employee")
@RestController
public class EmployeeSolrController {

	private final static Logger logger = Logger.getLogger(EmployeeSolrController.class);

	private RestTemplate restTemplate = new RestTemplate();

	private final static String url = "http://127.0.0.1:9090/solr/collection1";

	/*
	 * "responseHeader":{ "status":0, "QTime":0, "params":{ "q":"realname:张*",
	 * "wt":"json"}}, "response":{"numFound":14,"start":0,"docs":[ {
	 * "idcardno":"153136199007175566", "realname":"张小娴", "id":"860",
	 * "createtime":"2016-07-05T16:00:00Z", "_version_":1541621459199197184}, {
	 * "idcardno":"580410197505151144", "realname":"张思洋", "id":"764",
	 * "createtime":"2016-06-29T16:00:00Z", "_version_":1541621459203391488}, {
	 * "idcardno":"156105197905061122", "realname":"张连珍", "id":"846",
	 * "createtime":"2016-06-30T16:00:00Z", "_version_":1541621459204440065}, {
	 * "idcardno":"156105197905061122", "realname":"张连珍", "id":"848",
	 * "createtime":"2016-06-30T16:00:00Z", "_version_":1541621459204440066}, {
	 * "idcardno":"156105197905061122", "realname":"张连珍", "id":"849",
	 * "createtime":"2016-06-30T16:00:00Z", "_version_":1541621459205488640}, {
	 * "idcardno":"156105197905061122", "realname":"张连珍", "id":"875",
	 * "createtime":"2016-07-05T16:00:00Z", "_version_":1541621459206537216}, {
	 * "idcardno":"123123197806115488", "realname":"张永杰", "id":"581",
	 * "createtime":"2016-06-26T16:00:00Z", "_version_":1541621459210731520}, {
	 * "idcardno":"150150198908084455", "realname":"张苏", "id":"583",
	 * "createtime":"2016-06-26T16:00:00Z", "_version_":1541621459210731521}, {
	 * "idcardno":"552110199009095566", "realname":"张树森", "id":"1036",
	 * "createtime":"2016-07-24T16:00:00Z", "_version_":1541621459213877249}, {
	 * "idcardno":"152333198909095588", "realname":"张苏", "id":"1037",
	 * "createtime":"2016-07-24T16:00:00Z", "_version_":1541621459213877250}] }}
	 */

	// http://127.0.0.1:9090/solr/collection1/query?q=realname:张&wt=json
	@RequestMapping("/likeName/{name}")
	public ResultHandle<List<Map<String, Object>>> likeName(@PathVariable("name") String name) {
		ResultHandle<List<Map<String, Object>>> resultHandle = new ResultHandleImpl<>();
		try {

			logger.info(url + "/query?q=realname:" + name + "&wt=json");
			Map<String, Object> map = new HashMap<>();
			String jsonData = restTemplate.getForObject(url + "/query?q=realname:" + name + "*&wt=json", String.class);
			logger.info(jsonData);
			ObjectMapper objectMapper = new ObjectMapper();
			map = objectMapper.readValue(jsonData, Map.class);
			Map<String, Object> doc = (Map<String, Object>) map.get("response");
			List<Map<String, Object>> data = (List<Map<String, Object>>) doc.get("docs");
			resultHandle.setResponseBody(data);
			logger.info(resultHandle.getResponseBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultHandle;
	}

	// http://localhost:9090/solr/collection1/dataimport?command=delta-import&clean=false&commit=true
	// 执行增量
	@RequestMapping("/deltaimport")
	public void deltaimport() {
		restTemplate.getForObject(url + "/dataimport?command=delta-import&clean=false&commit=true&wt=json",
				String.class);
		return;
	}

	// 执行删除
	/*
	 * <add commitWithin="1000" overwrite="true"> <delete> <query>id:1</query>
	 * </delete> <commit></commit> </add>
	 */
	// http://localhost:9090/solr/collection1/update/?stream.body=<delete><id>40000</id></delete>&stream.contentType=text/xml;charset=utf-8&commit=true
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		logger.info(url
				+ "/?stream.body=<delete><id>*:*</id></delete>&stream.contentType=text/xml;charset=utf-8&commit=true");
		restTemplate.postForEntity(
				url + "/update/?stream.body=<delete><id>" + id
						+ "</id></delete>&stream.contentType=text/xml;charset=utf-8&commit=true&wt=json",
				null, String.class);
		return;
	}

	//添加索引
	@RequestMapping("/fullimport")
	public void fullimport(){
		logger.info(url+"/dataimport?command=full-import");
		restTemplate.getForObject(url+"/dataimport?command=full-import", String.class);
		return;
	}
	
	//停止索引
	@RequestMapping("/abort")
	public void abort(){
		logger.info(url+"/dataimport?command=abort");
		restTemplate.getForObject(url+"/dataimport?command=abort", String.class);
		return ;
	}
	
}
