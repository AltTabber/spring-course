package net.alttabber.myanimelistclone.config;

import net.alttabber.myanimelistclone.service.PlanetService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Random;

@Configuration
public class PlanetConfiguration {

    private final String[] PLANETS = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus" };
    private static final Random random = new Random();

    @Bean
    public PlanetService getMarsService(){
        return new PlanetService("Mars");
    }

    @Bean("venusService")
    public PlanetService getVenusService(){
        return new PlanetService("Venus");
    }

    @Bean("randomPlanetService")
    @Scope("prototype")
    public PlanetService getRandomPlanetService(){
        int elemNumber = random.nextInt(PLANETS.length);
        return new PlanetService(PLANETS[elemNumber]);
    }

}
