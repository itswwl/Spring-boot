package com.springboot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.domain.ItemDetails;
import com.springboot.services.IItemDetailsServices;
import com.springboot.vo.ItemDetailsVO;

@Controller
@RequestMapping("/springboot/itemDetails")
public class ItemDetailsController {
	
	private Logger logger = Logger.getLogger(ItemController.class);
	
	@Autowired
	private IItemDetailsServices itemDetailsServices;
	
	@RequestMapping("/")
	public String getAll(Model model){
		logger.info("================================"+itemDetailsServices.findAll().size());
		List<ItemDetails> itemDetails = itemDetailsServices.findAll();
		for (ItemDetails itemDetails2 : itemDetails) {
			logger.info(itemDetails2.getId()+"=================="+itemDetails2.getNum()+"==============="+itemDetails2.getGoods().getId()+"=========="+itemDetails2.getOrder().getId());
		}
		model.addAttribute("items", itemDetails);
		//return String.valueOf(itemDetailsServices.findAll().size());
		return "itemdetails";
	}
	
	@RequestMapping("/page")
	public String getPage2(@PageableDefault(value = 2, sort = { "id" }, direction = Sort.Direction.DESC)Pageable pageable,Model model){
		Page<ItemDetails> page = itemDetailsServices.findAll(pageable);
		model.addAttribute("pages", page);
		return "page";
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public String getPageById(@RequestParam(value = "role", defaultValue = "1") Integer id,@PageableDefault(value = 2, sort = { "id" }, direction = Sort.Direction.DESC)Pageable pageable,Model model){
		Page<ItemDetails> page = itemDetailsServices.getPageById(id, pageable);
		model.addAttribute("pages", page);
		return "page";
	}
	
	@RequestMapping(value = "/searchVO" , method = RequestMethod.GET)
	public String getPageBySearch(@PageableDefault(value = 2, sort = { "id" }, direction = Sort.Direction.DESC)Pageable pageable,Model model){
		ItemDetailsVO itemDetailsVO = new ItemDetailsVO();
		itemDetailsVO.setGoodsName("iao");
		itemDetailsVO.setNum(70);
		Page<ItemDetails> page = itemDetailsServices.getPageById(itemDetailsVO, pageable);
		for (ItemDetails itemDetails : page) {
			logger.info(itemDetails.getId()+"=================="+itemDetails.getNum()+"==============="+itemDetails.getGoods().getId()+"=========="+itemDetails.getGoods().getGoodsName());
		}
		model.addAttribute("searchPage", page);
		return "searchPage";
	}

}
