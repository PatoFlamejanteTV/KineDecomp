package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* loaded from: classes2.dex */
public final class zzf extends Binder {

    /* renamed from: a */
    private final zzb f17423a;

    public zzf(zzb zzbVar) {
        this.f17423a = zzbVar;
    }

    public final void a(x xVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.f17423a.b(xVar.f17395a)) {
                xVar.a();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f17423a.f17418a.execute(new z(this, xVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
