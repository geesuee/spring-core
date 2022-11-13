package hello.springcore.controller;

import hello.springcore.config.AppConfig;
import hello.springcore.entity.Grade;
import hello.springcore.entity.Member;
import hello.springcore.entity.Order;
import hello.springcore.service.MemberService;
import hello.springcore.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        1. DIP, OCP 위반 / 직접 의존 관계 주입
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

//        2. AppConfig 를 통해 관심사 분리, DIP,OCP 준수 / 외부에서 의존 관계 주입
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        3. 스프링 컨테이너 사용, AppConfig 에서 수동 등록한 Bean 을 조회하여 사용
//        Spring Container = BeanFactory + ApplicationContext 이지만, BeanFactory 를 직접 사용하는 경우는 거의 없어 Spring Container = ApplicationContext 라고 부르는 것이 일반적
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calcuatePrice());
    }
}
