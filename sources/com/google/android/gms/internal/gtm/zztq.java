package com.google.android.gms.internal.gtm;

import java.util.List;

/* loaded from: classes2.dex */
public final class zztq extends RuntimeException {
    private final List<String> zzbel;

    public zztq(zzsk zzskVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzbel = null;
    }
}
