package com.udacity.gradle.builditbigger;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.udacity.gradle.builditbigger.repository.EndpointsAsyncTask;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4ClassRunner.class)
public class EndpointsAsyncTaskTest implements ProgressBarVisibility {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asyncTaskTest() {
        EndpointsAsyncTask endpointsAsyncTask
                = new EndpointsAsyncTask(new ShowJokeListener() {
            @Override
            public void openJokeActivity(String joke) {
                Assert.assertFalse(joke.isEmpty());
            }
        }, this);
        endpointsAsyncTask.execute();

    }

    @Test
    public void jokeIsDisplayedTest() {
        // make a click on the buttonTellJoke
        onView(withId(R.id.buttonTellJoke)).perform(click());
        //wait until asyncTask finish
        //check if there is a joke in testView
        onView(withId(R.id.textViewJoke)).check(matches(not(withText(""))));
    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

}
