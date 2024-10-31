package com.google.firebase.iid;

import android.util.Log;

/* loaded from: classes2.dex */
public final class z implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ x f17401a;

    /* renamed from: b */
    private final /* synthetic */ zzf f17402b;

    public z(zzf zzfVar, x xVar) {
        this.f17402b = zzfVar;
        this.f17401a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar;
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        zzbVar = this.f17402b.f17423a;
        zzbVar.c(this.f17401a.f17395a);
        this.f17401a.a();
    }
}
