package com.google.android.gms.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1514a;
    final /* synthetic */ zzid b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(zzid zzidVar, Context context) {
        this.b = zzidVar;
        this.f1514a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        obj = this.b.zzpd;
        synchronized (obj) {
            this.b.zzIa = this.b.zzJ(this.f1514a);
            obj2 = this.b.zzpd;
            obj2.notifyAll();
        }
    }
}
