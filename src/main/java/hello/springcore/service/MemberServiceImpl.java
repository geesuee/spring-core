package hello.springcore.service;

import hello.springcore.entity.Member;
import hello.springcore.repository.MemberRepository;
import hello.springcore.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memeberId) {
        return memberRepository.findById(memeberId);
    }
}
