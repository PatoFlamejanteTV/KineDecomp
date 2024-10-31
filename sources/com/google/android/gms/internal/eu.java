package com.google.android.gms.internal;

import com.google.android.gms.internal.zzs;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1540a;
    final /* synthetic */ long b;
    final /* synthetic */ zzk c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(zzk zzkVar, String str, long j) {
        this.c = zzkVar;
        this.f1540a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzs.a aVar;
        zzs.a aVar2;
        aVar = this.c.zzD;
        aVar.a(this.f1540a, this.b);
        aVar2 = this.c.zzD;
        aVar2.a(toString());
    }
}
