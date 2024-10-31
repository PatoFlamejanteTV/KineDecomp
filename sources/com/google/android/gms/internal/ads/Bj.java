package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Bj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzco f11408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bj(zzco zzcoVar) {
        this.f11408a = zzcoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        zzdl zzdlVar;
        ConditionVariable conditionVariable2;
        if (this.f11408a.zzqr != null) {
            return;
        }
        conditionVariable = zzco.zzqp;
        synchronized (conditionVariable) {
            if (this.f11408a.zzqr != null) {
                return;
            }
            boolean booleanValue = ((Boolean) zzwu.zzpz().zzd(zzaan.zzctg)).booleanValue();
            if (booleanValue) {
                try {
                    zzdlVar = this.f11408a.zzqo;
                    zzco.zzqq = new zzur(zzdlVar.zzsp, "ADSHIELD", null);
                } catch (Throwable unused) {
                    booleanValue = false;
                }
            }
            this.f11408a.zzqr = Boolean.valueOf(booleanValue);
            conditionVariable2 = zzco.zzqp;
            conditionVariable2.open();
        }
    }
}
