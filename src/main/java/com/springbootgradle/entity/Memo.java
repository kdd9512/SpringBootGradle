package com.springbootgradle.entity;

import lombok.*;

import javax.persistence.*;

// Java 객체 생성을 위한 @Entity annotation.
@Entity

// DB 상에 같은 테이블이 없어서 발생하는 오류. (구동에 지장은 없음.)
// 설정 -> 검사 -> 어노테이션에서 미해결 데이터베이스 참조 체크 해제로 무시가능.
@Table(name = "entity_test_memo")
@ToString

// (Lombok) Getter 메서드 생성.
@Getter

// (Lombok) 객체를 생성.
@Builder

// (Lombok) 이하 2개의 annotation 은 항상 @Builder 와 같이 사용한다.
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    // Table 내의 특정 키(Primary Key) 값에 해당하는 field 를 지정한다.
    @Id
    // Primary Key 값을 자동생성한다.
    // 키 생성 전략(strategy)은 GenerationType.IDENTITY 를 이용한다.
    // MariaDB 를 사용하고 있으므로, auto-increment 가 자동 적용될 것이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    // 생성된 entity_test_memo 테이블에 이하와 같은 조건으로 컬럼을 생성한다.
    @Column(length = 200,nullable = false)
    private String memoText;

    // 컬럼으로 생성되지 않는 field 의 경우는, @Transient 를 적용한다.

}
