package com.guiltypleausre.web.db;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

// @WebAppConfiguration 웹 프로젝트 설정까지도 다 가져다 쓰겠다. 스프링에서 제공하는 어노테이션
@WebAppConfiguration
// @RunWith spring안에서 junit이 실행될 수 있게 도와준다.
@RunWith(SpringJUnit4ClassRunner.class)
// @Context 설정 파일을 읽어오는 어노테이션, 별도의 모듈이다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	// 세터 메서드를 생략할 수 있다.(autowire 또는 injection)
	// 자동으로 인스턴스 생성은 @Test가 해준다.
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() throws Exception{
		try(Connection con = dataSource.getConnection()){
			System.out.println(con);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
