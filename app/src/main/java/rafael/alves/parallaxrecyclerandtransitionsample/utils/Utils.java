package rafael.alves.parallaxrecyclerandtransitionsample.utils;

import android.os.Build;

public class Utils {

    public static boolean checkSDKLollipop() {
        boolean result;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
}
