package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Gnome.
 */
@Entity
@Table(name = "gnome")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Gnome implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "hair_color")
    private String hair_color;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "GNOME_GNOME", joinColumns = {
		@JoinColumn(name = "ID_GNOME1", nullable = false, updatable = false)
	}, inverseJoinColumns = {
		@JoinColumn(name = "ID_GNOME2", nullable = false, updatable = false)
	})
	private Set<Gnome> gnomes = new HashSet<Gnome>(0);
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "GNOME_GNOME", joinColumns = {
		@JoinColumn(name = "ID_GNOME2", nullable = false, updatable = false)
	}, inverseJoinColumns = {
		@JoinColumn(name = "ID_GNOME1", nullable = false, updatable = false)
	})
	private Set<Gnome> gnomesInverse = new HashSet<Gnome>(0);
    
    @OneToMany(mappedBy="id.gnome")
    private List<GnomeProfession> gnomeProfessions;
    
    public Set<Gnome> getGnomes() {
		return gnomes;
	}

	public void setGnomes(Set<Gnome> gnomes) {
		this.gnomes = gnomes;
	}

	public Set<Gnome> getGnomesInverse() {
		return gnomesInverse;
	}

	public void setGnomesInverse(Set<Gnome> gnomesInverse) {
		this.gnomesInverse = gnomesInverse;
	}

	public List<GnomeProfession> getGnomeProfessions() {
		return gnomeProfessions;
	}

	public void setGnomeProfessions(List<GnomeProfession> gnomeProfessions) {
		this.gnomeProfessions = gnomeProfessions;
	}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Gnome name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Gnome thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Float getWeight() {
        return weight;
    }

    public Gnome weight(Float weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public Gnome height(Float height) {
        this.height = height;
        return this;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getHair_color() {
        return hair_color;
    }

    public Gnome hair_color(String hair_color) {
        this.hair_color = hair_color;
        return this;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gnome gnome = (Gnome) o;
        if (gnome.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), gnome.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Gnome{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", weight=" + getWeight() +
            ", height=" + getHeight() +
            ", hair_color='" + getHair_color() + "'" +
            "}";
    }
}
