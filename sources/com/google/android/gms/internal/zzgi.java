package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzja;
import org.keyczar.Keyczar;

@zzgr
/* loaded from: classes.dex */
public class zzgi extends zzgc implements zzja.zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(Context context, zzhs.zza zzaVar, zziz zzizVar, zzgg.zza zzaVar2) {
        super(context, zzaVar, zzizVar, zzaVar2);
    }

    @Override // com.google.android.gms.internal.zzgc
    protected void zzfs() {
        if (this.zzDf.e != -2) {
            return;
        }
        this.zzoM.zzhe().zza(this);
        zzfz();
        com.google.android.gms.ads.internal.util.client.zzb.d("Loading HTML in WebView.");
        this.zzoM.loadDataWithBaseURL(com.google.android.gms.ads.internal.zzp.e().zzaz(this.zzDf.b), this.zzDf.c, "text/html", Keyczar.DEFAULT_ENCODING, null);
    }

    protected void zzfz() {
    }
}
