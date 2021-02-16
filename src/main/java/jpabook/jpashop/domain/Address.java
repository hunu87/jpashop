package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable	// 다른 객체에 embed 될 클래스라는 의미
@Getter
public class Address {
	
	private String city;
	private String street;
	private String zipcode;
	
}
