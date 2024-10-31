package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class zzto implements Comparator<zztc> {
    public zzto(zztn zztnVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zztc zztcVar, zztc zztcVar2) {
        zztc zztcVar3 = zztcVar;
        zztc zztcVar4 = zztcVar2;
        if (zztcVar3.zzny() < zztcVar4.zzny()) {
            return -1;
        }
        if (zztcVar3.zzny() > zztcVar4.zzny()) {
            return 1;
        }
        if (zztcVar3.zznx() < zztcVar4.zznx()) {
            return -1;
        }
        if (zztcVar3.zznx() > zztcVar4.zznx()) {
            return 1;
        }
        float zzoa = (zztcVar3.zzoa() - zztcVar3.zzny()) * (zztcVar3.zznz() - zztcVar3.zznx());
        float zzoa2 = (zztcVar4.zzoa() - zztcVar4.zzny()) * (zztcVar4.zznz() - zztcVar4.zznx());
        if (zzoa > zzoa2) {
            return -1;
        }
        return zzoa < zzoa2 ? 1 : 0;
    }
}
