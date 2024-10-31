package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.internal.zze;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f847a;
    final /* synthetic */ DeviceStatus b;
    final /* synthetic */ zze.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zze.b bVar, zze zzeVar, DeviceStatus deviceStatus) {
        this.c = bVar;
        this.f847a = zzeVar;
        this.b = deviceStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f847a.a(this.b);
    }
}
