package com.csohb.first.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
// 보통 MyBatis등에서 Dao라고 불리는 DB Layer 접근자
/*
    인터페이스를 생성후 JpaRespositoty<Entity 클래스, PK타입>를 상속하면 기본적인
    CURD 메소드가 자동으로 생성됨
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
