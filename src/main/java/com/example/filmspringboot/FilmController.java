package com.example.filmspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {

        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getAllFilms() {

        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {

        return filmService.getFilmById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Film> findFilmByLastName(@RequestParam(name="lastname") String lastName) {
        return filmService.findFilmsByLastName(lastName);
    }

    @PostMapping
    public void addFilm(@RequestBody Film film) {
        filmService.addFilm(film);
    }

    @PutMapping("/{id}")
    public void updateFilm(@PathVariable Long id, @RequestBody Film film) {
        film.setId(id);
        filmService.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(
            @PathVariable Long id) {
        filmService.deleteFilm(id);
    }
}