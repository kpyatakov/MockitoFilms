package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager();
    private Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    private Movie second = new Movie(2, "Ahead", "http://", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    private Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    private Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    private Movie sixth = new Movie(6, "Trolls", "http://", "cartoon");
    private Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    private Movie eighth = new Movie(8, "NumberTwo", "http://", "actionMovie");
    private Movie ninth = new Movie(9, "NumberThree", "http://", "actionMovie");
    private Movie tenth = new Movie(10, "NumberFour", "http://", "actionMovie");
    Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
    @Test
    void mustShowTenMovie() {
        AfishaManager manager = new AfishaManager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);
    }
    @Test
    void mustShowNothing() {
        AfishaManager manager = new AfishaManager(0);
        Movie[] actual = manager.getLastAdd();
        Movie [] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowValid() {
        AfishaManager manager = new AfishaManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie movieToAdd = new Movie(11, "NumberFive", "http://", "horrors");
        manager.addMovie(movieToAdd);
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = {new Movie(11, "NumberFive", "http://", "horrors"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);
    }
    @Test
    void mustShowOverMax() {
        AfishaManager manager = new AfishaManager(11);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);
    }
}