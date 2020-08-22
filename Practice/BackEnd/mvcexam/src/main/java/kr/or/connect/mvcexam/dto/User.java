package kr.or.connect.mvcexam.dto;

public class User {
	private String name;      //form 태그에 매핑한 name 값과 변수명이 일치해야 한다(왜냐하면 스프링이 자동으로 생성해주는 것이니까)
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
	private String email;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
