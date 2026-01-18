package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.CustomMatcher.*;
import static java.util.regex.Pattern.matches;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.CustomMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

@LargeTest



public class IdlingTest {

    @Rule
    public IntentsTestRule<MainActivity> mActivityScenarioRule =
            new IntentsTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }



    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }


    @Test
    public void testGalleryOpening() {
        ViewInteraction menu  = onView(isAssignableFrom(AppCompatImageButton.class));

        menu.check(matches(isDisplayed()));

        menu.perform(click());

        ViewInteraction gallery = onView(withId(R.id.nav_gallery));
        gallery.perform(click());

        ViewInteraction recyclerView = onView(CustomViewMatcher.recyclerViewSizeMatcher(10));

        recyclerView.check(matches(isDisplayed()));

    }









   // @Test
   // public void testName() {
        //ViewInteraction element = onView(
               // withId(R.id.найденный id)
       // );
       // element.perform(Действие);
       // element.check(
               // matches(Условия проверки);
    //}








}
