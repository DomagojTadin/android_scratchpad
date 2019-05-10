package com.androidSpecific


class AdbCommands {

    private static AdbCommands instance = null

    private Map<String, String> adbCommands = ["autorotate_true"    : "adb shell settings put system accelerometer_rotation 1",
                                               "autorotate_false"   : "adb shell settings put system accelerometer_rotation 0",
                                               "airplaneMode_true"  : "",
                                               "airplaneMode_false" : "",
                                               "enableLandscapeMode": "adb shell settings put system user_rotation 1",
                                               "enablePortraitMode" : "adb shell settings put system user_rotation 0"
    ]

    private AdbCommands() {

    }

    public static AdbCommands getInstance() {
        if (instance == null) {
            instance = new AdbCommandCenter()
        }
        return instance
    }

    public launchADBCommand(String adb) {
        if (deviceSettingControls.containsKey(adb)) {
            sleep(1000)
            deviceSettingControls[adb].execute()
        } else {
            println("Current available settings: " + adbCommands.keySet() + ".\n" +
                    "The " + adb + " setting is not defined.")
        }
        return instance
    }

    public void resetDeviceSettings() {
        println("resetting device")
        adbCommands["autorotate_true"].execute()
        adbCommands["enablePortraitMode"].execute()
        //deviceSettingControls.airplaneMode_OFF.execute()
    }
}