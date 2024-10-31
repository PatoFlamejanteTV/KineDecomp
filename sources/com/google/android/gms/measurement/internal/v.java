package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzv f2047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzv zzvVar) {
        this.f2047a = zzvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2047a.c();
    }
}
