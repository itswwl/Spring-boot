package cn.ld.cpc.solr.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ld.cpc.solr.service.SolrJEmployeeService;

@RequestMapping("/solrj")
@RestController
public class SolrJController {
	
	private final static Logger logger = Logger.getLogger(SolrJController.class);
	
	@Autowired
	private SolrJEmployeeService solrJEmployeeService;
	
	@RequestMapping("/add")
	public void add(){
		logger.info("SolrJController--->add()");
		solrJEmployeeService.add();
		return;
	}
	
	@RequestMapping("/addList")
	public void addList(){
		logger.info("SolrJController--->add()");
		solrJEmployeeService.addList();
		return;
	}
	
	@RequestMapping("/update")
	public void update(){
		logger.info("SolrJController--->update()");
		solrJEmployeeService.update();
		return;
	}
	
	@RequestMapping("/updateList")
	public void updateList(){
		logger.info("SolrJController--->updateList()");
		solrJEmployeeService.updateList();
		return;
	}
	
	@RequestMapping("/find")
	public void find(){
		logger.info("SolrJController--->find()");
		Map<String,String> map = new HashMap<>();
		map.put("realname", "90*");
		solrJEmployeeService.find(map);
		return;
	}
	
	@RequestMapping("/delete")
	public void delete(){
		logger.info("SolrJController--->delete()");
		solrJEmployeeService.delete();
		return;
	}
	
	@RequestMapping("/deleteList")
	public void deleteList(){
		logger.info("SolrJController--->deleteList()");
		solrJEmployeeService.deleteList();
		return;
	}
	
	@RequestMapping("/deleteAll")
	public void deleteAll(){
		logger.info("SolrJController--->delete()");
		solrJEmployeeService.deleteAll();
		return;
	}

}
