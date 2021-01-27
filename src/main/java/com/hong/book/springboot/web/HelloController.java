package com.hong.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
@RestController
public class HelloController {
    // HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
    // 예전에는 RequestMapping 사용
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}