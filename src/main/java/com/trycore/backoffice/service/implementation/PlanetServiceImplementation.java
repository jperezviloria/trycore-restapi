package com.trycore.backoffice.service.implementation;

import com.trycore.backoffice.model.Planet;
import com.trycore.backoffice.repository.PlanetRepository;
import com.trycore.backoffice.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlanetServiceImplementation implements PlanetService {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetServiceImplementation(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepository.getAllPlanets();
    }

    @Override
    public Boolean createPlanet(Planet planet) {
        try{
            planetRepository.createPlanet(
                    planet.getNamePlanet(),
                    planet.getRotationPeriodPlanet(),
                    planet.getDiameterPlanet(),
                    planet.getWeatherPlanet(),
                    planet.getLandPlanet(),
                    planet.getCounterPlanet());

            return true;
        }catch (Exception e){
            return false;
        }

    }

}
