package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
class ah {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        a(edit);
    }

    static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new ai(editor)).start();
        }
    }
}
