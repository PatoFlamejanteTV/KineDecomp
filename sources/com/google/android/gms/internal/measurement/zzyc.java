package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzyc<M extends zzyc<M>> extends zzyi {
    protected zzye zzcet;

    @Override // com.google.android.gms.internal.measurement.zzyi
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzyc zzycVar = (zzyc) super.clone();
        zzyg.zza(this, zzycVar);
        return zzycVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public void zza(zzya zzyaVar) throws IOException {
        if (this.zzcet == null) {
            return;
        }
        for (int i = 0; i < this.zzcet.size(); i++) {
            this.zzcet.zzcf(i).a(zzyaVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public int zzf() {
        if (this.zzcet == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzcet.size(); i2++) {
            i += this.zzcet.zzcf(i2).a();
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    /* renamed from: zzzb */
    public final /* synthetic */ zzyi clone() throws CloneNotSupportedException {
        return (zzyc) clone();
    }

    public final <T> T zza(zzyd<M, T> zzydVar) {
        Gb zzce;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar == null || (zzce = zzyeVar.zzce(zzydVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzce.a(zzydVar);
    }

    public final boolean zza(zzxz zzxzVar, int i) throws IOException {
        int position = zzxzVar.getPosition();
        if (!zzxzVar.zzaq(i)) {
            return false;
        }
        int i2 = i >>> 3;
        Hb hb = new Hb(i, zzxzVar.zzs(position, zzxzVar.getPosition() - position));
        Gb gb = null;
        zzye zzyeVar = this.zzcet;
        if (zzyeVar == null) {
            this.zzcet = new zzye();
        } else {
            gb = zzyeVar.zzce(i2);
        }
        if (gb == null) {
            gb = new Gb();
            this.zzcet.zza(i2, gb);
        }
        gb.a(hb);
        return true;
    }
}
