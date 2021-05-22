package com.trycore.backoffice.exceptions.planet;

import com.trycore.backoffice.dto.response.PlanetTop;

import java.util.List;

public class PlanetTopDontHaveThreeRecordsException extends RuntimeException {

    private static int NUMBER_OF_TOP_PLANETS = 3;

    public static PlanetTopDontHaveThreeRecordsException of(List<PlanetTop> planetTop){
        return new PlanetTopDontHaveThreeRecordsException(planetTop);
    }

    public PlanetTopDontHaveThreeRecordsException(String message) {
        super(message);
    }

    private PlanetTopDontHaveThreeRecordsException(List<PlanetTop> planetTop){
        super(String.format("The top Planets should be a list with %d planet",
                NUMBER_OF_TOP_PLANETS));
    }
}
