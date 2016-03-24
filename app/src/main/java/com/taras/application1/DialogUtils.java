package com.taras.application1;

import android.content.Context;
import android.widget.Toast;

public class DialogUtils {

    private static Toast mToast; //[Comment] Why so difficult? Use just Toast.makeText

    public static void show(Context context, String message) {
        if (message == "") {
            return;
        }
        if (mToast == null && context != null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        if (mToast != null) {
            mToast.setText(message);
            mToast.show();
        }
    }
}
