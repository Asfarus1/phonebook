package com.example.callcenter.service;

import com.example.callcenter.model.BaseModel;
import com.example.callcenter.repository.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseService<M extends BaseModel, R extends BaseRepository<M>> {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private R repository;

    public final M findOne(Long id) {
        return getRepository().findOne(id);
    }

    public final Page<M> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public final List<M> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    public final boolean save(M model) {
        try {
            getRepository().save(model);
            return true;
        } catch (Exception e) {
            log.error("Failed to save \n {} \n {}", model, e);
            return false;
        }
    }

    public final boolean delete(M model) {
        try {
            getRepository().delete(model);
            return true;
        } catch (Exception e) {
            log.error("Failed to delete \n {} \n {}", model, e);
            return false;
        }
    }
}
