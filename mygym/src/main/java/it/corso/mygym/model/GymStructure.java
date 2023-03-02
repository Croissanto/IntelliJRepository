package it.corso.mygym.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class GymStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String address;
    private String email;
    private String pIva;
    @OneToMany
    private List<Subscription> availableSubscriptions;

}
