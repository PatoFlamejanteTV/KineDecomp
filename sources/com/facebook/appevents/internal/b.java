package com.facebook.appevents.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9180a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9181b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f9182c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SourceApplicationInfo f9183d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, long j, SourceApplicationInfo sourceApplicationInfo) {
        this.f9180a = context;
        this.f9181b = str;
        this.f9182c = j;
        this.f9183d = sourceApplicationInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        l lVar2;
        String str;
        String str2;
        lVar = ActivityLifecycleTracker.currentSession;
        if (lVar == null) {
            l h2 = l.h();
            if (h2 != null) {
                Context context = this.f9180a;
                String str3 = this.f9181b;
                str2 = ActivityLifecycleTracker.appId;
                m.a(context, str3, h2, str2);
            }
            l unused = ActivityLifecycleTracker.currentSession = new l(Long.valueOf(this.f9182c), null);
            lVar2 = ActivityLifecycleTracker.currentSession;
            lVar2.a(this.f9183d);
            Context context2 = this.f9180a;
            String str4 = this.f9181b;
            SourceApplicationInfo sourceApplicationInfo = this.f9183d;
            str = ActivityLifecycleTracker.appId;
            m.a(context2, str4, sourceApplicationInfo, str);
        }
    }
}
