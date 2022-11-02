package hello.springcore.service;

import hello.springcore.entity.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memeberId);
}
