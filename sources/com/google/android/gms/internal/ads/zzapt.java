package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzapt extends zzaxv {
    private final Object mLock;
    private final zzapm zzdsj;
    private final zzaxg zzdsk;
    private final zzasm zzdsl;
    private final zzapw zzdta;
    private Future<zzaxf> zzdtb;

    public zzapt(Context context, com.google.android.gms.ads.internal.zzbb zzbbVar, zzaxg zzaxgVar, zzcu zzcuVar, zzapm zzapmVar, zzaba zzabaVar) {
        this(zzaxgVar, zzapmVar, new zzapw(context, zzbbVar, new zzazs(context), zzcuVar, zzaxgVar, zzabaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        synchronized (this.mLock) {
            if (this.zzdtb != null) {
                this.zzdtb.cancel(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        int i;
        zzaxf zzaxfVar;
        zzaxf zzaxfVar2 = null;
        try {
            try {
                synchronized (this.mLock) {
                    this.zzdtb = zzayf.zza(this.zzdta);
                }
                zzaxfVar2 = this.zzdtb.get(60000L, TimeUnit.MILLISECONDS);
                i = -2;
            } catch (TimeoutException unused) {
                zzbbd.zzeo("Timed out waiting for native ad.");
                this.zzdtb.cancel(true);
                i = 2;
            }
        } catch (InterruptedException | CancellationException | ExecutionException unused2) {
            i = 0;
        }
        if (zzaxfVar2 != null) {
            zzaxfVar = zzaxfVar2;
        } else {
            zzaxg zzaxgVar = this.zzdsk;
            zzasi zzasiVar = zzaxgVar.zzeag;
            zzwb zzwbVar = zzasiVar.zzdwg;
            zzasm zzasmVar = this.zzdsl;
            int i2 = zzasmVar.orientation;
            long j = zzasmVar.zzdlx;
            String str = zzasiVar.zzdwj;
            long j2 = zzasmVar.zzdye;
            zzwf zzwfVar = zzaxgVar.zzbst;
            long j3 = zzasmVar.zzdyc;
            long j4 = zzaxgVar.zzehn;
            long j5 = zzasmVar.zzdyh;
            String str2 = zzasmVar.zzdyi;
            JSONObject jSONObject = zzaxgVar.zzehh;
            zzasm zzasmVar2 = zzaxgVar.zzehy;
            zzaxfVar = new zzaxf(zzwbVar, null, null, i, null, null, i2, j, str, false, null, null, null, null, null, j2, zzwfVar, j3, j4, j5, str2, jSONObject, null, null, null, null, zzasmVar2.zzdyu, zzasmVar2.zzdyv, null, null, zzasmVar.zzdyy, zzaxgVar.zzehw, zzasmVar2.zzbph, false, zzasmVar2.zzdzc, null, zzasmVar2.zzbpi, zzasmVar2.zzdzd, zzasmVar2.zzdzf);
        }
        zzayh.zzelc.post(new Vb(this, zzaxfVar));
    }

    private zzapt(zzaxg zzaxgVar, zzapm zzapmVar, zzapw zzapwVar) {
        this.mLock = new Object();
        this.zzdsk = zzaxgVar;
        this.zzdsl = zzaxgVar.zzehy;
        this.zzdsj = zzapmVar;
        this.zzdta = zzapwVar;
    }
}
