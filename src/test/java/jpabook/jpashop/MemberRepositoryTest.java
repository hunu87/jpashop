package jpabook.jpashop;

import org.junit.runner.RunWith;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;
	
	@Test
	@Transactional	// @Transactional Annotation이 Test Class에 존재 하면 알아서 Data를 Rollback 함. (반복적인 Test를 하기 위해서)
	@Rollback(false)	//@Rollback(false) : Rollback 하지 않음
	void testMember() throws Exception {
		// given
		Member member = new Member();
		member.setUsername("memberA");
		
		// when
		Long saveId = memberRepository.save(member);
		Member findMember = memberRepository.find(saveId);
		
		// then
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		
		Assertions.assertThat(findMember).isEqualTo(member);	// JPA는 동일한 영속성 컨텍스트 안에서 값을 꺼내기 때문에 동일하다고 볼수 있음. findMeber 객체는 1차 캐시에서 꺼내진거임.
		System.out.println("findMember == member: " + (findMember == member));
	}

}