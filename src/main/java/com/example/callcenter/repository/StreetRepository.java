package com.example.callcenter.repository;

import com.example.callcenter.model.StreetModel;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StreetRepository extends BaseRepository<StreetModel> {

    List<StreetModel> findFirst50ByCityIdAndTitleStartingWithIgnoreCase(Long cityId, String title, Sort sort);

    StreetModel findByCityIdAndTitle(Long id, String title);
}
