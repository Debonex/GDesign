package com.example.debonex.service;

import com.example.debonex.pojo.GResponse;
import com.example.debonex.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Debonet
 * @date 2021年7月25日
 */
@Service
public class UserService {

    @Autowired
    ServiceService serviceService;

    /**
     *
     * @param user userinfo
     * @return response
     */
    public GResponse register(User user){
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString()+"/user/register";
        return new RestTemplate().postForObject(url,user, GResponse.class);
    }

    /**
     *
     * @param user userinfo
     * @return response
     */
    public GResponse login(User user){
        ServiceInstance businessService = serviceService.discover("business-service");
        String url = businessService.getUri().toString()+"/user/login";
        return new RestTemplate().postForObject(url,user, GResponse.class);
    }
}
