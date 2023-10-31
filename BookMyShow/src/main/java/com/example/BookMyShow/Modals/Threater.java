package com.example.BookMyShow.Modals;

import com.example.BookMyShow.Enum.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "threaters")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Threater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer threaterId;

    private String threaterName;
    private String threaterAddress;

    @Enumerated(value = EnumType.STRING)
    private City threaterCity;

    @OneToMany(mappedBy = "threater",cascade = CascadeType.ALL)
    private List<Show> showList=new ArrayList<>();

    @OneToMany(mappedBy = "threater",cascade = CascadeType.ALL)
    private List<ThreaterSeats> threaterSeatsList=new ArrayList<>();
}
