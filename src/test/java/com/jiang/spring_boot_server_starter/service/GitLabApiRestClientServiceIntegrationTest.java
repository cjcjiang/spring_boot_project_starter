package com.jiang.spring_boot_server_starter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.jiang.spring_boot_server_starter.service.GitLabApiRestClientService;

@RunWith(SpringRunner.class)
@RestClientTest(GitLabApiRestClientService.class)
public class GitLabApiRestClientServiceIntegrationTest {
	
	@Autowired
	private GitLabApiRestClientService gitLabApiSVImpl;
	
	@Autowired
    private MockRestServiceServer server;
	
	@Before
    public void setUp() {
        String respondString = "jiang test";
         
        this.server
        .expect(requestTo("http://192.168.1.1/test"))
        .andRespond(withSuccess(respondString, MediaType.TEXT_HTML));
    }
	
	// this test will fail
	@Test
    public void testGetString() {
 
        String result = this.gitLabApiSVImpl.getString();
 
        assertThat(result).isEqualTo("666");
    }

}
