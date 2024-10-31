package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;

@zzgr
/* loaded from: classes.dex */
public abstract class zzgf extends zzhz {
    protected final Context mContext;
    protected final zzgg.zza zzDd;
    protected final zzhs.zza zzDe;
    protected AdResponseParcel zzDf;
    protected final Object zzDh;
    protected final Object zzpd;

    /* loaded from: classes.dex */
    protected static final class zza extends Exception {
        private final int zzDv;

        public zza(String str, int i) {
            super(str);
            this.zzDv = i;
        }

        public int getErrorCode() {
            return this.zzDv;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgf(Context context, zzhs.zza zzaVar, zzgg.zza zzaVar2) {
        super(true);
        this.zzpd = new Object();
        this.zzDh = new Object();
        this.mContext = context;
        this.zzDe = zzaVar;
        this.zzDf = zzaVar.zzHD;
        this.zzDd = zzaVar2;
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
    }

    protected abstract zzhs zzA(int i);

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        synchronized (this.zzpd) {
            com.google.android.gms.ads.internal.util.client.zzb.a("AdRendererBackgroundTask started.");
            int i = this.zzDe.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    com.google.android.gms.ads.internal.util.client.zzb.c(e.getMessage());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.e(e.getMessage());
                }
                if (this.zzDf == null) {
                    this.zzDf = new AdResponseParcel(errorCode);
                } else {
                    this.zzDf = new AdResponseParcel(errorCode, this.zzDf.k);
                }
                zzid.zzIE.post(new cm(this));
                i = errorCode;
            }
            zzid.zzIE.post(new cn(this, zzA(i)));
        }
    }

    protected abstract void zzh(long j) throws zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzi(zzhs zzhsVar) {
        this.zzDd.zzb(zzhsVar);
    }
}
