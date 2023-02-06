package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {
    @Test
    public void shouldReturnFalseByNotAddGame() {

        GameStore store = new GameStore();
        Game game1 = new Game("Нетология", "Симуляторы", store);

        assertFalse(store.containsGame(game1));
    }

    @Test
    public void shouldPublishGame() {
        GameStore store = new GameStore();

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл2 ОНлайн", "Аркады2");
        Game game3 = store.publishGame("Нетология Баттл3 ОНлайн", "Аркады3");
        Game game4 = store.publishGame("Нетология Баттл4 ОНлайн", "Аркады4");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
    }

    @Test
    public void shouldAddTimeWhenThePlayerIsNotFound() {
        GameStore store = new GameStore();

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

        store.addPlayTime("Nina", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);
        store.addPlayTime("Kolya", 2);

        String expected = "Kolya";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDetermineTheBestPlayerIfHisTimeIsOneHour() {
        GameStore store = new GameStore();

        store.addPlayTime("Anna", 1);

        String expected = "Anna";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
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

        String actual = store.getMostPlayer();
        assertNull(actual);
    }

    @Test
    public void shouldReturnPlayedTimeByPlayerName() {
        GameStore store = new GameStore();

        store.addPlayTime("Nina", 7);
        store.addPlayTime("Kolya", 3);
        store.addPlayTime("Kolya", 6);
        store.addPlayTime("Kolya", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);
        store.addPlayTime("Nina", 7);
        store.addPlayTime("Anna", 3);
        store.addPlayTime("Kolya", 6);

        int expected = 28;
        int actual = store.playedTimeByName("Kolya");
        assertEquals(expected, actual);
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
