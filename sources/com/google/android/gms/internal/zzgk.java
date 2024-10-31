package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;

@zzgr
/* loaded from: classes.dex */
public class zzgk extends zzgf {
    protected zzei zzDA;
    private zzec zzDz;
    private final zzcg zzoo;
    private zzem zzox;
    private zzee zzzA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(Context context, zzhs.zza zzaVar, zzem zzemVar, zzgg.zza zzaVar2, zzcg zzcgVar) {
        super(context, zzaVar, zzaVar2);
        this.zzox = zzemVar;
        this.zzzA = zzaVar.zzHx;
        this.zzoo = zzcgVar;
    }

    @Override // com.google.android.gms.internal.zzgf, com.google.android.gms.internal.zzhz
    public void onStop() {
        synchronized (this.zzDh) {
            super.onStop();
            if (this.zzDz != null) {
                this.zzDz.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgf
    protected zzhs zzA(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzDe.zzHC;
        return new zzhs(adRequestInfoParcel.c, null, this.zzDf.d, i, this.zzDf.f, this.zzDf.j, this.zzDf.l, this.zzDf.k, adRequestInfoParcel.i, this.zzDf.h, this.zzDA != null ? this.zzDA.zzzu : null, this.zzDA != null ? this.zzDA.zzzv : null, this.zzDA != null ? this.zzDA.zzzw : AdMobAdapter.class.getName(), this.zzzA, this.zzDA != null ? this.zzDA.zzzx : null, this.zzDf.i, this.zzDe.zzqn, this.zzDf.g, this.zzDe.zzHz, this.zzDf.n, this.zzDf.o, this.zzDe.zzHw, null);
    }

    @Override // com.google.android.gms.internal.zzgf
    protected void zzh(long j) throws zzgf.zza {
        synchronized (this.zzDh) {
            this.zzDz = new zzek(this.mContext, this.zzDe.zzHC, this.zzox, this.zzzA, this.zzDf.t, j, zzby.zzvw.get().longValue(), this.zzoo);
        }
        this.zzDA = this.zzDz.zzc(this.zzzA.zzyW);
        switch (this.zzDA.zzzt) {
            case 0:
                return;
            case 1:
                throw new zzgf.zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zzgf.zza("Unexpected mediation result: " + this.zzDA.zzzt, 0);
        }
    }
}
