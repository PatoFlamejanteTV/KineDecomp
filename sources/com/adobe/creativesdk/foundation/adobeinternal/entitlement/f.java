package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public class f extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3984a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f3984a = hVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3984a.p();
    }
}
