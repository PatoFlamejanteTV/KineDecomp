package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

@zzark
/* loaded from: classes2.dex */
public final class zzyo implements MuteThisAdReason {
    private final String zzclw;
    private zzyl zzclx;

    public zzyo(zzyl zzylVar) {
        String str;
        this.zzclx = zzylVar;
        try {
            str = zzylVar.getDescription();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            str = null;
        }
        this.zzclw = str;
    }

    public final String getDescription() {
        return this.zzclw;
    }

    public final zzyl zzqe() {
        return this.zzclx;
    }
}
