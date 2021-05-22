package com.trycore.backoffice.repository;

import com.trycore.backoffice.dto.response.PlanetTop;
import com.trycore.backoffice.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    String queryGetAllPlanets = "SELECT * FROM PLANET ;";
    @Query(value = queryGetAllPlanets, nativeQuery = true)
    List<Planet> getAllPlanets();

    String queryGetTop3Planets = "SELECT TOP 3 * FROM PLANET ORDER BY COUNTER DESC ;";
    @Query(value = queryGetTop3Planets, nativeQuery = true)
    List<Planet> getTop3Planets();

    String queryCreatePlanet = "INSERT INTO Planet (NAME, ROTATION_PERIOD, DIAMETER, WEATHER, LAND, COUNTER) " +
            "VALUES ( :name , :rotationPeriod , :diameter , :weather , :land , :counter );";
    @Modifying
    @Query(value = queryCreatePlanet, nativeQuery = true)
    void createPlanet(
            @Param("name") String name,
            @Param("rotationPeriod") int rotationPeriod,
            @Param("diameter") int diameter,
            @Param("weather") String weather,
            @Param("land") String land,
            @Param("counter") int counter
    );

    String queryAddOneCounterOnPlanet = "UPDATE Planet SET COUNTER = COUNTER + 1 WHERE ID = :id ;";
    @Modifying
    @Query(value = queryAddOneCounterOnPlanet, nativeQuery = true)
    void addOneCounterOnPlanet (
            @Param("id") Long id);

}
