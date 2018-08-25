package com.flf.controller;


import com.flf.SpringbootSsmApplication;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 冯磊峰 on 2018/8/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSsmApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class user_test {
    @Autowired
    private TestRestTemplate testRestTemplate;
//    @Autowired
//    private AsyncRestTemplate asyncRestTemplate;

    //SpringbootSsmApplication.class 为SpringBoot的启动入口类,每个SpringBoot项目大家都会配置

    @Test
    public void get() throws Exception {
        Map<String,String> multiValueMap = new HashMap<>();
        multiValueMap.put("username","lake");//传值，但要在url上配置相应的参数
        int result = testRestTemplate.getForObject("/s",int.class,multiValueMap);
        Assert.assertEquals(result,2);
        Assert.assertEquals(result,0);
    }

    @Test
    public void post() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username","lake");
        int result = testRestTemplate.postForObject("/s",multiValueMap,int.class);
        Assert.assertEquals(result,2);
        Assert.assertEquals(result,0);
    }


    @Test
    public void upload() throws Exception {
        Resource resource = new FileSystemResource("/home/lake/github/wopi/build.gradle");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username","lake");
        multiValueMap.add("files",resource);
        Integer result = testRestTemplate.postForObject("/test/upload",multiValueMap,Integer.class);
        Assert.assertEquals(result.intValue(),0);
    }

    @Test
    public void download() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token","xxxxxx");
        HttpEntity formEntity = new HttpEntity(headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<byte[]> response = testRestTemplate.exchange("/test/download?username={1}", HttpMethod.GET,formEntity,byte[].class,urlVariables);
        if (response.getStatusCode() == HttpStatus.OK) {
//            Files.write(response.getBody(),new File("/home/lake/github/file/test.gradle"));
//            Files.write(new Path() {
//            }"/home/lake/github/file/test.gradle", response.getBody())
// ;
            Files.write(Paths.get("/home/lake/github/file/test.gradle"),response.getBody());
        }
    }
    @Test
    public void getHeader() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token","xxxxxx");
        HttpEntity formEntity = new HttpEntity(headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<Integer> result = testRestTemplate.exchange("/test/getHeader?username={username}", HttpMethod.GET,formEntity,Integer.class,urlVariables);
        Assert.assertEquals(result.getBody().intValue(),0);
    }
    @Test
    public void putHeader() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token","xxxxxx");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username","lake");
        HttpEntity formEntity = new HttpEntity(multiValueMap,headers);
        ResponseEntity<Integer> result = testRestTemplate.exchange("/test/putHeader", HttpMethod.PUT,formEntity,Integer.class);
        Assert.assertEquals(result.getBody().intValue(),0);
    }
    @Test
    public void delete() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token","xxxxx");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username","lake");
        HttpEntity formEntity = new HttpEntity(multiValueMap,headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<Integer> result = testRestTemplate.exchange("/test/delete?username={username}", HttpMethod.DELETE,formEntity,Integer.class,urlVariables);
        Assert.assertEquals(result.getBody().intValue(),0);
    }


}