package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class zzae extends zzan {
    private final C1320n zzvu;

    public zzae(zzap zzapVar, zzar zzarVar) {
        super(zzapVar);
        Preconditions.a(zzarVar);
        this.zzvu = new C1320n(zzapVar, zzarVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onServiceConnected() {
        com.google.android.gms.analytics.zzk.d();
        this.zzvu.onServiceConnected();
    }

    public final void setLocalDispatchPeriod(int i) {
        zzdb();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zzcq().a(new RunnableC1289a(this, i));
    }

    public final void start() {
        this.zzvu.start();
    }

    public final long zza(zzas zzasVar) {
        zzdb();
        Preconditions.a(zzasVar);
        com.google.android.gms.analytics.zzk.d();
        long a2 = this.zzvu.a(zzasVar, true);
        if (a2 == 0) {
            this.zzvu.a(zzasVar);
        }
        return a2;
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        this.zzvu.zzag();
    }

    public final void zzch() {
        zzdb();
        zzcq().a(new RunnableC1301e(this));
    }

    public final void zzci() {
        zzdb();
        Context context = getContext();
        if (zzcp.zza(context) && zzcq.zze(context)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            context.startService(intent);
            return;
        }
        zza((zzbw) null);
    }

    public final boolean zzcj() {
        zzdb();
        try {
            zzcq().a(new CallableC1306g(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e2) {
            zzd("syncDispatchLocalHits interrupted", e2);
            return false;
        } catch (ExecutionException e3) {
            zze("syncDispatchLocalHits failed", e3);
            return false;
        } catch (TimeoutException e4) {
            zzd("syncDispatchLocalHits timed out", e4);
            return false;
        }
    }

    public final void zzck() {
        zzdb();
        com.google.android.gms.analytics.zzk.d();
        C1320n c1320n = this.zzvu;
        com.google.android.gms.analytics.zzk.d();
        c1320n.zzdb();
        c1320n.zzq("Service disconnected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzcl() {
        com.google.android.gms.analytics.zzk.d();
        this.zzvu.zzcl();
    }

    public final void zza(zzcd zzcdVar) {
        Preconditions.a(zzcdVar);
        zzdb();
        zzb("Hit delivery requested", zzcdVar);
        zzcq().a(new RunnableC1298d(this, zzcdVar));
    }

    public final void zza(zzbw zzbwVar) {
        zzdb();
        zzcq().a(new RunnableC1304f(this, zzbwVar));
    }

    public final void zza(String str, Runnable runnable) {
        Preconditions.a(str, (Object) "campaign param can't be empty");
        zzcq().a(new RunnableC1295c(this, str, runnable));
    }
}
