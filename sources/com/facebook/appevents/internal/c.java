package com.facebook.appevents.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9184a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9185b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9186c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(long j, Context context, String str) {
        this.f9184a = j;
        this.f9185b = context;
        this.f9186c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        l lVar2;
        l lVar3;
        int sessionTimeoutInSeconds;
        l lVar4;
        l lVar5;
        String str;
        String str2;
        l lVar6;
        l lVar7;
        String str3;
        lVar = ActivityLifecycleTracker.currentSession;
        if (lVar == null) {
            l unused = ActivityLifecycleTracker.currentSession = new l(Long.valueOf(this.f9184a), null);
            Context context = this.f9185b;
            String str4 = this.f9186c;
            str3 = ActivityLifecycleTracker.appId;
            m.a(context, str4, (SourceApplicationInfo) null, str3);
        } else {
            lVar2 = ActivityLifecycleTracker.currentSession;
            if (lVar2.e() != null) {
                long j = this.f9184a;
                lVar3 = ActivityLifecycleTracker.currentSession;
                long longValue = j - lVar3.e().longValue();
                sessionTimeoutInSeconds = ActivityLifecycleTracker.getSessionTimeoutInSeconds();
                if (longValue > sessionTimeoutInSeconds * 1000) {
                    Context context2 = this.f9185b;
                    String str5 = this.f9186c;
                    lVar5 = ActivityLifecycleTracker.currentSession;
                    str = ActivityLifecycleTracker.appId;
                    m.a(context2, str5, lVar5, str);
                    Context context3 = this.f9185b;
                    String str6 = this.f9186c;
                    str2 = ActivityLifecycleTracker.appId;
                    m.a(context3, str6, (SourceApplicationInfo) null, str2);
                    l unused2 = ActivityLifecycleTracker.currentSession = new l(Long.valueOf(this.f9184a), null);
                } else if (longValue > 1000) {
                    lVar4 = ActivityLifecycleTracker.currentSession;
                    lVar4.i();
                }
            }
        }
        lVar6 = ActivityLifecycleTracker.currentSession;
        lVar6.a(Long.valueOf(this.f9184a));
        lVar7 = ActivityLifecycleTracker.currentSession;
        lVar7.j();
    }
}
