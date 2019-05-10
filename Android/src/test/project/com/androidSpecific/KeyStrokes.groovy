package com.utilities.android

import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.android.connection.ConnectionStateBuilder
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.WebDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent


import java.time.Duration


class KeyStrokes {

    static void goToAndroidHome(WebDriver driver) {
        (driver as AndroidDriver).pressKey(new KeyEvent(AndroidKey.HOME))
    }

    static void backgroundApp(int timer, WebDriver driver) {
        (driver as AndroidDriver).runAppInBackground(Duration.ofSeconds(timer))
    }
}