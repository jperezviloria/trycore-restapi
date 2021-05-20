package com.trycore.backoffice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    private int idPerson;

    @Column(name = "name")
    private String namePerson;

    @Column(name = "age")
    private int agePerson;

    @Column(name = "height")
    private int heightPerson;

    @Column(name = "weight")
    private int weightPerson;

    @Column(name = "gender")
    private String genderPerson;

    @Column(name = "birth")
    private Instant birthPerson;

    @Column(name = "id_planet")
    private int idPlanet;

    @Column(name = "counter")
    private int counterPerson;

    public Person(int idPerson,
                  String namePerson,
                  int agePerson,
                  int heightPerson,
                  int weightPerson,
                  String genderPerson,
                  Instant birthPerson,
                  int idPlanet,
                  int counterPerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.agePerson = agePerson;
        this.heightPerson = heightPerson;
        this.weightPerson = weightPerson;
        this.genderPerson = genderPerson;
        this.birthPerson = birthPerson;
        this.idPlanet = idPlanet;
        this.counterPerson = counterPerson;
    }
}
