package com.google.android.gms.internal.gtm;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1308h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzap f13237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1308h(zzap zzapVar) {
        this.f13237a = zzapVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzci zzdd = this.f13237a.zzdd();
        if (zzdd != null) {
            zzdd.zze("Job execution failed", th);
        }
    }
}
