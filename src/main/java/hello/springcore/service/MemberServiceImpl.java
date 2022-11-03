package hello.springcore.service;

import hello.springcore.entity.Member;
import hello.springcore.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memeberId) {
        return memberRepository.findById(memeberId);
    }
}
