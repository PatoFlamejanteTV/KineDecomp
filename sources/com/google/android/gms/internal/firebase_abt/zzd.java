package com.google.android.gms.internal.firebase_abt;

import com.google.android.gms.internal.firebase_abt.zzd;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzd<M extends zzd<M>> extends zzj {
    protected zzf zzs;

    @Override // com.google.android.gms.internal.firebase_abt.zzj
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzd zzdVar = (zzd) super.clone();
        zzh.zza(this, zzdVar);
        return zzdVar;
    }

    public final boolean zza(zza zzaVar, int i) throws IOException {
        int position = zzaVar.getPosition();
        if (!zzaVar.zzb(i)) {
            return false;
        }
        int i2 = i >>> 3;
        b bVar = new b(i, zzaVar.zza(position, zzaVar.getPosition() - position));
        a aVar = null;
        zzf zzfVar = this.zzs;
        if (zzfVar == null) {
            this.zzs = new zzf();
        } else {
            aVar = zzfVar.zzg(i2);
        }
        if (aVar == null) {
            aVar = new a();
            this.zzs.zza(i2, aVar);
        }
        aVar.a(bVar);
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_abt.zzj
    /* renamed from: zzj */
    public final /* synthetic */ zzj clone() throws CloneNotSupportedException {
        return (zzd) clone();
    }
}
