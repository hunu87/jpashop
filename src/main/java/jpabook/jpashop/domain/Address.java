package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable	// 다른 객체에 embed 될 클래스라는 의미
@Getter
public class Address {
	
	private String city;
	private String street;
	private String zipcode;
	
	protected Address() {
	}
	
	// 값 타입 Entity는 멤버변수 값을 변경 못하도록 해야 함. 
	// @Setter는 막아두고 생성자 호출에 의한 값 세팅만 가능하도록 해서, 외부에서 값을 변경 못하도록 한다.
	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}

	
