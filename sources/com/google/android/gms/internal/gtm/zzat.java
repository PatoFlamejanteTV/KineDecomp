package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzat extends zzan {
    private final zzav zzxa;
    private zzce zzxb;
    private final AbstractC1341y zzxc;
    private final I zzxd;

    public zzat(zzap zzapVar) {
        super(zzapVar);
        this.zzxd = new I(zzapVar.zzcn());
        this.zzxa = new zzav(this);
        this.zzxc = new C1310i(this, zzapVar);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.analytics.zzk.d();
        if (this.zzxb != null) {
            this.zzxb = null;
            zza("Disconnected from device AnalyticsService", componentName);
            zzcs().zzck();
        }
    }

    public final void zza(zzce zzceVar) {
        com.google.android.gms.analytics.zzk.d();
        this.zzxb = zzceVar;
        zzdo();
        zzcs().onServiceConnected();
    }

    private final void zzdo() {
        this.zzxd.b();
        this.zzxc.a(zzby.zzaaj.get().longValue());
    }

    public final void zzdp() {
        com.google.android.gms.analytics.zzk.d();
        if (isConnected()) {
            zzq("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public final boolean connect() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        if (this.zzxb != null) {
            return true;
        }
        zzce zzdq = this.zzxa.zzdq();
        if (zzdq == null) {
            return false;
        }
        this.zzxb = zzdq;
        zzdo();
        return true;
    }

    public final void disconnect() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        try {
            ConnectionTracker.a().a(getContext(), this.zzxa);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.zzxb != null) {
            this.zzxb = null;
            zzcs().zzck();
        }
    }

    public final boolean isConnected() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        return this.zzxb != null;
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
    }

    public final boolean zzb(zzcd zzcdVar) {
        String zzeu;
        Preconditions.a(zzcdVar);
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        zzce zzceVar = this.zzxb;
        if (zzceVar == null) {
            return false;
        }
        if (zzcdVar.zzfj()) {
            zzeu = zzbq.zzet();
        } else {
            zzeu = zzbq.zzeu();
        }
        try {
            zzceVar.zza(zzcdVar.zzdm(), zzcdVar.zzfh(), zzeu, Collections.emptyList());
            zzdo();
            return true;
        } catch (RemoteException unused) {
            zzq("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final boolean zzdn() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        zzce zzceVar = this.zzxb;
        if (zzceVar == null) {
            return false;
        }
        try {
            zzceVar.zzch();
            zzdo();
            return true;
        } catch (RemoteException unused) {
            zzq("Failed to clear hits from AnalyticsService");
            return false;
        }
    }

    public static /* synthetic */ void zza(zzat zzatVar, zzce zzceVar) {
        zzatVar.zza(zzceVar);
    }

    public static /* synthetic */ void zza(zzat zzatVar, ComponentName componentName) {
        zzatVar.onServiceDisconnected(componentName);
    }
}
