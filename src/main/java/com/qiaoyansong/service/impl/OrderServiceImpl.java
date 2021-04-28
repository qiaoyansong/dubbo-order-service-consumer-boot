package com.qiaoyansong.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qiaoyansong.entity.UserAddress;
import com.qiaoyansong.service.OrderService;
import com.qiaoyansong.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Qiao Yansong
 * @date ：Created in 2021/4/21 20:46
 * description: 参考consumer的xml配置文件进行配置，有的需要在application.properties中配置,并且
 * 对于Springboot的主方法必须加上@EnableDubbo
 *
 * 按照consumer.xml需要配置dubbo:reference所以需要使用Reference，用于获取服务提供者的实例
 */

@Service
public class OrderServiceImpl implements OrderService {

	@Reference
	private UserService userService;

	@Override
	public List<UserAddress> initOrder(String userId) {
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}

}
