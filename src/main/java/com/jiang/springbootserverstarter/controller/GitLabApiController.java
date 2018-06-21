package com.jiang.springbootserverstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.springbootserverstarter.serviceImpl.GitLabApiSVImpl;

@RestController
public class GitLabApiController {
	
	@Autowired
	private GitLabApiSVImpl gitLabApiSVImpl;
	
	@RequestMapping("/testGit")
    public void testGit() {
		gitLabApiSVImpl.getRepoBranchArchive(1, "2");
    }

}
