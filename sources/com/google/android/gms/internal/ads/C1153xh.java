package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.ads.xh */
/* loaded from: classes2.dex */
final class C1153xh implements Comparator<zzbpu> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzbpu zzbpuVar, zzbpu zzbpuVar2) {
        int zzb;
        int zzb2;
        zzbpu zzbpuVar3 = zzbpuVar;
        zzbpu zzbpuVar4 = zzbpuVar2;
        zzbqa zzbqaVar = (zzbqa) zzbpuVar3.iterator();
        zzbqa zzbqaVar2 = (zzbqa) zzbpuVar4.iterator();
        while (zzbqaVar.hasNext() && zzbqaVar2.hasNext()) {
            zzb = zzbpu.zzb(zzbqaVar.nextByte());
            zzb2 = zzbpu.zzb(zzbqaVar2.nextByte());
            int compare = Integer.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzbpuVar3.size(), zzbpuVar4.size());
    }
}
