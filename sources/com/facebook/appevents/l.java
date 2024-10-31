package com.facebook.appevents;

/* compiled from: AppEventQueue.java */
/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccessTokenAppIdPair f9208a;

    /* renamed from: b */
    final /* synthetic */ y f9209b;

    public l(AccessTokenAppIdPair accessTokenAppIdPair, y yVar) {
        this.f9208a = accessTokenAppIdPair;
        this.f9209b = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        n.a(this.f9208a, this.f9209b);
    }
}
