package net.alttabber.myanimelistclone.entities;

import net.alttabber.myanimelistclone.data.AnimeTitleStatus;
import net.alttabber.myanimelistclone.data.AnimeTitleType;

import javax.persistence.*;

@Entity
public class AnimeTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 800)
    private String description;

    @ManyToOne
    @JoinColumn(name="image_id")
    private Image image;

    private String score;

    private AnimeTitleType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public AnimeTitleType getType() {
        return type;
    }

    public void setType(AnimeTitleType type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
