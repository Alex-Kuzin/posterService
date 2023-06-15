package Service;

import Domain.Poster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterServiceTest {
    PosterService ps = new PosterService();

    Poster poster1 = new Poster("Бладшот");
    Poster poster2 = new Poster("Вперед");
    Poster poster3 = new Poster("Отель Белград");
    Poster poster4 = new Poster("Джентельмены");
    Poster poster5 = new Poster("Человек-невидимка");
    Poster poster6 = new Poster("Тролли. Мировой тур");
    Poster poster7 = new Poster("Номер один");

    @Test
    public void addPoster() {
        ;
        ps.addPoster(poster6);
        ps.addPoster(poster3);
        ps.addPoster(poster7);
        Poster[] expected = {poster6, poster3, poster7};
        Poster[] actual = ps.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        ps.addPoster(poster1);
        ps.addPoster(poster2);
        ps.addPoster(poster3);
        ps.addPoster(poster4);
        ps.addPoster(poster5);
        ps.addPoster(poster6);
        ps.addPoster(poster7);

        Poster[] expected = {poster1, poster2, poster3, poster4, poster5, poster6, poster7};
        Poster[] actual = ps.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastConstructWithoutValues() {
        ps.addPoster(poster1);
        ps.addPoster(poster2);
        ps.addPoster(poster3);
        ps.addPoster(poster4);
        ps.addPoster(poster5);

        Poster[] expected = {poster5, poster4, poster3, poster2, poster1};
        Poster[] actual = ps.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastLessLimit() {
        PosterService ps = new PosterService(8);
        ps.addPoster(poster1);
        ps.addPoster(poster2);
        ps.addPoster(poster3);
        ps.addPoster(poster4);
        ps.addPoster(poster5);
        ps.addPoster(poster6);
        ps.addPoster(poster7);

        Poster[] expected = {poster7, poster6, poster5, poster4, poster3, poster2, poster1};
        Poster[] actual = ps.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMoreLimit() {
        PosterService ps = new PosterService(2);
        ps.addPoster(poster1);
        ps.addPoster(poster2);
        ps.addPoster(poster3);

        Poster[] expected = {poster3, poster2};
        Poster[] actual = ps.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastEqualLimit() {
        PosterService ps = new PosterService(4);
        ps.addPoster(poster1);
        ps.addPoster(poster2);
        ps.addPoster(poster3);
        ps.addPoster(poster4);

        Poster[] expected = {poster4, poster3, poster2, poster1};
        Poster[] actual = ps.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}

