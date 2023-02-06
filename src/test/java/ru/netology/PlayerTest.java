package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

//    @Test
//    public void shouldSumGenreIfOneGame() {
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);
//        player.play(game, 3);
//
//        int expected = 3;
//        int actual = player.sumGenre(game.getGenre());
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldReturnRuntimeExceptionIsNotInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Шутеры");

        Player player = new Player("Katya");

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 9);
        });
    }


    /**
     * // *Тест для нереализованного, но заявленного функционала по поиску информации о том,
     * // сколько суммарно часов сыграно в игру, по ключу Игра.
     */
    @Test
    public void shouldReturnTotalHoursOfPlay() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Шутеры");

        Player player = new Player("Katya");
        player.installGame(game);


        player.play(game, 5);
        player.play(game, 7);

        int expected = 12;
        int actual = player.totalTime(game);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAmountHoursByRepeatInstallGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnTotalHoursMultipleGameOfGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл3", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 3);
        player.play(game2, 6);
        player.play(game3, 7);

        int expected = 16;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroByNotPlayGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл3", "Аркады");
        Game game4 = store.publishGame("Нетология Баттл4", "Симуляторы");

        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);

        player.play(game1, 3);
        player.play(game2, 6);
        player.play(game3, 7);

        int expected = 0;
        int actual = player.sumGenre("Симуляторы");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAmountHoursMostPlayedGameByGenre() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл3", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 3);
        player.play(game2, 6);
        player.play(game3, 7);

        Game actual = player.mostPlayerByGenre("Аркады");
        Assertions.assertEquals(game3, actual);
    }

    @Test
    public void shouldReturnNullElseNotGamePlayedByGenre() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл3", "Аркады");
        Game game4 = store.publishGame("Нетология Баттл4", "Симуляторы");


        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);

        player.play(game1, 3);
        player.play(game2, 6);
        player.play(game3, 7);

        assertNull(player.mostPlayerByGenre("Симуляторы"));
    }
}