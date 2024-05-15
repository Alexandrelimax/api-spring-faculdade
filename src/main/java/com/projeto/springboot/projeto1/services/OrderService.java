package com.projeto.springboot.projeto1.services;

import com.projeto.springboot.projeto1.entities.Order;
import com.projeto.springboot.projeto1.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveProduct(Order product){
        return orderRepository.save(product);
    }

    public Order updateOrder(Integer id, Order order){
        Order orderDatabase = this.getOrderById(id);
        if(orderDatabase != null){
            orderDatabase.setOrderDate(order.getOrderDate());
            return this.saveProduct(orderDatabase);

        }else{
            return null;
        }
    }
    public Boolean deleteProductById(Integer id){
        Order orderDatabase = this.getOrderById(id);
        if(orderDatabase != null){
            orderRepository.delete(orderDatabase);
            return true;
        }else{
            return false;
        }
    }
}
