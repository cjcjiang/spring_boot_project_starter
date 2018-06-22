package com.jiang.springbootserverstarter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.springbootserverstarter.serviceImpl.GitLabApiSVImpl;
import com.jiang.springbootserverstarter.utils.UnZipUtil;

@RestController
public class GitLabApiController {
	
	@Autowired
	private GitLabApiSVImpl gitLabApiSVImpl;
	
	@RequestMapping("/testGit")
    public void testGit() throws IOException {
		gitLabApiSVImpl.getRepoBranchArchive(1, "2");
		UnZipUtil.unTarGz("14", "12");
    }

}
