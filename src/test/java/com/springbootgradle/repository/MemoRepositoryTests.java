package com.springbootgradle.repository;

import com.springbootgradle.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
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

    // find(using getOne())
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
    @Test
    public void testDelete(){
        Long mno = 99L;

        memoRepository.deleteById(mno);

    }

}
