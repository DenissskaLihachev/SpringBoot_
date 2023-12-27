package com.example.filmspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FilmRepositoryTests {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void testFindByLastNameIgnoreCase() {
        Film film = new Film("Comedy", "It", "10", "2015");
        filmRepository.save(film);

        List<Film> retrievedFilms = filmRepository.findByLastNameIgnoreCase("It");

        assertEquals(1, retrievedFilms.size(), "Ожидается фильм с указаным название");
        assertEquals(film.getLastName(), retrievedFilms.get(0).getLastName());
    }
}