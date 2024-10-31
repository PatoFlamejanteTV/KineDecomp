package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzlk implements zzlo, zzlp {
    private final Uri uri;
    private final zzll zzawo;
    private zzlp zzawp;
    private final zzow zzaxv;
    private final zzic zzaxw;
    private final int zzaxx;
    private boolean zzaxy;
    private final Handler zzwx;
    private zzgc zzxi;
    private final int zzawn = -1;
    private final String zzawr = null;
    private final zzge zzxb = new zzge();

    public zzlk(Uri uri, zzow zzowVar, zzic zzicVar, int i, Handler handler, zzll zzllVar, String str, int i2) {
        this.uri = uri;
        this.zzaxv = zzowVar;
        this.zzaxw = zzicVar;
        this.zzwx = handler;
        this.zzawo = zzllVar;
        this.zzaxx = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzfg zzfgVar, boolean z, zzlp zzlpVar) {
        this.zzawp = zzlpVar;
        this.zzxi = new zzly(-9223372036854775807L, false);
        zzlpVar.zzb(this.zzxi, null);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzb(zzlm zzlmVar) {
        ((C1032ol) zzlmVar).a();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzfg() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zzfh() {
        this.zzawp = null;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzb(zzgc zzgcVar, Object obj) {
        boolean z = zzgcVar.zza(0, this.zzxb, false).zzaan != -9223372036854775807L;
        if (!this.zzaxy || z) {
            this.zzxi = zzgcVar;
            this.zzaxy = z;
            this.zzawp.zzb(this.zzxi, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final zzlm zza(int i, zzot zzotVar) {
        zzpo.checkArgument(i == 0);
        return new C1032ol(this.uri, this.zzaxv.zzgs(), this.zzaxw.zzdz(), this.zzawn, this.zzwx, this.zzawo, this, zzotVar, null, this.zzaxx);
    }
}
