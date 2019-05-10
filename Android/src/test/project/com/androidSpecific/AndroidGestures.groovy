package com.androidSpecific

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.WebDriver

import java.time.Duration


class AndroidGestures {

    private AndroidDriver driver

    public AndroidGestures(WebDriver driver) {
        this.driver = (driver as AndroidDriver)
    }

    public void oneFingerSwipe(int startX, int startY, int endX, int endY) {
        new AndroidTouchAction(this.driver)
                .press(new PointOption()
                .point(startX, startY))
                .waitAction(new WaitOptions()
                .waitOptions(Duration.ofSeconds(1)))
                .moveTo(new PointOption()
                .point(endX, endY))
                .release()
                .perform()
    }

    static void swipeHorizontal(WebDriver driver, int width) {
        new AndroidTouchAction(driver as AndroidDriver)
                .press(new PointOption().point(width - 100, 100))
                .waitAction(new WaitOptions().waitOptions(999 as Duration))
                .moveTo(new PointOption().point(100, 100))
                .release()
                .perform()
    }
}