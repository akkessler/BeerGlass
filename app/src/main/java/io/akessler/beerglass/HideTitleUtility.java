package io.akessler.beerglass;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class HideTitleUtility {

    public static void hide(Activity a) {
        // remove title
        a.requestWindowFeature(Window.FEATURE_NO_TITLE);
        a.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }

}
