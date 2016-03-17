package com.example.callcenter.repository;

import com.example.callcenter.model.CityModel;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CityRepository extends BaseRepository<CityModel> {

    List<CityModel> findFirst50ByTitleStartingWithIgnoreCase(String title, Sort sort);

    CityModel findByTitle(String title);
}
