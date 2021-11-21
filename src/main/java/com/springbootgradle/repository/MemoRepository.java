package com.springbootgradle.repository;

import com.springbootgradle.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

// interface JpaRepository <@Entity 의 type 정보(여기서는 Memo class), @Id 의 type(private "Long" mno)>
public interface MemoRepository extends JpaRepository<Memo, Long> {

}
