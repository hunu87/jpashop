package jpabook.jpashop;

import static org.junit.Assert.*;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	// @Rollback(false) 
	/* Test code에 @Transactional 어노테이션이 있는 경우에은 자동 롤백 함. 
	 * 진짜 insert Query를 보고 싶다면 @Rollback(false)라고 설정 하면 됨.
	 * */
	public void 회원가입() throws Exception {
		// given
		Member member = new Member();
		member.setName("kim");
		
		// when
		Long saveId = memberService.join(member);
		
		// then
		assertEquals(member, memberRepository.findOne(saveId));
	}
	
	@Test(expected = IllegalStateException.class)
	public void 중복_회원_예외() throws Exception {
		// given
		Member member1 = new Member();
		member1.setName("kim");
		
		Member member2 = new Member();
		member2.setName("kim");
		
		// when
		memberService.join(member1);
		memberService.join(member2);	
		
		// then
		// 여기까지 오는거라면 test 실패이다.
		fail("예외가 발생해야 한다.");
	}
	
}
