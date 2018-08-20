package com.jiang.spring_boot_server_starter.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.spring_boot_server_starter.utils.UnZipUtil;

/**
 * 测试spring security的接口。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
@Controller
public class SecurityTestController {
	
	@RequestMapping("/unsecuredPage")
    public String unsecuredPage() {
		return "unsecuredPage";
    }
	
	@RequestMapping("/securedPage")
    public String securedPage() {
		return "securedPage";
    }

}
