package com.google.android.gms.internal.gtm;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.gtm.ca */
/* loaded from: classes2.dex */
final class C1296ca implements Comparator<zzps> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzps zzpsVar, zzps zzpsVar2) {
        int zza;
        int zza2;
        zzps zzpsVar3 = zzpsVar;
        zzps zzpsVar4 = zzpsVar2;
        zzpz zzpzVar = (zzpz) zzpsVar3.iterator();
        zzpz zzpzVar2 = (zzpz) zzpsVar4.iterator();
        while (zzpzVar.hasNext() && zzpzVar2.hasNext()) {
            zza = zzps.zza(zzpzVar.nextByte());
            zza2 = zzps.zza(zzpzVar2.nextByte());
            int compare = Integer.compare(zza, zza2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzpsVar3.size(), zzpsVar4.size());
    }
}
