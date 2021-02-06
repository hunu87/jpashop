package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	
	@PersistenceContext
	private EntityManager entityManager;	// @PersistenceContext Annotation을 붙이면 알아서 Container에 주입 해준다.
	
	public Long save(Member member) {
		entityManager.persist(member);
		return member.getId();	// Command 와 Query를 분리 하라. => Member 객체 전체를 반환하지 말고, 생성된 Member의 id 정도만 반환
	}
	
	public Member find(Long id) {
		return entityManager.find(Member.class, id);
	}
	
}
