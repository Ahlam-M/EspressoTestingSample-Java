package com.ahlamdev.espressotestingsamplesjava;

import android.content.Context;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class AppInstrumentedTest {

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
            {"", ""},
            {"x", "22"},
            {"36", "x"},
            {"x", "x"},
    };

    @Test
    public void checkTestCases() throws InterruptedException {

        for (String[] tc : testcases) {
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
    /*@Test
    public void emptyField() throws InterruptedException {

        //check field 1
        onView(withId(R.id.edt_num1)).perform(typeText("21"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_equals)).perform(click());


        Thread.sleep(3000);
        //reset
        onView(withId(R.id.edt_num1)).perform(clearText());

        //check field 2
        onView(withId(R.id.edt_num2)).perform(typeText("33"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_equals)).perform(click());

        Thread.sleep(3000);
    }*/