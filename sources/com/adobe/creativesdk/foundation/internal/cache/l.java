package com.adobe.creativesdk.foundation.internal.cache;

import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ o f4974a;

    public l(o oVar) {
        this.f4974a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int h2;
        long j2;
        int h3;
        this.f4974a.b("***** Async eviction event at " + SimpleDateFormat.getDateInstance().format(new Date()));
        j = this.f4974a.f4988h;
        h2 = this.f4974a.h();
        if (j > h2) {
            this.f4974a.d();
            return;
        }
        o oVar = this.f4974a;
        j2 = oVar.f4988h;
        h3 = this.f4974a.h();
        oVar.b(String.format("Stopping eviction timer: %d < %d", Long.valueOf(j2), Integer.valueOf(h3)));
        this.f4974a.l();
    }
}
