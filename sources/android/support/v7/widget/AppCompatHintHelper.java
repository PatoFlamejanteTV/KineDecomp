package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* loaded from: classes.dex */
class AppCompatHintHelper {
    AppCompatHintHelper() {
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof WithHint) {
                    editorInfo.hintText = ((WithHint) parent).getHint();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}