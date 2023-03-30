package com.m2cosentino.e71training.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.m2cosentino.e71training.domain.enumeration.Track;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Session.
 */
@Entity
@Table(name = "session")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "track", nullable = false)
    private Track track;

    @ManyToOne
    @JsonIgnoreProperties(value = { "sessions" }, allowSetters = true)
    private Conference conference;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Session id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Session name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Track getTrack() {
        return this.track;
    }

    public Session track(Track track) {
        this.setTrack(track);
        return this;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Conference getConference() {
        return this.conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Session conference(Conference conference) {
        this.setConference(conference);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Session)) {
            return false;
        }
        return id != null && id.equals(((Session) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Session{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", track='" + getTrack() + "'" +
            "}";
    }
}
