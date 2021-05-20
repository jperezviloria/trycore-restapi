package com.trycore.backoffice.service;

import com.trycore.backoffice.model.Planet;

import java.util.List;

public interface PlanetService {

    List<Planet> getAllPlanets();

    Boolean createPlanet(Planet planet);

}
