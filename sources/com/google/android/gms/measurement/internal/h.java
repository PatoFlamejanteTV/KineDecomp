package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.zzab;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComponentName f2032a;
    final /* synthetic */ zzab.zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzab.zza zzaVar, ComponentName componentName) {
        this.b = zzaVar;
        this.f2032a = componentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzab.this.a(this.f2032a);
    }
}
