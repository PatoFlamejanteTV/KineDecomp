package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzavp {
    private int mErrorCode;
    private String zzdml;
    private String zzefc;
    private long zzefd;

    public final zzavp zzar(long j) {
        this.zzefd = j;
        return this;
    }

    public final zzavp zzcu(int i) {
        this.mErrorCode = i;
        return this;
    }

    public final zzavp zzdf(String str) {
        this.zzdml = str;
        return this;
    }

    public final zzavp zzdg(String str) {
        this.zzefc = str;
        return this;
    }

    public final zzavn zzxm() {
        return new zzavn(this);
    }
}
