package net.alttabber.myanimelistclone.entities;

import net.alttabber.myanimelistclone.data.AnimeTitleStatus;

import javax.persistence.*;

@Entity
public class AnimeTitleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="anime_title_id")
    private AnimeTitle animeTitle;

    private AnimeTitleStatus status;

    private String score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AnimeTitle getAnimeTitle() {
        return animeTitle;
    }

    public void setAnimeTitle(AnimeTitle animeTitle) {
        this.animeTitle = animeTitle;
    }

    public AnimeTitleStatus getStatus() {
        return status;
    }

    public void setStatus(AnimeTitleStatus status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
