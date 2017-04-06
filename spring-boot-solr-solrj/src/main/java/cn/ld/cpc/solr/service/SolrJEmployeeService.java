package cn.ld.cpc.solr.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import cn.ld.cpc.solr.model.sys.EmployeeSolr;


//调用solr客户端
@Service
public class SolrJEmployeeService {
	
	private static final Logger logger = Logger.getLogger(SolrJEmployeeService.class);
	
	private final static String SOLR_URL = "http://127.0.0.1:9090/solr/collection1";
	private HttpSolrServer server = null;
	private SolrQuery query = new SolrQuery();

	public SolrJEmployeeService() {
		super();
		server = new HttpSolrServer(SOLR_URL);
		server.setMaxRetries(1);
	    server.setMaxRetries(1); // defaults to 0. > 1 not recommended.
	    server.setConnectionTimeout(5000); // 5 seconds to establish TCP
	}
	
	//添加一个
	public void add(){
		EmployeeSolr employeeSolr1 = new EmployeeSolr();
		employeeSolr1.setId("1000000");
		employeeSolr1.setIdcardno("1000000");
		employeeSolr1.setRealname("1000000");
		employeeSolr1.setCreatetime(new Date());
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		solrInputDocument.addField("id", employeeSolr1.getId());
		solrInputDocument.addField("realname", employeeSolr1.getRealname());
		solrInputDocument.addField("idcardno", employeeSolr1.getIdcardno());
		solrInputDocument.addField("createtime", employeeSolr1.getCreatetime());
		try {
//			server.setRequestWriter(new BinaryRequestWriter());
//			server.addBean(employeeSolr1, 1000);//throws org.apache.solr.client.solrj.impl.HttpSolrServer$RemoteSolrException: Unknown type 19
			server.add(solrInputDocument);
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加一个list
	public void addList(){
		
		Collection<EmployeeSolr> list = new ArrayList<>();
		
		EmployeeSolr employeeSolr1 = new EmployeeSolr();
		employeeSolr1.setId("7000000");
		employeeSolr1.setIdcardno("7000000");
		employeeSolr1.setRealname("7000000");
		employeeSolr1.setCreatetime(new Date());
		
		EmployeeSolr employeeSolr2 = new EmployeeSolr();
		employeeSolr2.setId("8000000");
		employeeSolr2.setIdcardno("8000000");
		employeeSolr2.setRealname("8000000");
		employeeSolr2.setCreatetime(new Date());
		
		EmployeeSolr employeeSolr3 = new EmployeeSolr();
		employeeSolr3.setId("9000000");
		employeeSolr3.setIdcardno("9000000");
		employeeSolr3.setRealname("9000000");
		employeeSolr3.setCreatetime(new Date());
		
		EmployeeSolr employeeSolr4 = new EmployeeSolr();
		employeeSolr4.setId("4000000");
		employeeSolr4.setIdcardno("4000000");
		employeeSolr4.setRealname("4000000");
		employeeSolr4.setCreatetime(new Date());
		
		EmployeeSolr employeeSolr5 = new EmployeeSolr();
		employeeSolr5.setId("5000000");
		employeeSolr5.setIdcardno("5000000");
		employeeSolr5.setRealname("5000000");
		employeeSolr5.setCreatetime(new Date());
		
		EmployeeSolr employeeSolr6 = new EmployeeSolr();
		employeeSolr6.setId("6000000");
		employeeSolr6.setIdcardno("6000000");
		employeeSolr6.setRealname("6000000");
		employeeSolr6.setCreatetime(new Date());
		
		list.add(employeeSolr1);
		list.add(employeeSolr2);
		list.add(employeeSolr3);
		list.add(employeeSolr4);
		list.add(employeeSolr5);
		list.add(employeeSolr6);
		
		
		try {
			server.setRequestWriter(new BinaryRequestWriter());
			server.addBeans(list.iterator());
			//server.optimize();
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//删除
	public void delete(){
		try {
			server.deleteById("4000000");
			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//删除集合
	public void deleteList(){
		try {
			List<String> list = new ArrayList<>();
			list.add("5000000");
			list.add("6000000");
			list.add("2000000");
			server.deleteById(list);
			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//删除所有
	public void deleteAll(){
		try {
			server.deleteByQuery("*:*");
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*	{
     	responseHeader=
			{status=0,QTime=19,params=
				{
					q=realname:张*,start=0,rows=2,facet=true,wt=javabin,version=2
				}
			},
		response=
		{
			numFound=14,start=0,docs=
				[
					SolrDocument
					 {
					 	idcardno=153136199007175566, realname=张小娴, id=860, createtime=Wed Jul 06 00:00:00 CST 2016, _version_=1541625463067115520
					 }, 
					 SolrDocument
					 {
						 idcardno=580410197505151144, realname=张思洋, id=764, createtime=Thu Jun 30 00:00:00 CST 2016, _version_=1541625463070261248
					 }
			 	]
		},
		facet_counts=
		{
			facet_queries={},facet_fields={},facet_dates={},facet_ranges={}
		}
	}*/
	//查询
	public void find(Map<String,String> map){
		try {
			query.setQuery("realname:"+map.get("realname"));
			query.setStart(0);
			query.setRows(2);
			query.setFacet(true);
			QueryResponse response = server.query(query);
			// {responseHeader={status=0,QTime=1,params={q=realname:张*,start=0,rows=2,facet=true,wt=javabin,version=2}},response={numFound=14,start=0,docs=[SolrDocument{idcardno=153136199007175566, realname=张小娴, id=860, createtime=Wed Jul 06 00:00:00 CST 2016, _version_=1541625463067115520}, SolrDocument{idcardno=580410197505151144, realname=张思洋, id=764, createtime=Thu Jun 30 00:00:00 CST 2016, _version_=1541625463070261248}]},facet_counts={facet_queries={},facet_fields={},facet_dates={},facet_ranges={}}}
			logger.info(response);
			//{responseHeader={status=0,QTime=1,params={q=realname:张*,start=0,rows=2,facet=true,wt=javabin,version=2}},response={numFound=14,start=0,docs=[SolrDocument{idcardno=153136199007175566, realname=张小娴, id=860, createtime=Wed Jul 06 00:00:00 CST 2016, _version_=1541625463067115520}, SolrDocument{idcardno=580410197505151144, realname=张思洋, id=764, createtime=Thu Jun 30 00:00:00 CST 2016, _version_=1541625463070261248}]},facet_counts={facet_queries={},facet_fields={},facet_dates={},facet_ranges={}}}
			logger.info(response.getResponse());
			//{status=0,QTime=1,params={q=realname:张*,start=0,rows=2,facet=true,wt=javabin,version=2}}
			logger.info(response.getResponseHeader());
			//{numFound=14,start=0,docs=[SolrDocument{idcardno=153136199007175566, realname=张小娴, id=860, createtime=Wed Jul 06 00:00:00 CST 2016, _version_=1541625463067115520}, SolrDocument{idcardno=580410197505151144, realname=张思洋, id=764, createtime=Thu Jun 30 00:00:00 CST 2016, _version_=1541625463070261248}]}
			logger.info(response.getResults());
			//NameList nameList = (NameList) response.getResponse();
			
		//	logger.info(nameList.getLength());
			
			
			SolrDocumentList solrDocumentList = response.getResults();
			
			for (SolrDocument solrDocument : solrDocumentList) {
				logger.info(solrDocument.get("id").toString()+"=========="+solrDocument.getFieldValue("id").toString());
				logger.info(solrDocument.get("realname").toString()+"=========="+solrDocument.getFieldValue("realname").toString());
				logger.info(solrDocument.get("idcardno").toString()+"=========="+solrDocument.getFieldValue("idcardno").toString());
				logger.info(solrDocument.get("createtime").toString()+"=========="+solrDocument.getFieldValue("createtime").toString());
			}
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	    
	}
	
	//更新一个
	public void update(){
		EmployeeSolr employeeSolr1 = new EmployeeSolr();
		employeeSolr1.setId("6000000");
		employeeSolr1.setIdcardno("6666666");
		employeeSolr1.setRealname("6666666");
		employeeSolr1.setCreatetime(new Date());
		
		Map<String,String> map = new HashMap<>();
		map.put("set", employeeSolr1.getIdcardno());
		
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		solrInputDocument.addField("id", employeeSolr1.getId());
		//solrInputDocument.addField("realname", employeeSolr1.getRealname());
		solrInputDocument.addField("idcardno", map);
		//solrInputDocument.addField("createtime", employeeSolr1.getCreatetime());
		try {
//			server.setRequestWriter(new BinaryRequestWriter());
//			server.addBean(employeeSolr1);
			server.add(solrInputDocument);
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//更新集合
	public void updateList(){
		Collection<EmployeeSolr> list = new ArrayList<>();
		
		EmployeeSolr employeeSolr1 = new EmployeeSolr();
		employeeSolr1.setId("7000000");
		employeeSolr1.setIdcardno("7777777");
		employeeSolr1.setRealname("7777777");
		employeeSolr1.setCreatetime(new Date());
		
		EmployeeSolr employeeSolr2 = new EmployeeSolr();
		employeeSolr2.setId("8000000");
		employeeSolr2.setIdcardno("8888888");
		employeeSolr2.setRealname("8888888");
		employeeSolr2.setCreatetime(new Date());
		
		
		list.add(employeeSolr1);
		list.add(employeeSolr2);
		
		
		
		try {
			server.setRequestWriter(new BinaryRequestWriter());
			server.addBeans(list.iterator());//操作结合
			//server.optimize();
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
