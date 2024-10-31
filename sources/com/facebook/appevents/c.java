package com.facebook.appevents;

import com.facebook.appevents.AppEventsLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class c implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            AppEventsLogger.flushAndWait(AppEventsLogger.FlushReason.TIMER);
        }
    }
}
