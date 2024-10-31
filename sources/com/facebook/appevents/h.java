package com.facebook.appevents;

import com.facebook.appevents.AppEventsLogger;

/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
final class h implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.b.a(AppEventsLogger.applicationContext);
    }
}
