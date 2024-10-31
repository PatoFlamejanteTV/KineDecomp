package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzek extends zzeu {
    private List<Long> zzuq;

    public zzek(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        super(zzdlVar, str, str2, zzblVar, i, 31);
        this.zzuq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzes = -1L;
        this.zzun.zzet = -1L;
        if (this.zzuq == null) {
            this.zzuq = (List) this.zzuw.invoke(null, this.zzqo.getContext());
        }
        List<Long> list = this.zzuq;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.zzun) {
            this.zzun.zzes = Long.valueOf(this.zzuq.get(0).longValue());
            this.zzun.zzet = Long.valueOf(this.zzuq.get(1).longValue());
        }
    }
}
