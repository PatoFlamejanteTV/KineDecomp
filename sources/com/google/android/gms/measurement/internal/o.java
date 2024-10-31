package com.google.android.gms.measurement.internal;

import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f2040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f2040a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        zzv zzvVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzvVar = this.f2040a.f2039a;
            zzvVar.g().a(this);
            return;
        }
        boolean b = this.f2040a.b();
        this.f2040a.d = 0L;
        if (b) {
            z = this.f2040a.e;
            if (z) {
                this.f2040a.a();
            }
        }
    }
}
