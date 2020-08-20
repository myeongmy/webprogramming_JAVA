package kr.or.connect.diexam01;

public class UserBean {
/*
 * 1) 기본 생성자를 가지고 있따.
 * 2) 필드는 private 하게 선언한다.
 * 3) getter, setter 메소드를 가진다. getName() setName() 메소드를 name property라고 부른다. (용어 중요)
 * 
 * 왜 이런 규칙을 가지고 있을까? 해당 객체를 내가 생성하는 것이 아닌 다른 컨테이너에게 맡길 것이니까 규칙이 있다.
 */
	
	private String name;
	private int age;
	private boolean male;
	
	public UserBean() {
		
	}
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
}
