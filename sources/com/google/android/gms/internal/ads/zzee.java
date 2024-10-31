package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzee extends zzeu {
    public zzee(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 24);
    }

    private final void zzav() {
        AdvertisingIdClient zzao = this.zzqo.zzao();
        if (zzao == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzao.getInfo();
            String zzn = zzds.zzn(info.getId());
            if (zzn != null) {
                synchronized (this.zzun) {
                    this.zzun.zzge = zzn;
                    this.zzun.zzgg = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.zzun.zzgf = 5;
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        if (this.zzqo.zzag()) {
            zzav();
            return;
        }
        synchronized (this.zzun) {
            this.zzun.zzge = (String) this.zzuw.invoke(null, this.zzqo.getContext());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeu, java.util.concurrent.Callable
    /* renamed from: zzau */
    public final Void call() throws Exception {
        if (this.zzqo.isInitialized()) {
            return super.call();
        }
        if (!this.zzqo.zzag()) {
            return null;
        }
        zzav();
        return null;
    }
}
