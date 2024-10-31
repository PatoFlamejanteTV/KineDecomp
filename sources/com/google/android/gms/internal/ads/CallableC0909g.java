package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.g */
/* loaded from: classes2.dex */
public final class CallableC0909g<T> implements Callable<T> {

    /* renamed from: a */
    private final /* synthetic */ zzaac f12167a;

    /* renamed from: b */
    private final /* synthetic */ zzaak f12168b;

    public CallableC0909g(zzaak zzaakVar, zzaac zzaacVar) {
        this.f12168b = zzaakVar;
        this.f12167a = zzaacVar;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        SharedPreferences sharedPreferences;
        zzaac zzaacVar = this.f12167a;
        sharedPreferences = this.f12168b.zzcnp;
        return (T) zzaacVar.zza(sharedPreferences);
    }
}
