package com.springbootgradle.repository;

import com.springbootgradle.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// interface JpaRepository <@Entity 의 type 정보(여기서는 Memo class), @Id 의 type(private "Long" mno)>
public interface MemoRepository extends JpaRepository<Memo, Long> {

    // findBy(찾는조건)Between ? OrderBy(정렬할조건) Desc(내림) / Asc(오름)
    // Between ? : ( Long from(시작점), Long to(종료점) );
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    // 위에서 사용한대로 사용해도 무관하나 Page<> 를 이용하여 단축할 수 있는 방법이 있다.
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    // 컬럼 삭제를 위한 QUERY 문.
//    void deleteMemoByMnoLessThan(Long num);

    // JPQL 문.
    // select DB별칭 from @Entity이름 (as는 생략가능) DB 별칭 order by 별칭.기준 정렬기준(오름/내림)
    @Query("select asdf from Memo as asdf order by asdf.mno desc")
    List<Memo> getListDesc();

//    @Transactional
//    @Modifying
//    @Query("update Memo as asdf set asdf.memoText = :memoText where asdf.mno = :mno ")
//    int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);

    // updateMemoText 를 #{} 이용하여 간략화(jquery 에서 쓰던 그거. 자바 Bean 스타일을 활용).
    // Query 문이 지나치게 길어지는 것을 방지하기 위하여 사용한다.
    @Transactional
    @Modifying
    @Query("update Memo as asdf set asdf.memoText = :#{#param.memoText} where asdf.mno = :#{#param.mno}")
    int updateMemoText(@Param("param") Memo memo);

}
