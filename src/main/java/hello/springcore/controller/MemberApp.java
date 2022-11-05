package hello.springcore.controller;

import hello.springcore.config.AppConfig;
import hello.springcore.entity.Grade;
import hello.springcore.entity.Member;
import hello.springcore.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        1. DIP, OCP 위반 / 직접 의존 관계 주입
//        MemberService memberService = new MemberServiceImpl();

//        2. AppConfig 를 통해 관심사 분리, DIP,OCP 준수 / 외부에서 의존 관계 주입
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        3. 스프링 컨테이너 사용, AppConfig 에서 수동 등록한 Bean 을 조회하여 사용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
        System.out.println(member == findMember);
    }
}
