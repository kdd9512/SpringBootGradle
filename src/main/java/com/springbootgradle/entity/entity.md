# Entity

* 실제 DB 테이블과 매칭될 class.  
  

* 이 class 내부에서 수정 및 추가 등의 작업으로 실제 DB 조작이  
  가능하다.

  
## 주요 Annotation

1. @Entity :  
   DB 의 Table 과 링크시킬 클래스.

2. @Table :  
   @Entity annotation 과 같이 사용하며, 작업하고자 하는 Table  
   을 지정한다.

3. @Id :  
   Table 내의 특정 키(Primary Key) 값에 해당하는 field 를 지정.

4. @GeneratedValue :  
   Primary Key 를 자동생성하고자 할 때 사용  
   (이를 키 생성 전략이라 한다)

        키 생성 전략 : 
        AUTO(default) - JPA 구현체(Boot 에서는 Hibernate) 가  
        생성방식을 결정.
        
        IDENTITY - 사용하는 DB 가 키 생성을 결정. 
            Oracle : 별도 번호를 위한 별도 테이블 생성.
            MySql/MariaDB : 기본으로 auto-increment 사용.  
            새 레코드가 기록될 때 마다 레코드번호를 자동증가시킴.
   
        SEQUENCE - DB sequence 를 이용하여 키를 생성.
        @SequenceGenerator 와 함께 사용.
   
        TABLE - 키 생성 전용 테이블을 생성하여 키 생성.
        @TableGenerator 와 함께 사용.

