package cn.ld.cpc.redis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ld.cpc.redis.model.sys.CpcCompanyEmployee;
import cn.ld.cpc.redis.service.CpcCompanyEmployeeService;
import cn.ld.cpc.redis.service.CpcCompanyEmployeeServiceJedis;

@RequestMapping("/company/employee2")
@RestController
public class CpcCompanyEmployeeController2 {

	private static final Logger logger = Logger.getLogger(CpcCompanyEmployeeController2.class);

	@Autowired
	private CpcCompanyEmployeeServiceJedis cpcCompanyEmployeeServiceJedis;

	@RequestMapping("/save")
	public CpcCompanyEmployee save() {
		CpcCompanyEmployee cpcCompanyEmployee = null;
		try {
			logger.info("CpcCompanyEmployeeController----->save()");
			cpcCompanyEmployee = new CpcCompanyEmployee();
			// cpcCompanyEmployee.setId(100000000L);
			cpcCompanyEmployee.setRealName("张");
			cpcCompanyEmployee.setIdCardNo("100000000");
			cpcCompanyEmployee = cpcCompanyEmployeeServiceJedis.save(cpcCompanyEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpcCompanyEmployee;
	}

	@RequestMapping("/saveList")
	public List<CpcCompanyEmployee> saveList() {
		List<CpcCompanyEmployee> list = new ArrayList<>();
		try {
			logger.info("CpcCompanyEmployeeController----->saveList()");
			CpcCompanyEmployee cpcCompanyEmployee1 = new CpcCompanyEmployee();
			// cpcCompanyEmployee1.setId(200000000L);
			cpcCompanyEmployee1.setRealName("李");
			cpcCompanyEmployee1.setIdCardNo("200000000");
			CpcCompanyEmployee cpcCompanyEmployee2 = new CpcCompanyEmployee();
			// cpcCompanyEmployee2.setId(300000000L);
			cpcCompanyEmployee2.setRealName("王");
			cpcCompanyEmployee2.setIdCardNo("300000000");
			list.add(cpcCompanyEmployee1);
			list.add(cpcCompanyEmployee2);
			list = cpcCompanyEmployeeServiceJedis.saveList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping("/update")
	public CpcCompanyEmployee update() {
		CpcCompanyEmployee cpcCompanyEmployee = null;
		try {
			logger.info("CpcCompanyEmployeeController----->update()");
			cpcCompanyEmployee = cpcCompanyEmployeeServiceJedis.update(100000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpcCompanyEmployee;
	}

	@RequestMapping("/updateList")
	public List<CpcCompanyEmployee> updateList() {
		List<CpcCompanyEmployee> list = new ArrayList<>();
		try {
			logger.info("CpcCompanyEmployeeController----->updateList()");
			List<Long> l = new ArrayList<>();
			l.add(200000000L);
			l.add(300000000L);

			list = cpcCompanyEmployeeServiceJedis.updateList(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * String
	 * 
	 * CpcCompanyEmployeeServicefindById100000000
	 * 
	 * [
		    "cn.ld.cpc.redis.model.sys.CpcCompanyEmployee",
		    {
		        "id": 100000000,
		        "realName": "张",
		        "idCardNo": "100000000",
		        "rsPersonalID": null,
		        "currentORGID": null,
		        "createUserID": null,
		        "createTime": null,
		        "lastUpdateTime": null,
		        "createUserType": null,
		        "removeUserId": null,
		        "removeTime": null,
		        "removeUserType": null,
		        "rsOrgUserId": null,
		        "pinyin": null,
		        "status": null
		    }
		]
	 * 
	 * 
	 * zset
	 * 
	 * findById~keys
	 * 
	 * cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindById100000000
	 */

	@RequestMapping("/findById")
	public CpcCompanyEmployee findById() {
		CpcCompanyEmployee cpcCompanyEmployee = null;
		try {
			logger.info("CpcCompanyEmployeeController----->findById()");
			cpcCompanyEmployee = cpcCompanyEmployeeServiceJedis.findById(100000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpcCompanyEmployee;
	}

	@RequestMapping("/findById2")
	public CpcCompanyEmployee findById2() {
		CpcCompanyEmployee cpcCompanyEmployee = null;
		try {
			logger.info("CpcCompanyEmployeeController----->findById2()------->测试缓存");
			cpcCompanyEmployee = cpcCompanyEmployeeServiceJedis.findById(100000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpcCompanyEmployee;
	}

	/*
	 * String
	 * 
	 * cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindList[200000000,
	 * 300000000]
	 * 
	 * [
		    "java.util.ArrayList",
		    [
		        [
		            "cn.ld.cpc.redis.model.sys.CpcCompanyEmployee",
		            {
		                "id": 200000000,
		                "realName": "李",
		                "idCardNo": "200000000",
		                "rsPersonalID": null,
		                "currentORGID": null,
		                "createUserID": null,
		                "createTime": null,
		                "lastUpdateTime": null,
		                "createUserType": null,
		                "removeUserId": null,
		                "removeTime": null,
		                "removeUserType": null,
		                "rsOrgUserId": null,
		                "pinyin": null,
		                "status": null
		            }
		        ],
		        [
		            "cn.ld.cpc.redis.model.sys.CpcCompanyEmployee",
		            {
		                "id": 300000000,
		                "realName": "王",
		                "idCardNo": "300000000",
		                "rsPersonalID": null,
		                "currentORGID": null,
		                "createUserID": null,
		                "createTime": null,
		                "lastUpdateTime": null,
		                "createUserType": null,
		                "removeUserId": null,
		                "removeTime": null,
		                "removeUserType": null,
		                "rsOrgUserId": null,
		                "pinyin": null,
		                "status": null
		            }
		        ]
		    ]
		]
	 * 
	 * 
	 * zset
	 * 
	 * findList~keys
	 * 
	 * cn.ld.cpc.redis.service.CpcCompanyEmployeeServicefindList[200000000,
	 * 300000000]
	 */

	@RequestMapping("/findList")
	public List<CpcCompanyEmployee> findList() {
		List<CpcCompanyEmployee> list = new ArrayList<>();
		try {
			logger.info("CpcCompanyEmployeeController----->findList()");
			List<Long> l = new ArrayList<>();
			l.add(200000000L);
			l.add(300000000L);
			list = cpcCompanyEmployeeServiceJedis.findList(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping("/findList2")
	public List<CpcCompanyEmployee> findList2() {
		List<CpcCompanyEmployee> list = new ArrayList<>();
		try {
			logger.info("CpcCompanyEmployeeController----->findList2()------->测试缓存");
			List<Long> l = new ArrayList<>();
			l.add(200000000L);
			l.add(300000000L);
			list = cpcCompanyEmployeeServiceJedis.findList(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping("/page")
	public /* Page<CpcCompanyEmployee> */List<CpcCompanyEmployee> page() {
		// Page<CpcCompanyEmployee> page = null;
		List<CpcCompanyEmployee> page = null;
		try {
			logger.info("CpcCompanyEmployeeController----->page()");
			Map<String, Object> map = new HashMap<>();
			page = cpcCompanyEmployeeServiceJedis.page(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	@RequestMapping("/page2")
	public /* Page<CpcCompanyEmployee> */List<CpcCompanyEmployee> page2() {
		// Page<CpcCompanyEmployee> page = null;
		List<CpcCompanyEmployee> page = null;
		try {
			logger.info("CpcCompanyEmployeeController----->page2()------->测试缓存");
			Map<String, Object> map = new HashMap<>();
			page = cpcCompanyEmployeeServiceJedis.page(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	@RequestMapping("/delete")
	public void delete() {
		try {
			logger.info("CpcCompanyEmployeeController----->delete()");
			cpcCompanyEmployeeServiceJedis.delte(100000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("/deleteList")
	public void deleteList() {
		try {
			logger.info("CpcCompanyEmployeeController----->deleteList()");
			List<Long> list = new ArrayList<>();
			list.add(200000000L);
			list.add(300000000L);
			cpcCompanyEmployeeServiceJedis.deleteList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
