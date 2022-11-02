package hello.springcore.repository;

import hello.springcore.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
