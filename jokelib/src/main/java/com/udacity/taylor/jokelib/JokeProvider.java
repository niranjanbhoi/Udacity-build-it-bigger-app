package com.udacity.taylor.jokelib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeProvider {
    Random random = new Random();
    public Joke getJokeRandomly() {
        return new Joke(pickRandomJoke());
    }

    String pickRandomJoke() {
        List<String> jokes = Arrays
                .asList("Instead of \"the John,\" I call my toilet \"the Jim.\" That way it sounds better when I say I go to the Jim first thing every morning.",
                        "Have you ever tried eating a clock? It's really time-consuming, especially if you go for seconds.",
                        "My girlfriend treats me like God. She ignores my existence and only talks to me when she needs something.",
                        "I just saw my life flash before my eyes and all I could see was a close tag",
                        "I couldn’t work today because of an eye problem. I just can’t see myself working today.",
                        "When it comes to work, change is inevitable, except from the vending machine.",
                        "Hard work never killed anyone, but why take the chance?",
                        "It matters not whether you win or lose: what matters is whether I win or lose.");


        int randomIndex = random.nextInt(jokes.size());
        return jokes.get(randomIndex);

    }
}
