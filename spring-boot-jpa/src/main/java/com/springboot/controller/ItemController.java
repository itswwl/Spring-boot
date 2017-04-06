package com.springboot.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.domain.Items;
import com.springboot.services.IItemServices;
import com.springboot.services.ItemService;

@Controller
@RequestMapping("/springboot/item")
public class ItemController {
	
	private static Logger logger = Logger.getLogger(ItemController.class);
	
	@Autowired
	private IItemServices itemServices;
	
//	@Autowired
//	private IItemDao itemDao;
	
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("index", "index");
		return "index";
	}
	
	@RequestMapping("/all")
	public String getAll(Model model){
		List<Items> items = itemServices.findAll();
		model.addAttribute("items", items);
		logger.info("=================================无缓存的时候调用这里");
		return "all";
	}
	
	@RequestMapping("/all2")
	@ResponseBody
	public List<Items> getAll2(){
		logger.info("===========================================有缓存调用这里");
		return (List<Items>) itemServices.findAll();
	}
	
	@Autowired
	private ItemService is;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Map<String,Object>> findAll(){
		List<Map<String,Object>> list = is.findAll();
//		for (Map<String, Object> map : list) {
//			Set<String> keys = map.keySet();
//			if(keys!=null){
//				Iterator<String> it = keys.iterator();
//				while(it.hasNext()){
//					String key = it.next();
//					logger.info("======================="+key+"============================"+map.get(key));
//				}
//			}
//		}
		for (Map<String, Object> map : list) {
			logger.info("======================="+map.get("ID")+"============================"+map.get("NAME"));
		}
		return list;
	}
	
	@RequestMapping("/findAll2")
	@ResponseBody
	public String findAll2(Integer page, Integer rows , Pageable pageable){
		int total = is.findAll().size();
		List<Map<String,Object>> list = is.findAll(page, rows);
		StringBuffer sb = new StringBuffer();
		sb.append("{\"total\":"+total+",\"rows\":[");
		for (Map<String, Object> map : list) {
			
			sb.append("{\"ID\":"+map.get("ID")+",\"NAME\":\""+map.get("NAME")+"\"},");
		}
		sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",")+1, "");
		sb.append("]}");
		return sb.toString();
	}

}
