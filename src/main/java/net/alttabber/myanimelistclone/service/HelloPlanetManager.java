package net.alttabber.myanimelistclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HelloPlanetManager {

    private PlanetService planetService;

    @Autowired
    public HelloPlanetManager(@Qualifier("randomPlanetService") PlanetService planetService) {
        this.planetService = planetService;
    }

    public void helloPlanet(){
        System.out.println("Hello " + planetService.getPlanet() + "!");
    }

}
