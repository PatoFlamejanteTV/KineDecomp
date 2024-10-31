package com.google.android.gms.internal.ads;

import android.os.Bundle;

@zzark
/* loaded from: classes2.dex */
public final class zzahq {
    private static zzahq zzdhr = new zzahq();
    private int zzdhs;
    private int zzdht;
    private int zzdhu;
    private int zzdhv;
    private int zzdhw;

    public static zzahq zzto() {
        return zzdhr;
    }

    public final void zzcn(int i) {
        this.zzdhs += i;
    }

    public final void zztp() {
        this.zzdht++;
    }

    public final void zztq() {
        this.zzdhu++;
    }

    public final void zztr() {
        this.zzdhv++;
    }

    public final void zzts() {
        this.zzdhw++;
    }

    public final int zztt() {
        return this.zzdht;
    }

    public final int zztu() {
        return this.zzdhu;
    }

    public final int zztv() {
        return this.zzdhv;
    }

    public final int zztw() {
        return this.zzdhw;
    }

    public final Bundle zztx() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.zzdhs);
        bundle.putInt("ipds", this.zzdht);
        bundle.putInt("ipde", this.zzdhu);
        bundle.putInt("iph", this.zzdhv);
        bundle.putInt("ipm", this.zzdhw);
        return bundle;
    }
}
