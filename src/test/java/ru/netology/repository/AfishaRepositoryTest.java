package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

    private Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    private Movie second = new Movie(2, "Ahead", "http://", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    private Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    private Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    private Movie sixth = new Movie(6, "Trolls", "http://", "cartoon");
    private Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    private Movie eighth = new Movie(8, "Horror1", "http://", "actionMovie");
    private Movie ninth = new Movie(9, "Horror2", "http://", "actionMovie");
    private Movie tenth = new Movie(10, "Horror3", "http://", "actionMovie");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);

    }


    @Test
    void mustFindAll() {
        repository.findAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,};
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustSave() {
        Movie movieToAdd = new Movie(12, "NumberSix", "http://", "horrors");
        repository.save(movieToAdd);
        Movie[] actual = repository.findAll();
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,
                new Movie(12, "NumberSix", "http://", "horrors")

        };

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        Movie actual = repository.findById(5);
        Movie expected = new Movie(5, "InvisibleMan", "http://", "horrors");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindInvalidId() {
        Movie actual = repository.findById(100);
        Movie expected = null;
        assertEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        repository.removeById(5);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, sixth, seventh, eighth, ninth, tenth,
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }


}