package com.jpldx.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chen.xudong
 * @since 1.0.0
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    // 原子计数器
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    // 自旋锁实现（解决高并发场景下计数问题）
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            // <= Integer.MAX_VALUE
            next = current >= 2147483647 ? 0 : current + 1;
        }
        // 当前值 = 期望值 -> 修改，否则继续自旋
        while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****** Access times: " + next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 求下标
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
