package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.va, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1446va implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ComponentName f13863a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzes f13864b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1446va(zzes zzesVar, ComponentName componentName) {
        this.f13864b = zzesVar;
        this.f13863a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13864b.f14026c.a(this.f13863a);
    }
}
