package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// lombok maven 를 이용하여 , getter setter constructor 를 annotation으로 비교적 쉽게 사용하도록 함 

@Getter
@Setter
@AllArgsConstructor
public class Customer {

	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;

}
