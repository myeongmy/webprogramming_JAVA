package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //여기가 Configuration에 관한 클래스임을 명시해주는 어노테이션
public class ApplicationConfig {
	@Bean    //bean 객체를 메소드 형식으로 생성해서 자바 사용자가 이해하기 더욱 쉽다.
	public Car car(Engine e) {
		Car c = new Car();
		//c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		Engine e = new Engine();
		return e;
	}
}
