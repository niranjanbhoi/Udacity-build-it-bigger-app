package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.taylor.jokelib.Joke;
import com.udacity.taylor.jokelib.JokeProvider;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokesEndpoint {

    /**
     * A simple endpoint method that return a joke
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        JokeProvider provider = new JokeProvider();
        return provider.getJokeRandomly();
    }

}
