package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	
	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id;
	
	private String name;
	
	@Embedded	// embbedded 객체
	private Address address;
	
	@OneToMany(mappedBy = "member")	// 읽기 전용이라는 의미 (양방향 관계인 경우 설정 해야함)
	private List<Order> orders = new ArrayList<>();
	
}
