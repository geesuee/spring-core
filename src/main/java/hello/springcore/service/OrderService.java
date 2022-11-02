package hello.springcore.service;

import hello.springcore.entity.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
