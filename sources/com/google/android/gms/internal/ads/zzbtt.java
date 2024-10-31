package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public final class zzbtt extends RuntimeException {
    private final List<String> zzftw;

    public zzbtt(zzbsl zzbslVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzftw = null;
    }

    public final zzbrl zzaox() {
        return new zzbrl(getMessage());
    }
}
