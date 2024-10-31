package com.facebook.appevents;

import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.ScheduledFuture;

/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
class g implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture unused = m.f9213d = null;
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            m.b(FlushReason.TIMER);
        }
    }
}
