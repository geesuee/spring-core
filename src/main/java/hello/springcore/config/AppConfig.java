package hello.springcore.config;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.repository.MemberRepository;
import hello.springcore.repository.MemoryMemberRepository;
import hello.springcore.service.MemberService;
import hello.springcore.service.MemberServiceImpl;
import hello.springcore.service.OrderService;
import hello.springcore.service.OrderServiceImpl;

public class AppConfig {    // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성

    // 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) = 의존 관계 주입, 생성자 주입
    // 클라이언트 객체 내에서 구현체를 의존하지 않음, 클라이언트 객체는 인터페이스에만 의존
    // *생성자를 통해 어떤 구현 객체를 주입할 지는 외부(AppConfig)에서 결정 => 의존 관계 주입(DI)
    // *의존 관계는 외부에 맡기고, 클라이언트는 실행에만 집중! => DIP 완성
    // *관심사의 분리 : 객체를 생성하고 연결하는 역할, 실행하는 역할 분리

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
