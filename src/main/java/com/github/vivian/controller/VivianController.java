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
public class VivianController {

	@RequestMapping(value = "/")
	public String hello(){
		return "index";
	}
}
