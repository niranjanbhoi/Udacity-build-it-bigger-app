package com.udacity.taylor.jokelib;


import org.junit.Assert;
import org.junit.Test;

public class JokeProviderTest {

    @Test
    public void getJokeRandomly() {
        JokeProvider jokeProvider = new JokeProvider();
        Joke jokeRandomly = jokeProvider.getJokeRandomly();

        Assert.assertFalse(jokeRandomly.getDescription().isEmpty());
    }
}