package com.hong.book.springboot;

import com.hong.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

// 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@RunWith(SpringRunner.class)
// 스프링 테스트 어노테이션 중 Spring MVC에 집중할 수 있는 어노테이션
// @Controller, @ControllerAdvice 사용 가능
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    // 스프링이 관리하는 빈을 주입 받는다.
    @Autowired
    // 웹 API를 테스트, 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 HTTP, GET, POST 등에 대한 API테스트 가능
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        
        // HTTP GET 요청, 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
        mvc.perform(get("/hello"))
                // HTTP Header의 Status를 검증 하는데 OK 즉 200 인지 아닌지 검증
                .andExpect(status().isOk())
                // 본문의 내용이 "hello"를 리턴 하는지 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                    .param("name", name) // API 테스트할 때 사용될 요청 파라미터 설정 String만 허용
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // JSON 응답값을 필드별로 검증. $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
