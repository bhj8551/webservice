package com.hong.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// MyBatis 에서는 Dao라고 불리는 DB Layer 접근자, JPA에서는 Repository라고 부른다.
// JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동 생성
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다! => 함께 관리
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
