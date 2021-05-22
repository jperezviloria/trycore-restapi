package com.trycore.backoffice.service;

import com.trycore.backoffice.dto.response.PlanetTop;
import com.trycore.backoffice.model.Planet;

import java.util.List;

public interface PlanetService {

    List<Planet> getAllPlanets();

    List<PlanetTop> getTopPlanets();

    Boolean createPlanet(Planet planet);

    Boolean addOneCounterOnPlanet(Long id);

}
