package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@zzark
/* renamed from: com.google.android.gms.internal.ads.ue */
/* loaded from: classes2.dex */
final class C1108ue<V> extends FutureTask<V> implements zzbcb<V> {

    /* renamed from: a */
    private final C1080se f12577a;

    public C1108ue(Callable<V> callable) {
        super(callable);
        this.f12577a = new C1080se();
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        this.f12577a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbcb
    public final void zza(Runnable runnable, Executor executor) {
        this.f12577a.a(runnable, executor);
    }

    public C1108ue(Runnable runnable, @Nullable V v) {
        super(runnable, v);
        this.f12577a = new C1080se();
    }
}
