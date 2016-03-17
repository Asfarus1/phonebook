package com.example.callcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "city")
public class CityModel extends BaseModel {
    @Column(name = "title", nullable = false)
    private String title;
}
