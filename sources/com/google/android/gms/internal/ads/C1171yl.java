package com.google.android.gms.internal.ads;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.ads.yl */
/* loaded from: classes2.dex */
final class C1171yl implements zzmh {

    /* renamed from: a */
    private final int[] f12688a;

    /* renamed from: b */
    private final zzls[] f12689b;

    public C1171yl(int[] iArr, zzls[] zzlsVarArr) {
        this.f12688a = iArr;
        this.f12689b = zzlsVarArr;
    }

    public final int[] a() {
        int[] iArr = new int[this.f12689b.length];
        int i = 0;
        while (true) {
            zzls[] zzlsVarArr = this.f12689b;
            if (i >= zzlsVarArr.length) {
                return iArr;
            }
            if (zzlsVarArr[i] != null) {
                iArr[i] = zzlsVarArr[i].zzfk();
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmh
    public final zzii zzb(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f12688a;
            if (i3 < iArr.length) {
                if (i2 == iArr[i3]) {
                    return this.f12689b[i3];
                }
                i3++;
            } else {
                StringBuilder sb = new StringBuilder(36);
                sb.append("Unmatched track of type: ");
                sb.append(i2);
                Log.e("BaseMediaChunkOutput", sb.toString());
                return new zzhy();
            }
        }
    }

    public final void a(long j) {
        for (zzls zzlsVar : this.f12689b) {
            if (zzlsVar != null) {
                zzlsVar.zzae(j);
            }
        }
    }
}
