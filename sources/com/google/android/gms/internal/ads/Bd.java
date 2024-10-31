package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Bd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f11400a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzayh f11401b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bd(zzayh zzayhVar, Context context) {
        this.f11401b = zzayhVar;
        this.f11400a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.f11401b.mLock;
        synchronized (obj) {
            this.f11401b.zzeiz = zzayh.zzak(this.f11400a);
            obj2 = this.f11401b.mLock;
            obj2.notifyAll();
        }
    }
}
