package com.example.dao;

import com.example.model.Order;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDao {

    @Autowired
    UserDAO userDAO;

    private List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init(){
        List<User> users = userDAO.getUsers();

        orders.add(new Order(0, 10, "Test1", users.get(3)));
        orders.add(new Order(1, 50, "Test2", users.get(1)));
        orders.add(new Order(2, 34, "Test3", users.get(0)));
        orders.add(new Order(3, 4, "Test4", users.get(2)));
    }

    public List<Order> getOrders() {return orders;}
}
