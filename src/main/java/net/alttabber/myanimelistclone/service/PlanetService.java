package net.alttabber.myanimelistclone.service;

public class PlanetService {

    private String planetName;

    public PlanetService(String planetName) {
        if(planetName == null){
            this.planetName = "Earth";
        }else{
            this.planetName = planetName;
        }

    }

    public String getPlanet(){
        return planetName;
    }

}
