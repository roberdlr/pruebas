package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Gnome entity.
 */
public class GnomeDTO implements Serializable {

    private Long id;

    private String name;

    private String thumbnail;

    private Float weight;

    private Float height;

    private String hair_color;

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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GnomeDTO gnomeDTO = (GnomeDTO) o;
        if (gnomeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), gnomeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GnomeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", thumbnail='" + getThumbnail() + "'" +
            ", weight=" + getWeight() +
            ", height=" + getHeight() +
            ", hair_color='" + getHair_color() + "'" +
            "}";
    }
}
