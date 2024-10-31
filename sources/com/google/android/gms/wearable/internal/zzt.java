package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.internal.zzau;

/* loaded from: classes.dex */
public final class zzt extends zzau.zza {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2400a = new Object();
    private v b;
    private u c;

    @Override // com.google.android.gms.wearable.internal.zzau
    public void a(int i, int i2) {
        v vVar;
        u uVar;
        synchronized (this.f2400a) {
            vVar = this.b;
            uVar = new u(i, i2);
            this.c = uVar;
        }
        if (vVar != null) {
            vVar.a(uVar);
        }
    }
}
