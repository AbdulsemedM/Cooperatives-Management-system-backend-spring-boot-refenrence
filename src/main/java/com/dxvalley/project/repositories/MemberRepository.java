package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberByMemberId(Long memberId);
    List<Member> findMemberByUnion(Unions union);
    List<Member> findMemberByUnionAndGender(Unions union,String geneder);
    List<Member> findMemberByPrCooperativeAndGender(PrCooperative prCooperative,String gender);
    List<Member> findMemberByPrCooperative(PrCooperative prCooperative);
}
