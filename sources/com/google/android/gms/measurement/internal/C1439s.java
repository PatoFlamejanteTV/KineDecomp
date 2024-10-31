package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1439s<V> extends FutureTask<V> implements Comparable<C1439s> {

    /* renamed from: a, reason: collision with root package name */
    private final long f13839a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f13840b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13841c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzbr f13842d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1439s(zzbr zzbrVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f13842d = zzbrVar;
        Preconditions.a(str);
        atomicLong = zzbr.f13972c;
        this.f13839a = atomicLong.getAndIncrement();
        this.f13841c = str;
        this.f13840b = z;
        if (this.f13839a == Long.MAX_VALUE) {
            zzbrVar.b().q().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(C1439s c1439s) {
        C1439s c1439s2 = c1439s;
        boolean z = this.f13840b;
        if (z != c1439s2.f13840b) {
            return z ? -1 : 1;
        }
        long j = this.f13839a;
        long j2 = c1439s2.f13839a;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f13842d.b().r().a("Two tasks share the same index. index", Long.valueOf(this.f13839a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.f13842d.b().q().a(this.f13841c, th);
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1439s(zzbr zzbrVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f13842d = zzbrVar;
        Preconditions.a(str);
        atomicLong = zzbr.f13972c;
        this.f13839a = atomicLong.getAndIncrement();
        this.f13841c = str;
        this.f13840b = false;
        if (this.f13839a == Long.MAX_VALUE) {
            zzbrVar.b().q().a("Tasks index overflow");
        }
    }
}
