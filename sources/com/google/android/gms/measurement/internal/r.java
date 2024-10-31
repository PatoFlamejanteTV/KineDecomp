package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final String f13831a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbr f13832b;

    public r(zzbr zzbrVar, String str) {
        this.f13832b = zzbrVar;
        Preconditions.a(str);
        this.f13831a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f13832b.b().q().a(this.f13831a, th);
    }
}
