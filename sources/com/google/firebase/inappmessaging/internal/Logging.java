package com.google.firebase.inappmessaging.internal;

import android.util.Log;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class Logging {
    public static void a(String str) {
        if (Log.isLoggable("FIAM.Headless", 3)) {
            Log.d("FIAM.Headless", str);
        }
    }

    public static void b(String str) {
        Log.e("FIAM.Headless", str);
    }

    public static void c(String str) {
        if (Log.isLoggable("FIAM.Headless", 4)) {
            Log.i("FIAM.Headless", str);
        }
    }

    public static void d(String str) {
        Log.w("FIAM.Headless", str);
    }
}
