package it.corso.mygym.model;


import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDay;
    private boolean isCertifiedMedically;
    @OneToMany
    private List<Subscription> subscriptionList;



}
