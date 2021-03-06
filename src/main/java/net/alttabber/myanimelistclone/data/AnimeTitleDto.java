package net.alttabber.myanimelistclone.data;

import java.util.Random;

public class AnimeTitleDto {

    private Long id;
    private String name;
    private String score;
    private String coverUrl;
    private AnimeTitleType type;
    private String description;
    private AnimeTitleStatus status;

    public AnimeTitleDto() {
        this.id = new Random().nextLong();
    }

    public AnimeTitleDto(String name, String score, String coverUrl, AnimeTitleType type, AnimeTitleStatus status) {
        this();
        this.name = name;
        this.score = score;
        this.coverUrl = coverUrl;
        this.type = type;
        this.status = status;
    }

    public AnimeTitleDto(Long id, String name, String score, String coverUrl, AnimeTitleType type, String description, AnimeTitleStatus status) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.coverUrl = coverUrl;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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
