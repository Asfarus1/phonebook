package com.example.callcenter.service;

import com.example.callcenter.model.StreetModel;
import com.example.callcenter.repository.StreetRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StreetService extends BaseService<StreetModel, StreetRepository> {

    private final Sort sort = new Sort(Sort.Direction.ASC, "title");

    public List<StreetModel> findFirst50ByCityIdAndTitleStartingWithIgnoreCase(Long cityId, String title) {
        return getRepository().findFirst50ByCityIdAndTitleStartingWithIgnoreCase(cityId, title, sort);
    }

    public StreetModel findByCityIdAndTitle(Long id, String title) {
        return getRepository().findByCityIdAndTitle(id, title);
    }
}
