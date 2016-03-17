package com.example.callcenter.controller;

import com.example.callcenter.model.CityModel;
import com.example.callcenter.service.CityService;
import com.example.callcenter.service.StreetService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("street")
public class StreetController {

    @Autowired
    private CityService cityService;

    @Autowired
    private StreetService streetService;

    @RequestMapping("find")
    List<String> find(String city, String title) {
        if (StringUtils.isEmpty(city)) {
            return Collections.emptyList();
        }

        CityModel cityModel = cityService.findByTitle(city);
        if (cityModel == null) {
            return Collections.emptyList();
        }

        if (title == null) {
            title = StringUtils.EMPTY;
        }

        return streetService
                .findFirst50ByCityIdAndTitleStartingWithIgnoreCase(cityModel.getId(), title)
                .stream()
                .map(model -> model.getTitle())
                .collect(Collectors.toList());
    }

}
