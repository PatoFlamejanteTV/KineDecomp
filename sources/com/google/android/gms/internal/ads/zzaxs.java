package com.google.android.gms.internal.ads;

import android.os.Bundle;

@zzark
/* loaded from: classes2.dex */
public final class zzaxs {
    private final Object mLock;
    private final zzaxt zzeia;
    private final String zzeid;
    private int zzejx;
    private int zzejy;

    public zzaxs(String str) {
        this(com.google.android.gms.ads.internal.zzbv.i().zzys(), str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaxs.class == obj.getClass()) {
            zzaxs zzaxsVar = (zzaxs) obj;
            String str = this.zzeid;
            if (str != null) {
                return str.equals(zzaxsVar.zzeid);
            }
            if (zzaxsVar.zzeid == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzeid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzejx);
            bundle.putInt("pmnll", this.zzejy);
        }
        return bundle;
    }

    public final void zzl(int i, int i2) {
        synchronized (this.mLock) {
            this.zzejx = i;
            this.zzejy = i2;
            this.zzeia.zza(this);
        }
    }

    public final String zzyx() {
        return this.zzeid;
    }

    private zzaxs(zzaxt zzaxtVar, String str) {
        this.mLock = new Object();
        this.zzeia = zzaxtVar;
        this.zzeid = str;
    }
}
