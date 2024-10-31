package com.google.android.gms.internal;

import android.text.TextUtils;

@zzgr
/* loaded from: classes.dex */
public final class zzbr {
    private String zzuc;
    private int zzud;

    public zzbr() {
        this(zzby.zzul.zzde(), -1);
    }

    public zzbr(String str) {
        this(str, -1);
    }

    public zzbr(String str, int i) {
        this.zzud = -1;
        this.zzuc = TextUtils.isEmpty(str) ? zzby.zzul.zzde() : str;
        this.zzud = i;
    }

    public String zzdc() {
        return this.zzuc;
    }

    public int zzdd() {
        return this.zzud;
    }
}
