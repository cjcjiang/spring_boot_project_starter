package com.jiang.springbootserverstarter.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jiang.springbootserverstarter.serviceInterface.GitLabApiSVInterface;

@Service
public class GitLabApiSVImpl implements GitLabApiSVInterface {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Override
	public void getRepoBranchArchive(Integer repoId, String branch) {
		String url = "http://192.168.100.10/api/v3/projects/"
				+ "3807/repository/archive?"
				+ "sha=develop&private_token=bE-VD3mb65K1A3erxvR9";
		String temp_storage = "C:\\Users\\Lenovo\\Desktop\\temp.tar.gz";
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<byte[]> response = restTemplate
        		.exchange(url, HttpMethod.GET, entity, byte[].class);
        try {
        	Files.write(Paths.get(temp_storage), response.getBody());
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}

}
