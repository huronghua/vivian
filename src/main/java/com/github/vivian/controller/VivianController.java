package com.github.vivian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Auther:Eric https://github.com/huronghua
 * @Date:2017/12/28 21 19
 */

@Controller
public class VivianController {

	@RequestMapping(value = "/")
	public String hello(){
		return "index1";
	}
}
