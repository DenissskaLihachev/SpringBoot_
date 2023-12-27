package com.example.filmspringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Ganre;
    private String lastName;
    private String Rating;
    private String filmYear;
    public Film() {
    }

    public Film(String Ganre, String lastName, String Rating, String year) {
        this.Ganre = Ganre;
        this.lastName = lastName;
        this.Rating = Rating;
        this.filmYear = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGanre() {
        return Ganre;
    }

    public void setGanre(String Ganre) {
        this.Ganre = Ganre;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public String getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(String filmYear) {
        this.filmYear = filmYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) &&
                Objects.equals(Ganre, film.Ganre) &&
                Objects.equals(lastName, film.lastName) &&
                Objects.equals(Rating, film.Rating) &&
                Objects.equals(filmYear, film.filmYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Ganre, lastName, Rating, filmYear);
    }
}
