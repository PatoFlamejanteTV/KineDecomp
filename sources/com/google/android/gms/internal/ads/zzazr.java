package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzazr {
    private final List<String> zzemt = new ArrayList();
    private final List<Double> zzemu = new ArrayList();
    private final List<Double> zzemv = new ArrayList();

    public final zzazr zza(String str, double d2, double d3) {
        int i = 0;
        while (i < this.zzemt.size()) {
            double doubleValue = this.zzemv.get(i).doubleValue();
            double doubleValue2 = this.zzemu.get(i).doubleValue();
            if (d2 < doubleValue || (doubleValue == d2 && d3 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzemt.add(i, str);
        this.zzemv.add(i, Double.valueOf(d2));
        this.zzemu.add(i, Double.valueOf(d3));
        return this;
    }

    public final zzazo zzaaj() {
        return new zzazo(this);
    }
}
