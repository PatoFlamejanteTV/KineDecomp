package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzja;
import java.util.concurrent.atomic.AtomicBoolean;

@zzgr
/* loaded from: classes.dex */
public abstract class zzgc implements zzgh<Void>, zzja.zza {
    protected final Context mContext;
    protected final zzgg.zza zzDd;
    protected final zzhs.zza zzDe;
    protected AdResponseParcel zzDf;
    private Runnable zzDg;
    protected final Object zzDh = new Object();
    private AtomicBoolean zzDi = new AtomicBoolean(true);
    protected final zziz zzoM;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgc(Context context, zzhs.zza zzaVar, zziz zzizVar, zzgg.zza zzaVar2) {
        this.mContext = context;
        this.zzDe = zzaVar;
        this.zzDf = this.zzDe.zzHD;
        this.zzoM = zzizVar;
        this.zzDd = zzaVar2;
    }

    private zzhs zzA(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzDe.zzHC;
        return new zzhs(adRequestInfoParcel.c, this.zzoM, this.zzDf.d, i, this.zzDf.f, this.zzDf.j, this.zzDf.l, this.zzDf.k, adRequestInfoParcel.i, this.zzDf.h, null, null, null, null, null, this.zzDf.i, this.zzDe.zzqn, this.zzDf.g, this.zzDe.zzHz, this.zzDf.n, this.zzDf.o, this.zzDe.zzHw, null);
    }

    @Override // com.google.android.gms.internal.zzgh
    public void cancel() {
        if (this.zzDi.getAndSet(false)) {
            this.zzoM.stopLoading();
            com.google.android.gms.ads.internal.zzp.g().zza(this.zzoM.getWebView());
            zzz(-1);
            zzid.zzIE.removeCallbacks(this.zzDg);
        }
    }

    @Override // com.google.android.gms.internal.zzja.zza
    public void zza(zziz zzizVar, boolean z) {
        com.google.android.gms.ads.internal.util.client.zzb.a("WebView finished loading.");
        if (this.zzDi.getAndSet(false)) {
            zzz(z ? zzft() : -1);
            zzid.zzIE.removeCallbacks(this.zzDg);
        }
    }

    @Override // com.google.android.gms.internal.zzgh
    /* renamed from: zzfr, reason: merged with bridge method [inline-methods] */
    public final Void zzfu() {
        com.google.android.gms.common.internal.zzx.b("Webview render task needs to be called on UI thread.");
        this.zzDg = new cl(this);
        zzid.zzIE.postDelayed(this.zzDg, zzby.zzvw.get().longValue());
        zzfs();
        return null;
    }

    protected abstract void zzfs();

    protected int zzft() {
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzz(int i) {
        if (i != -2) {
            this.zzDf = new AdResponseParcel(i, this.zzDf.k);
        }
        this.zzDd.zzb(zzA(i));
    }
}
