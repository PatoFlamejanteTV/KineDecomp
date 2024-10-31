package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.internal.zze;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f846a;
    final /* synthetic */ int b;
    final /* synthetic */ zze.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zze.b bVar, zze zzeVar, int i) {
        this.c = bVar;
        this.f846a = zzeVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f846a.d != null) {
            this.f846a.d.a(this.b);
        }
    }
}
