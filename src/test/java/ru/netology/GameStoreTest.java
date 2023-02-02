package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {
    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldPublishGame() {
        GameStore store = new GameStore();

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл2 ОНлайн", "Аркады2");
        Game game3 = store.publishGame("Нетология Баттл3 ОНлайн", "Аркады3");
        Game game4 = store.publishGame("Нетология Баттл4 ОНлайн", "Аркады4");

        assertTrue(store.containsGame(game1));// не проходит, так как есть дефект в containsGame
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));// не проходит, так как есть дефект в containsGame
    }

    @Test
    public void shouldAddTimeWhenThePlayerIsNotFound() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Nina", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);

        String expected = "Nina";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddTimeWhenThePlayerIsFound() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Nina", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);
        store.addPlayTime("Kolya", 2);

        String expected = "Kolya";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual); // не суммирует время игроков из-за дефекта в методе
    }

    @Test
    public void shouldDetermineTheBestPlayerIfHisTimeIsOneHour() {
        GameStore store = new GameStore();

        store.addPlayTime("Anna", 1);

        String expected = "Anna";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual); //возвращает null из-за дефекта
    }

    @Test
    public void shouldDetermineTheBestPlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Anna", 1);
        store.addPlayTime("Nina", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);
        store.addPlayTime("Inna", 2);

        String expected = "Nina";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDetermineTheBestPlayerIfThereIsNoOne() {
        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();
        assertEquals(null, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Nina", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);
        store.addPlayTime("Inna", 2);

        int expected = 18;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
}