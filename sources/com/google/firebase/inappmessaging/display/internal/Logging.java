package com.google.firebase.inappmessaging.display.internal;

import android.util.Log;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class Logging {
    public static void a(String str, float f2) {
        a(str + ": " + f2);
    }

    public static void b(String str) {
        a("============ " + str + " ============");
    }

    public static void c(String str) {
        Log.e("FIAM.Display", str);
    }

    public static void d(String str) {
        if (Log.isLoggable("FIAM.Display", 4)) {
            Log.i("FIAM.Display", str);
        }
    }

    public static void a(String str, float f2, float f3) {
        a(str + ": (" + f2 + ", " + f3 + ")");
    }

    public static void a(String str) {
        if (Log.isLoggable("FIAM.Display", 3)) {
            Log.d("FIAM.Display", str);
        }
    }
}
