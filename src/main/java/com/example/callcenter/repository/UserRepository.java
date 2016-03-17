package com.example.callcenter.repository;

import com.example.callcenter.model.UserModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends BaseRepository<UserModel> {
    @Query(
            value = "select t from #{#entityName} t join fetch t.street s join fetch s.city",
            countQuery = "select count(t) from UserModel t join t.street s join s.city"
    )
    Page<UserModel> findAll(Pageable pageable);
}
