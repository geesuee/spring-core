package hello.springcore.controller;

import hello.springcore.config.AppConfig;
import hello.springcore.entity.Grade;
import hello.springcore.entity.Member;
import hello.springcore.entity.Order;
import hello.springcore.service.MemberService;
import hello.springcore.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calcuatePrice());
    }
}
