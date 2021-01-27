package com.hong.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 주요 어노테이션을 클래스에 가깝게
@Getter // getter 메소드 자동생성
@NoArgsConstructor // 기본 생성자 추가
// 테이블과 링크될 클래스임을 나타냄, 언더스코어 네이밍으로 테이블 이름을 매칭 | 절대 setter 메소드를 만들지 않는다.
@Entity
// 실제 DB의 테이블과 매칭될 클래스 => Entity클래스
public class Posts {
    
    @Id // 해당 테이블의 PK 필드를 나타낸다. (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙 GenerationType.IDENTITY 추가해야 auto_increment가능
    private Long id; // Long 추천

    // 테이블의 칼럼을 나타낸다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래서 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
