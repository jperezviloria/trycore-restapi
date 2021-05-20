package com.trycore.backoffice.repository;

import com.trycore.backoffice.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    String queryGetAllPlanets = "SELECT * FROM Planet ;";
    @Query(value = queryGetAllPlanets, nativeQuery = true)
    List<Planet> getAllPlanets();

    String queryCreatePlanet = "INSERT INTO Planet (NAME, ROTATION_PERIOD, DIAMETER, WEATHER, LAND, COUNTER) " +
            "VALUES ( :name , :rotationPeriod , :diameter , :weather , :land , :counter );";
    @Query(value = queryCreatePlanet, nativeQuery = true)
    void createPlanet(
            @Param("name") String name,
            @Param("rotationPeriod") int rotationPeriod,
            @Param("diameter") int diameter,
            @Param("weather") int weather,
            @Param("land") String land,
            @Param("counter") int counter
    );


}
