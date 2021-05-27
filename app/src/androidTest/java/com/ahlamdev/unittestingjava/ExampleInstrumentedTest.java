package com.ahlamdev.unittestingjava;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.registerIdlingResources;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ahlamdev.unittestingjava", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    String[][] testcases = {
            {"1.5", "2.6"},
            {"41", "33"},
            {"3", "8.7"},
            {"", "8.7"},
            {"36", ""},
            {"x", "22"},
            {"36", "x"}
    };

    @Test
    public void checkTestCases() throws InterruptedException {

        for(String[] tc : testcases){
            onView(withId(R.id.edt_num1)).perform(typeText(tc[0]));
            onView(withId(R.id.edt_num2)).perform(typeText(tc[1]));
            Espresso.closeSoftKeyboard();

            onView(withId(R.id.btn_equals)).perform(click());
            Thread.sleep(2000);

            //reset
            onView(withId(R.id.edt_num1)).perform(clearText());
            onView(withId(R.id.edt_num2)).perform(clearText());
        }
    }


}