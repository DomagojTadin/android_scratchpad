package com.mytaxi.android_demo;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


public class LoginTest {

    @Test
    public void selectAndClick() {
        onView(withText("Sarah Something"))
                .perform(click())
                .check(withId(R.id.whateverid).matches("Sarah Something"));
    }
}
}
