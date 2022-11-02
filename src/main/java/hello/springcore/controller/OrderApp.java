package hello.springcore.controller;

import hello.springcore.entity.Grade;
import hello.springcore.entity.Member;
import hello.springcore.entity.Order;
import hello.springcore.service.MemberService;
import hello.springcore.service.MemberServiceImpl;
import hello.springcore.service.OrderService;
import hello.springcore.service.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calcuatePrice());
    }
}
