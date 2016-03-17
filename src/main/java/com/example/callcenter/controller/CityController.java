package com.example.callcenter.controller;

import com.example.callcenter.service.CityService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("find")
    List<String> find(String title) {
        if (title == null) {
            title = StringUtils.EMPTY;
        }

        return cityService
                .findFirst50ByTitleStartingWithIgnoreCase(title)
                .stream()
                .map(model -> model.getTitle())
                .collect(Collectors.toList());
    }

}
