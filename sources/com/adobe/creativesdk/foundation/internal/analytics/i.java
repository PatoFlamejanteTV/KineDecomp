package com.adobe.creativesdk.foundation.internal.analytics;

import java.util.TimerTask;

/* compiled from: AdobeAnalyticsETSJobManager.java */
/* loaded from: classes.dex */
public class i extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ j f4732a;

    public i(j jVar) {
        this.f4732a = jVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f4732a.d();
    }
}
