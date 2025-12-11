package com.Test.BookMyShowApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
    private String city;
    @OneToMany(mappedBy = "region")
    private List<Theatre> theatres;
}
