package hello.springcore.repository;

import hello.springcore.entity.Member;

public class DbMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {

    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }
}
