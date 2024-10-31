package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public abstract class zzapf implements zzazb<Void>, zzbho {
    protected final Context mContext;
    protected final zzbgg zzdin;
    private final zzapm zzdsj;
    private final zzaxg zzdsk;
    protected zzasm zzdsl;
    private Runnable zzdsm;
    private final Object zzdsn = new Object();
    private AtomicBoolean zzdso = new AtomicBoolean(true);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzapf(Context context, zzaxg zzaxgVar, zzbgg zzbggVar, zzapm zzapmVar) {
        this.mContext = context;
        this.zzdsk = zzaxgVar;
        this.zzdsl = this.zzdsk.zzehy;
        this.zzdin = zzbggVar;
        this.zzdsj = zzapmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public void cancel() {
        if (this.zzdso.getAndSet(false)) {
            this.zzdin.stopLoading();
            com.google.android.gms.ads.internal.zzbv.g();
            zzayp.zzi(this.zzdin);
            zzcq(-1);
            zzayh.zzelc.removeCallbacks(this.zzdsm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcq(int i) {
        if (i != -2) {
            this.zzdsl = new zzasm(i, this.zzdsl.zzdlx);
        }
        this.zzdin.zzadf();
        zzapm zzapmVar = this.zzdsj;
        zzaxg zzaxgVar = this.zzdsk;
        zzasi zzasiVar = zzaxgVar.zzeag;
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzbgg zzbggVar = this.zzdin;
        zzasm zzasmVar = this.zzdsl;
        List<String> list = zzasmVar.zzdlq;
        List<String> list2 = zzasmVar.zzdlr;
        List<String> list3 = zzasmVar.zzdyf;
        int i2 = zzasmVar.orientation;
        long j = zzasmVar.zzdlx;
        String str = zzasiVar.zzdwj;
        boolean z = zzasmVar.zzdyd;
        long j2 = zzasmVar.zzdye;
        zzwf zzwfVar = zzaxgVar.zzbst;
        long j3 = zzasmVar.zzdyc;
        long j4 = zzaxgVar.zzehn;
        long j5 = zzasmVar.zzdyh;
        String str2 = zzasmVar.zzdyi;
        JSONObject jSONObject = zzaxgVar.zzehh;
        zzawd zzawdVar = zzasmVar.zzdyr;
        List<String> list4 = zzasmVar.zzdys;
        List<String> list5 = zzasmVar.zzdyt;
        boolean z2 = zzasmVar.zzdyu;
        zzaso zzasoVar = zzasmVar.zzdyv;
        List<String> list6 = zzasmVar.zzdlu;
        String str3 = zzasmVar.zzdyy;
        zzum zzumVar = zzaxgVar.zzehw;
        zzasm zzasmVar2 = zzaxgVar.zzehy;
        zzapmVar.zzb(new zzaxf(zzwbVar, zzbggVar, list, i, list2, list3, i2, j, str, z, null, null, null, null, null, j2, zzwfVar, j3, j4, j5, str2, jSONObject, null, zzawdVar, list4, list5, z2, zzasoVar, null, list6, str3, zzumVar, zzasmVar2.zzbph, zzaxgVar.zzehx, zzasmVar2.zzdzc, zzasmVar.zzdls, zzasmVar2.zzbpi, zzasmVar2.zzdzd, zzasmVar2.zzdzf));
    }

    @Override // com.google.android.gms.internal.ads.zzbho
    public final void zzp(boolean z) {
        zzbbd.zzdn("WebView finished loading.");
        if (this.zzdso.getAndSet(false)) {
            zzcq(z ? -2 : 0);
            zzayh.zzelc.removeCallbacks(this.zzdsm);
        }
    }

    protected abstract void zzvz();

    @Override // com.google.android.gms.internal.ads.zzazb
    public final /* synthetic */ Void zzwa() {
        Preconditions.a("Webview render task needs to be called on UI thread.");
        this.zzdsm = new Qb(this);
        zzayh.zzelc.postDelayed(this.zzdsm, ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue());
        zzvz();
        return null;
    }
}
