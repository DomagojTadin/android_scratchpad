package com.mytaxi.android_demo;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;


public class SearchAndCallTest {

    @Test
    public void searchAndCall() {
        onView(withId(R.id.edt_username)).perform(typeText("get username from api"));
        onView(withId(R.id.edt_password)).perform(typeText("get password from api"));
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.searchContainer)).perform(typeText("sa"));
        onView(withText("getNameStringFromApiOrFromSomewhere")).perform(click());
        onView(withId(R.id.fab)).perform(click());
    }
}