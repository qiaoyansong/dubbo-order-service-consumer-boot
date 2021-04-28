package com.qiaoyansong.controller;

import com.qiaoyansong.entity.UserAddress;
import com.qiaoyansong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：Qiao Yansong
 * @date ：Created in 2021/4/25 21:18
 * description：
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(path = "initOrder")
    public List<UserAddress> initOrder(String uid){
        return orderService.initOrder(uid);
    }

}
