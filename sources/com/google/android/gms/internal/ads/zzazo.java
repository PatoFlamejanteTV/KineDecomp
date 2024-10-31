package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzazo {
    private final String[] zzeml;
    private final double[] zzemm;
    private final double[] zzemn;
    private final int[] zzemo;
    private int zzemp;

    /* JADX INFO: Access modifiers changed from: private */
    public zzazo(zzazr zzazrVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzazrVar.zzemu;
        int size = list.size();
        list2 = zzazrVar.zzemt;
        this.zzeml = (String[]) list2.toArray(new String[size]);
        list3 = zzazrVar.zzemu;
        this.zzemm = zzo(list3);
        list4 = zzazrVar.zzemv;
        this.zzemn = zzo(list4);
        this.zzemo = new int[size];
        this.zzemp = 0;
    }

    private static double[] zzo(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d2) {
        this.zzemp++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzemn;
            if (i >= dArr.length) {
                return;
            }
            if (dArr[i] <= d2 && d2 < this.zzemm[i]) {
                int[] iArr = this.zzemo;
                iArr[i] = iArr[i] + 1;
            }
            if (d2 < this.zzemn[i]) {
                return;
            } else {
                i++;
            }
        }
    }

    public final List<zzazq> zzaai() {
        ArrayList arrayList = new ArrayList(this.zzeml.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzeml;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d2 = this.zzemn[i];
            double d3 = this.zzemm[i];
            int[] iArr = this.zzemo;
            double d4 = iArr[i];
            double d5 = this.zzemp;
            Double.isNaN(d4);
            Double.isNaN(d5);
            arrayList.add(new zzazq(str, d2, d3, d4 / d5, iArr[i]));
            i++;
        }
    }

    public /* synthetic */ zzazo(zzazr zzazrVar, Pd pd) {
        this(zzazrVar);
    }
}
