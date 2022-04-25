package com.jpldx.springcloud.controller;

import com.jpldx.springcloud.base.Result;
import com.jpldx.springcloud.entity.Payment;
import com.jpldx.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;


    //    private static final String PAYMENT_SERVICE_URL = "http://localhost:8001";
    private static final String PAYMENT_SERVICE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("/payment/add")
    public Result add(Payment payment) {
        return restTemplate.postForObject(PAYMENT_SERVICE_URL + "/payment/add", payment, Result.class);
    }

    @GetMapping("/payment/get/{id}")
    public Result get(@PathVariable(name = "id") Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/payment/get/" + id, Result.class);
    }

    /**
     * Test RestTemplate method xxxForEntity()
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/get2/{id}")
    public Result get2(@PathVariable(name = "id") Long id) {
        ResponseEntity<Result> re = restTemplate.getForEntity(PAYMENT_SERVICE_URL + "/payment/get/" + id, Result.class);
        if (re.getStatusCode().is2xxSuccessful()) {
            return re.getBody();
        }
        return new Result(500, "操作失败");
    }

    /**
     * 使用自己实现的负载均衡算法
     *
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return "Service unavailable.";
        }
        // 选择服务实例
        ServiceInstance si = loadBalancer.instances(instances);
        // 获取服务访问地址
        URI uri = si.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
