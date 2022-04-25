package net.alttabber.myanimelistclone.data;

import java.util.Random;
import java.util.UUID;

public class AnimeTitle {

    private String id;
    private String name;
    private String description;

    public AnimeTitle() {
        this.id = Integer.toString(new Random().nextInt());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
