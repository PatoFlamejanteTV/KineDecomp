package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzgj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzow {
    private String version;
    private final List<zzox> zzatq;
    private final Map<String, List<zzot>> zzatr;
    private int zzpw;

    private zzow() {
        this.zzatq = new ArrayList();
        this.zzatr = new HashMap();
        this.version = "";
        this.zzpw = 0;
    }

    public final zzow zzaf(int i) {
        this.zzpw = i;
        return this;
    }

    public final zzow zzb(zzox zzoxVar) {
        this.zzatq.add(zzoxVar);
        return this;
    }

    public final zzow zzc(zzot zzotVar) {
        String a2 = zzgj.a(zzotVar.zzlu().get(zzb.INSTANCE_NAME.toString()));
        List<zzot> list = this.zzatr.get(a2);
        if (list == null) {
            list = new ArrayList<>();
            this.zzatr.put(a2, list);
        }
        list.add(zzotVar);
        return this;
    }

    public final zzow zzcs(String str) {
        this.version = str;
        return this;
    }

    public final zzov zzmp() {
        return new zzov(this.zzatq, this.zzatr, this.version, this.zzpw);
    }
}
