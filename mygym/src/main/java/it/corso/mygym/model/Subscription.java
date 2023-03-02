package it.corso.mygym.model;


import it.corso.mygym.enums.SubscriptionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private SubscriptionType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;
    private boolean isPayed;





}
