package com.Test.BookMyShowApplication.models;

import com.Test.BookMyShowApplication.models.Enums.Language;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Movie extends  BaseModel {
    private String name;
    private String genre;
    private int run_time_mins;

    @ElementCollection
    private List<String> actors;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
}
