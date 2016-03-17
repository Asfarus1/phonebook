package com.example.callcenter.service;

import com.example.callcenter.model.CityModel;
import com.example.callcenter.repository.CityRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityService extends BaseService<CityModel, CityRepository> {

    private final Sort sort = new Sort(Sort.Direction.ASC, "title");

    public List<CityModel> findFirst50ByTitleStartingWithIgnoreCase(String title) {
        return getRepository().findFirst50ByTitleStartingWithIgnoreCase(title, sort);
    }

    public CityModel findByTitle(String title) {
        return getRepository().findByTitle(title);
    }
}
