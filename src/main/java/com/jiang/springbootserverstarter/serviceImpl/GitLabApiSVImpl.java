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

/**
 * 提供调用gitlab api的能力的服务的实现。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
@Service
public class GitLabApiSVImpl implements GitLabApiSVInterface {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/** 
     * 调用gitlab api，获得此repo所有文件的压缩包。
     * 
     * @param repoId 需要获得的项目在gitlab中的id。
     * 
     * @param branch 用户需要的此项目的branch。
     * 
     * @throws IOException
     * 
     * @author Yuming Jiang
     * @since 0.0.1-SNAPSHOT
     */
	@Override
	public void getRepoBranchArchive(Integer repoId, String branch) throws IOException {
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
        Files.write(Paths.get(temp_storage), response.getBody());
	}

}
