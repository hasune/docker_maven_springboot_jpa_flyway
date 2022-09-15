package com.hasune.springjpa.repository;

import com.hasune.springjpa.domain.TeacherEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {

    // 이렇게 쿼리를 사용할 수도있다. JPQL은 SQL로 변환되어 실행된다.
    @Query(value = "SELECT DISTINCT teacher FROM TeacherEntity teacher WHERE teacher.name LIKE :name")
    Optional<TeacherEntity> findByName(@Param("name") String name);

}