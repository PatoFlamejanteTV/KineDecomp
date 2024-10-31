package com.google.android.gms.analytics.internal;

import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f724a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        zzf zzfVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzfVar = this.f724a.f723a;
            zzfVar.h().a(this);
            return;
        }
        boolean c = this.f724a.c();
        this.f724a.d = 0L;
        if (c) {
            z = this.f724a.e;
            if (z) {
                return;
            }
            this.f724a.a();
        }
    }
}
