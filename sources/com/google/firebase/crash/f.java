package com.google.firebase.crash;

import com.google.android.gms.internal.crash.zzm;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class f implements Callable<zzm> {

    /* renamed from: a */
    private final /* synthetic */ zzf f16621a;

    public f(zzf zzfVar) {
        this.f16621a = zzfVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzm call() throws Exception {
        return this.f16621a.a();
    }
}
