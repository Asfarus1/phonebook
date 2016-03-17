package com.example.callcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "street")
public class StreetModel extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private CityModel city;

    @Column(name = "title", nullable = false)
    private String title;
}
