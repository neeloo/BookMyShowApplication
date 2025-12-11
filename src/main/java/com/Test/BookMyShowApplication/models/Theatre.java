package com.Test.BookMyShowApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    // Theatre M:1 Region
    @ManyToOne
    private Region region;
}

