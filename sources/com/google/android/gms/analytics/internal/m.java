package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import com.google.android.gms.analytics.internal.zzi;

/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComponentName f711a;
    final /* synthetic */ zzi.zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zzi.zza zzaVar, ComponentName componentName) {
        this.b = zzaVar;
        this.f711a = componentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzi.this.a(this.f711a);
    }
}
