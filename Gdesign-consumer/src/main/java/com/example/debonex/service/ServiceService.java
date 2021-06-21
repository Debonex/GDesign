package com.example.debonex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

/**
 * @author Debonex
 * @date 2021年6月21日
 */
@Service
public class ServiceService {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    /**
     * 发现服务实例
     * @param serviceName 服务名称
     * @return 服务实例
     */
    public ServiceInstance discover(String serviceName){
        return loadBalancerClient.choose(serviceName);
    }
}
