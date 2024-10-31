package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.internal.gtm.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1314k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ComponentName f13252a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzav f13253b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1314k(zzav zzavVar, ComponentName componentName) {
        this.f13253b = zzavVar;
        this.f13252a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzat.zza(this.f13253b.zzxe, this.f13252a);
    }
}
