package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "gnome_profession")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GnomeProfession implements Serializable{

	public GnomeProfession() {
		
	}
	
	public GnomeProfession(Gnome gnome, Profession profession) {
		this.id = new GnomeProfessionId(gnome, profession);
	}
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private GnomeProfessionId id = new GnomeProfessionId();
	
	@Column(name = "active")
    private Boolean active;

	public GnomeProfessionId getId() {
		return id;
	}

	public void setId(GnomeProfessionId id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GnomeProfession e = (GnomeProfession) o;
        if (e.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), e.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
