package com.trycore.backoffice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Planet")
public class Planet {

    @Id
    @Column(name = "id")
    private Long idPlanet;

    @Column(name = "name")
    private String namePlanet;

    @Column(name = "rotation_period")
    private int rotationPeriodPlanet;

    @Column(name = "diameter")
    private int diameterPlanet;

    @Column(name = "weather")
    private int weatherPlanet;

    @Column(name = "land")
    private String landPlanet;

    @Column(name = "counter")
    private int counterPlanet;

    public Planet(Long idPlanet,
                  String namePlanet,
                  int rotationPeriodPlanet,
                  int diameterPlanet,
                  int weatherPlanet,
                  String landPlanet,
                  int counterPlanet) {
        this.idPlanet = idPlanet;
        this.namePlanet = namePlanet;
        this.rotationPeriodPlanet = rotationPeriodPlanet;
        this.diameterPlanet = diameterPlanet;
        this.weatherPlanet = weatherPlanet;
        this.landPlanet = landPlanet;
        this.counterPlanet = counterPlanet;
    }

}
