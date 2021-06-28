package com.csohb.first.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // JPA의 어노테이션
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 규칙을 나타냄
    private Long id;
    
    /*
        @Column : 테이블의 칼럼을 나타내며, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다. 
        사용목적 : 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
     */
    @Column(length = 500, nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    
    /*
        Entity 클래스에는 Setter 메소드 없음
        -> 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것
        생성 시점에 값을 채워주는 역할
     */

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
