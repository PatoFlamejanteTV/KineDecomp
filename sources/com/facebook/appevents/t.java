package com.facebook.appevents;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
class t implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.a.a(FacebookSdk.getApplicationContext());
    }
}
