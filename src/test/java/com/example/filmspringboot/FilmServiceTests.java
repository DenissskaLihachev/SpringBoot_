package com.example.filmspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FilmServiceTests {

	@Autowired
	private FilmService filmService;

	@MockBean
	private FilmRepository filmRepository;

	@Test
	public void testGetAllFilms() {
		List<Film> films = new ArrayList<>();
		films.add(new Film("Никита", "Мисюркеев", "Вячеславович", "Б761-2"));
		films.add(new Film("Алексей", "Хохряков", "Петрович", "М573"));

		when(filmRepository.findAll()).thenReturn(films);

		List<Film> retrievedFilms = filmService.getAllFilms();
		assertEquals(2, retrievedFilms.size(), "Expected 2 films");
		System.out.println("Retrieved films: " + retrievedFilms);
	}

	@Test
	public void testGetFilmById() {
		Long id = 1L;
		Film film = new Film("Никита", "Мисюркеев", "Вячеславович", "Б761-2");
		film.setId(id);

		when(filmRepository.findById(id)).thenReturn(Optional.of(film));

		assertEquals(film, filmService.getFilmById(id).orElse(null));
	}

	@Test
	public void testAddFilm() {
		Film film = new Film("Никита", "Мисюркеев", "Вячеславович", "Б761-2");

		filmService.addFilm(film);

		verify(filmRepository, times(1)).save(film);
	}

	@Test
	public void testUpdateFilm() {
		Long id = 1L;
		Film film = new Film("Изменено", "Изменено", "Изменено", "Б761-2");
		film.setId(id);

		filmService.updateFilm(film);

		verify(filmRepository, times(1)).save(film);
	}

	@Test
	public void testDeleteFilm() {
		Long id = 1L;

		filmService.deleteFilm(id);

		verify(filmRepository, times(1)).deleteById(id);
	}

	@Test
	public void testFindFilmsByLastName() {
		String lastName = "Spider-Man";
		List<Film> films = new ArrayList<>();
		films.add(new Film("Fantasy", "Spider-Man", "999", "2012"));

		when(filmRepository.findByLastNameIgnoreCase(lastName)).thenReturn(films);

		assertEquals(1, filmService.findFilmsByLastName(lastName).size());
	}
}
