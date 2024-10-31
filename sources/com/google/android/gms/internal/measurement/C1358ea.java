package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.measurement.ea */
/* loaded from: classes2.dex */
final class C1358ea implements Comparator<zzte> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzte zzteVar, zzte zzteVar2) {
        int zza;
        int zza2;
        zzte zzteVar3 = zzteVar;
        zzte zzteVar4 = zzteVar2;
        zztl zztlVar = (zztl) zzteVar3.iterator();
        zztl zztlVar2 = (zztl) zzteVar4.iterator();
        while (zztlVar.hasNext() && zztlVar2.hasNext()) {
            zza = zzte.zza(zztlVar.nextByte());
            zza2 = zzte.zza(zztlVar2.nextByte());
            int compare = Integer.compare(zza, zza2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzteVar3.size(), zzteVar4.size());
    }
}
