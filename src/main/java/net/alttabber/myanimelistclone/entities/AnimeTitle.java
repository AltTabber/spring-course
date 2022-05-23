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

    private String coverUrl;

    private String score;

    private AnimeTitleType type;

    private AnimeTitleStatus status;

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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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

    public AnimeTitleStatus getStatus() {
        return status;
    }

    public void setStatus(AnimeTitleStatus status) {
        this.status = status;
    }
}
