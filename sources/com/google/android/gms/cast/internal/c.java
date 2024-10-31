package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.internal.zze;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f848a;
    final /* synthetic */ ApplicationStatus b;
    final /* synthetic */ zze.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zze.b bVar, zze zzeVar, ApplicationStatus applicationStatus) {
        this.c = bVar;
        this.f848a = zzeVar;
        this.b = applicationStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f848a.a(this.b);
    }
}
