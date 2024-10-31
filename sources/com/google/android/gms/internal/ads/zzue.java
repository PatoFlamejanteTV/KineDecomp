package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Future;

@zzark
/* loaded from: classes2.dex */
public final class zzue {
    private final Context mContext;
    private final Object mLock = new Object();
    private zztx zzbzr;
    private boolean zzcac;

    public zzue(Context context) {
        this.mContext = context;
    }

    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbzr == null) {
                return;
            }
            this.zzbzr.disconnect();
            this.zzbzr = null;
            Binder.flushPendingCommands();
        }
    }

    public final Future<InputStream> zzb(zzty zztyVar) {
        Om om = new Om(this);
        Pm pm = new Pm(this, zztyVar, om);
        Tm tm = new Tm(this, om);
        synchronized (this.mLock) {
            this.zzbzr = new zztx(this.mContext, com.google.android.gms.ads.internal.zzbv.u().zzaak(), pm, tm);
            this.zzbzr.checkAvailabilityAndConnect();
        }
        return om;
    }

    public static /* synthetic */ boolean zza(zzue zzueVar, boolean z) {
        zzueVar.zzcac = true;
        return true;
    }
}
