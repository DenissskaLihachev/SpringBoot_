package com.example.filmspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FilmControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllFilms() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/films")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFilmById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/films/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFilmByLastName() throws Exception {
        String lastName = "DEMO";
        mockMvc.perform(MockMvcRequestBuilders.get("/films/find")
                        .param("lastname", lastName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddFilm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/films")
                        .content("{ \"ganre\": \"GANRE\", \"lastName\": \"NAME\", \"rating\": \"10\", \"filmYear\": \"2023\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateFilm() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.put("/films/" + id)
                        .content("{ \"ganre\": \"horro\", \"lastName\": \"FILM\", \"Rating\": \"10\", \"filmYear\": \"1999\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteFilm() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/films/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}