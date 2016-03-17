package com.example.callcenter.repository;

import com.example.callcenter.model.BaseModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<M extends BaseModel> extends JpaRepository<M, Long>, JpaSpecificationExecutor<M> {
}
