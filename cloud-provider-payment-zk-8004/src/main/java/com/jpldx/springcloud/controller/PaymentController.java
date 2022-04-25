package com.jpldx.springcloud.controller;

import com.jpldx.springcloud.base.Result;
import com.jpldx.springcloud.entity.Payment;
import com.jpldx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public Result add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        if(result > 0){
            return new Result(200, "success!", result);
        }
        return new Result(500, "failed!", null);
    }

    @GetMapping("/get/{id}")
    public Result get(@PathVariable(name = "id") Long id){
        Payment result = paymentService.getById(id);
        if(result != null){
            return new Result(200, "success! - " + serverPort, result);
        }
        return new Result(500, "failed!", null);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        // 获取服务列表
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }

        // 获取指定服务名称的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" +
                    instance.getInstanceId() + "\t" +
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri());
        }
        return discoveryClient;
    }


    @GetMapping("/zk")
    public String paymentZk(){
        return "Spring Cloud with Zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
