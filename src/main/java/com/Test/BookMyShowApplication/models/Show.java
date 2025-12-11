package com.Test.BookMyShowApplication.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="bms_show")
public class Show extends BaseModel {
    private Date start_time;
    // Show M:1 Movie
    @ManyToOne
    private Movie movie;
    // Show M:1 Theatre
    @ManyToOne
    private Theatre theatre;
    // Show M:1 Screen
    @ManyToOne
    private Screen screen;
    // Show 1:M showSeat
    @OneToMany
    private List<ShowSeat> showSeatList;
    // SHow 1:M showSeatType
    @OneToMany
    private List<ShowSeatType> showSeatTypeList;

}
