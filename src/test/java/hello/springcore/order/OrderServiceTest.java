package hello.springcore.order;

import hello.springcore.entity.Grade;
import hello.springcore.entity.Member;
import hello.springcore.entity.Order;
import hello.springcore.service.MemberService;
import hello.springcore.service.MemberServiceImpl;
import hello.springcore.service.OrderService;
import hello.springcore.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
