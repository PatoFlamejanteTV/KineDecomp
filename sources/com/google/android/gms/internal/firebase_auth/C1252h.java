package com.google.android.gms.internal.firebase_auth;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase_auth.h */
/* loaded from: classes2.dex */
final class C1252h implements Comparator<zzeh> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzeh zzehVar, zzeh zzehVar2) {
        int zza;
        int zza2;
        zzeh zzehVar3 = zzehVar;
        zzeh zzehVar4 = zzehVar2;
        zzeo zzeoVar = (zzeo) zzehVar3.iterator();
        zzeo zzeoVar2 = (zzeo) zzehVar4.iterator();
        while (zzeoVar.hasNext() && zzeoVar2.hasNext()) {
            zza = zzeh.zza(zzeoVar.nextByte());
            zza2 = zzeh.zza(zzeoVar2.nextByte());
            int compare = Integer.compare(zza, zza2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzehVar3.size(), zzehVar4.size());
    }
}
