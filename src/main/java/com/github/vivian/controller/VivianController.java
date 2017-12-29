package com.github.vivian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}