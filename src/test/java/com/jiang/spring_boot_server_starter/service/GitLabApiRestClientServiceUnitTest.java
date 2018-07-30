package com.jiang.spring_boot_server_starter.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class GitLabApiRestClientServiceUnitTest {
	
	@Mock
    private RestTemplate restTemplate;
	
	@InjectMocks
	private GitLabApiRestClientService gitLabApiRestClientService;
	
	@Test
    public void test() {
        Mockito.when(restTemplate.getForObject(
        		"http://192.168.1.1/test",
                String.class
                ))
                .thenReturn("777");
        String result = gitLabApiRestClientService.getString();
        assertThat(result).isEqualTo("666");
    }	

}
