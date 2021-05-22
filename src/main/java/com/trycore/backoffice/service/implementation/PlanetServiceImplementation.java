package com.trycore.backoffice.service.implementation;

import com.trycore.backoffice.dto.response.PlanetTop;
import com.trycore.backoffice.exceptions.planet.PlanetTopDontHaveThreeRecordsException;
import com.trycore.backoffice.model.Planet;
import com.trycore.backoffice.repository.PlanetRepository;
import com.trycore.backoffice.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetServiceImplementation implements PlanetService {

    public static int  DEFAULT_COUNTER_VALUE = 0;

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
    public List<PlanetTop> getTopPlanets() {
            List<PlanetTop> topPlanets = planetRepository.getTop3Planets()
                    .stream()
                    .map(this::convertToPlanetTop)
                    .collect(Collectors.toList());
            if(!confirmThatHaveTreeObjects(topPlanets)){
                throw PlanetTopDontHaveThreeRecordsException.of(topPlanets);
            }
            return topPlanets;
    }

    @Transactional
    @Override
    public Boolean createPlanet(Planet planet) {
        try{
            planetRepository.createPlanet(
                    planet.getNamePlanet(),
                    planet.getRotationPeriodPlanet(),
                    planet.getDiameterPlanet(),
                    planet.getWeatherPlanet(),
                    planet.getLandPlanet(),
                    DEFAULT_COUNTER_VALUE);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    @Transactional
    @Override
    public Boolean addOneCounterOnPlanet(Long id) {
        if(!isNotNull(id)){
            System.out.println("HERE I NEED CHANGE TO A NEW THROW ");
        }
        planetRepository.addOneCounterOnPlanet(id);
        return true;
    }

    private PlanetTop convertToPlanetTop (Planet planet){
        return new PlanetTop(
                planet.getIdPlanet(),
                planet.getNamePlanet()
        );
    }

    private Boolean confirmThatHaveTreeObjects(List<PlanetTop> planetTops){
        return planetTops.size() == 3;
        /*
        if(planetTops.size() != 3)
            return false;
        return true;
         */
    }

    private Boolean isNotNull (Long number){
        return !(number == null);
        /*
        if(number == null)
            return false;
        return true;
         */
    }

}
