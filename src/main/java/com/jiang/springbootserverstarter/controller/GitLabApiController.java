package com.jiang.springbootserverstarter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.springbootserverstarter.serviceImpl.GitLabApiSVImpl;
import com.jiang.springbootserverstarter.utils.UnZipUtil;

/**
 * 调用gitlab api的封装接口。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
@RestController
public class GitLabApiController {
	
	@Autowired
	private GitLabApiSVImpl gitLabApiSVImpl;
	
	/** 
     * 调用gitlab api获得此repo全部文件并解压的测试接口。
     * 
     * @throws IOException
     * 
     * @author Yuming Jiang
     * @since 0.0.1-SNAPSHOT
     */
	@RequestMapping("/testGit")
    public void testGit() throws IOException {
		gitLabApiSVImpl.getRepoBranchArchive(1, "2");
		UnZipUtil.unTarGz("14", "12");
    }

}
