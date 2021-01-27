// main 클래스
package com.hong.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트의 자동 설정, Bean 읽기 생성 자동 설정
// @SpringBootApplication이 있는 위치부터 설정을 읽기 때문에 프로젝트의 최상단에 위치해야만 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS (웹 애플리케이션 서버) 실행
        // 당장은 톰켓 설치 필요x, jar 파일로 실행
        SpringApplication.run(Application.class, args);
    }
}
