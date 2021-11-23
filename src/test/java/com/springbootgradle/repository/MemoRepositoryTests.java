package com.springbootgradle.repository;

import com.springbootgradle.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    // insert
//    @Test
//    public void testInsertDummies(){
//        IntStream.rangeClosed(1,100).forEach(i -> {
//            Memo memo = Memo.builder().memoText("Sample..."+i).build();
//            memoRepository.save(memo);
//        });
//    }

    // find
//    @Test
//    public void testSelect() {
//        // 찾고자 하는 mno 를 정의. Long 값 100.
//        Long mno = 100L;
//
//        // SQL 처리 부분. 컬럼의 mno 로 검색한다.
//        Optional<Memo> result = memoRepository.findById(mno);
//
//        System.out.println("=============testSelect==============");
//
//        // 결과가 존재하는지를 check
//        if (result.isPresent()) {
//            Memo memo = result.get();
//            System.out.println(memo);
//        } else {
//            System.out.println("NO DATA");
//        }
//    }

    // find(using getOne()) ** deprecate 된 기능.
    // getOne 을 사용하려면 Transactional annotation 이 필요하다
    // (트랜잭션 처리가 필요함.)
    // 실제 객체가 사용되는 순간에 SQL 문이 작동한다.
    // 즉 경계선이 먼저 출력되고 SQL 문이 사용됨.
//    @Transactional
//    @Test
//    public void testGetOne() {
//        Long mno = 100L;
//
//        Memo result = memoRepository.getOne(mno);
//
//        System.out.println("=============testGetOne==============");
//
//        System.out.println(result);
//    }


    // update
    // insert 때와 같이 save() 를 이용.
    // 먼저 select 문으로 해당 값이 존재하는지를 찾고,
    // 이후 update 문으로 데이터를 갱신한다.
//    @Test
//    public void testUpdate(){
//        Memo memo = Memo.builder().mno(100L).memoText("Update Test").build();
//
//        System.out.println(memoRepository.save(memo));
//    }


    // delete
    // deleteById() 를 이용.
    // select 문으로 해당 컬럼의 존재여부 확인.
    // (없는 경우, EmptyResultDataAccessException 발생.)
    // 해당 조건에 맞는 컬럼 삭제.
//    @Test
//    public void testDelete(){
//        Long mno = 99L;
//
//        memoRepository.deleteById(mno);
//
//    }


    // 페이징 처리(p66).
    // Pageable 인터페이스를 사용한다.
    // Pageable 은 페이지 처리에 필요한 정보를 전달하는 역할을 한다.
    // 실제 객체를 구성할 때 에는 PageRequest 를 이용한다.
//    @Test
//    public void testPageDefault() {
    // PageRequest 는 protected 로 선언되어 있어 new 를 이용할 수 없기 때문에
    // 예시와 같이 .of() 를 이용해서 처리해야 한다.

    // 1 페이지 당 10개
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<Memo> result = memoRepository.findAll(pageable);
//        System.out.println(result);
//
//        System.out.println("==============================================");
//
//        // 총 페이지 수.
//        System.out.println("Total Pages : " + result.getTotalPages());
//
//        // 총 컬럼 개수.
//        System.out.println("Total Elements : " + result.getTotalElements());
//
//        // 현재 페이지 번호(0부터 시작함).
//        System.out.println("Current Pages : " + result.getNumber());
//
//        // 페이지 당 데이터 개수.
//        System.out.println("Page Size : " + result.getSize());
//
//        // 다음 페이지 존재여부
//        System.out.println("has next page ? : " + result.hasNext());
//
//        // 시작페이지(0 페이지) 여부.
//        System.out.println("is first page? : " + result.isFirst());
//
//        System.out.println("==============================================");
//
//        // 데이터 내용 추출.
//        for (Memo memo : result.getContent()) {
//            System.out.println(memo);
//        }
//    }

//    @Test
//    public void testSort() {
//
//        // .by("정렬기준")
//        Sort srt1 = Sort.by("mno").descending();
//        Sort srt2 = Sort.by("memoText").ascending();
//
//        // .and 를 이용하여 두 Sort 조건을 연결.
//        Sort srtAll = srt1.and(srt2);
//
//        Pageable pageable = PageRequest.of(0, 10, srtAll);
//
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        result.get().forEach(memo -> {
//            System.out.println(memo);
//        });
//    }


    // Query 메서드
//    @Test
//    public void testQueryMethods() {
//        List<Memo> list = memoRepository.
//        findByMnoBetweenOrderByMnoDesc(70L, 80L);
//
//        for (Memo memo : list) {
//            System.out.println(memo);
//        }
//    }

    // Query 문 + Pageable(PageRequest) 혼합.
//    @Test
//    public void testQueryMethodsWithPageable(){
//        // 기존 Query 메서드명에 OrderBy(조건) 와 Desc 를 작성하여 처리했던 부분을
//        // PageRequest.of() 에 담아 처리.
//        Pageable pageable = PageRequest.of(0,10,Sort.by("mno").descending());
//
//        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
//
//        // forEach 문으로 조건에 맞는 컬럼 전부출력.
//        result.get().forEach(memo -> {
//            System.out.println(memo);
//        });
//    }

//    // @Commit : 실제 DB 에 적용시키기 위한 Annotation.
//    @Commit
//    // @Transactional :
//    // 먼저 해당 값이 있는지 여부를 검색해야 할 때 반드시 필요한 Annotation.
//    @Transactional
//    @Test
//    public void testDeleteQueryMethods() {
//        memoRepository.deleteMemoByMnoLessThan(5L);
//    }

//    @Test
//    public void annotationQueryTest(){
//        List<Memo> list = memoRepository.getListDesc();
//
//        for (Memo memo : list) {
//            System.out.println(memo);
//        }
//    }

}
