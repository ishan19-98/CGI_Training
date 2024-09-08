package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dao.OrderRepository;
import com.entity.Orders;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProductFeignService productFeignService;

	public String createOrder(Orders order)
	{
		Optional<Orders> result = orderRepository.findById(order.getId());
		if(result.isPresent())
		{
			return "Order with Given Id Already Exists";
		}
		else
		{
			String userName=restTemplate.getForObject("http://USER-SERVICE/users/"+order.getUserid(), String.class);
			if(userName!=null)
			{
				String res = productFeignService.findProductById(order.getProductid());
				if(res!=null)
				{
				orderRepository.save(order);
				return "Order created successfully";
				}
				else
				{
					return "Product with given product id doesnot exists";
				}
			}
			else
			{
				return "Order cannot be placed as User doesnot exists";
			}
				
		}
		
		
	}
	
	public List<Orders> findAllOrders()
	{
		List<Orders> orders = orderRepository.findAll();
		return orders;
	}
	
	public Optional<Orders> findOrderById(int id)
	{
		Optional<Orders> order = orderRepository.findById(id);
		if(order.isPresent())
		{
			return order;
		}
		return null;
	}
}