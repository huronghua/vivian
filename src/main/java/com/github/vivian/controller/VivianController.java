package com.github.vivian.controller;

import com.github.vivian.domain.Vivian;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther:Eric https://github.com/huronghua
 * @Date:2017/12/28 21 19
 */

@Controller
@RequestMapping(value = "/vivian")
public class VivianController {

	@RequestMapping(value = "/index")
	public String hello(){
		return "index";
	}

	@RequestMapping(value = "/pagination")
	@ResponseBody
	public Map<String,Object> pagination(HttpServletRequest request){

		String page = request.getParameter("page");
		Map<String,Object> map = new HashMap<>();
		List<Vivian> vivianList = new ArrayList<>();
		for(int i = 0;i<8;i++){
			Vivian vivian = new Vivian();
			vivian.setName("wangweiwei");
			vivian.setSex("female");
			vivianList.add(vivian);
		}
		map.put("user",vivianList);
		return map;
	}
}
