package com.example.androiduitesting;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenario = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSwitchActivity() {
        // Click on Add City button
        onView(withId(R.id.button_add)).perform(click());
        // Type "Edmonton" in the editText
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        // Click on Confirm
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withId(R.id.city_list)).perform(click());

        onView(withId(R.id.textView_CityName)).check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameCorrect() {
        // Add first city to the list
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Vancouver"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withId(R.id.city_list)).perform(click());

        onView(withId(R.id.textView_CityName)).check(matches(withText("Vancouver")));
    }

    @Test
    public void testReturnButton() {
        // Add first city to the list
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Vancouver"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withId(R.id.city_list)).perform(click());

        onView(withId(R.id.button_returnMain)).check(matches(isDisplayed()));

        onView(withId(R.id.button_returnMain)).perform(click());

        onView(withId(R.id.button_add)).check(matches(isDisplayed()));
    }
}
