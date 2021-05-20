package com.trycore.backoffice.controller;

import com.trycore.backoffice.dto.response.RestResponse;
import com.trycore.backoffice.model.Planet;
import com.trycore.backoffice.service.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planet")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/api/getall")
    public RestResponse<List<Planet>> getAllPlanets(){
        List<Planet> allPlanets = planetService.getAllPlanets();
        return new RestResponse<>(HttpStatus.OK, allPlanets);
    }

    @PostMapping("/api/create")
    public RestResponse<Planet> createPlanet(@RequestBody Planet planet){
        try{
            Boolean isCreated = planetService.createPlanet(planet);
            if(isCreated){
                return new RestResponse<>(HttpStatus.CREATED, planet);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return new RestResponse<>(HttpStatus.BAD_REQUEST, "Can`t be created");
    }
}
